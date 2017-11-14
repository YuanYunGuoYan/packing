import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/11/08.
 */

//FindNextBlock算法选择一个块进行装载并加入当前部分装载方案
public class FindNextBlock {
    public final static int maxD = 2;
    public final static int MaxDepth = 6;
    public final static int N = 16;
    public final static int MaxHeap = 6;

    public Block findNextBlock(List<Box> boxList, List<Block> blockTable, PackingSequence ps, List<Block> blockList) throws Exception {
        Block block = new Block();
        double maximum=0;
        for (int depth = 1; depth < MaxDepth; depth++) {
            for (Block b : blockList) {
                Container space = ps.spaceStack.peek();
                new PlaceBlock().placeBlock(boxList, ps, b);
                block.fitness = new MultiLayerSearch().multiLayerSearch(boxList, blockTable, ps, ps.depth, maxD, MaxHeap, blockList.size());
                new RemoveBlock().removeBlock(boxList, ps, b, space);
            }
            Collections.sort(blockList, new SortByFitness());
            if (blockList.size() > 2 * N) {
                //保留blockList的前一半
                int num;
                if (blockList.size() % 2 == 0) {
                    num = (blockList.size() / 2) - 1;
                } else {
                    num = blockList.size() / 2;
                }
                blockList = blockList.subList(0, num);
            } else if (blockList.size() > N) {
                //保留blockList的前面N个数据
                blockList = blockList.subList(0, N - 1);
            }
        }

        //返回最大适应度的块
        block=blockList.get(0);
        return block;
    }
}
