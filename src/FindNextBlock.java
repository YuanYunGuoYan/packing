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

    public Block findNextBlock(PackingSequence ps, List<Block> blockList) throws Exception {
        Block block = new Block();
        for (int depth = 1; depth < maxD; depth++) {
            for (Block b : blockList) {
                Container space = ps.spaceStack.peek();
                new PlaceBlock().placeBlock(ps, b);
//                block.fitness=new MultiLayerSearch().multiLayerSearch(ps.depth,maxD,MaxHeap,effort);
                new RemoveBlock().removeBlock(ps, b, space);
            }
            Collections.sort(blockList, new SortByFitness());
            if (blockList.size() > 2 * N) {
//                blockList=the first half of blockList
            } else {
//                blockList=first N in blockList
            }
        }

        //返回最大适应度的块
        return block;
    }
}
