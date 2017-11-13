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
                List<Block> newBlockList = new ArrayList<>();
                int num;
                if (blockList.size() % 2 == 0) {
                    num = (blockList.size() / 2) - 1;
                } else {
                    num = blockList.size() / 2;
                }
                newBlockList = blockList.subList(0, num);
                blockList.clear();
                blockList.addAll(newBlockList);
            } else {
                //保留blockList的前面N个数据
                List<Block> newBlockList = new ArrayList<>();
                newBlockList = blockList.subList(0, N - 1);
                blockList.clear();
                blockList.addAll(newBlockList);
            }
        }

        //返回最大适应度的块
        block = blockList.get(0);
        return block;
    }
}
