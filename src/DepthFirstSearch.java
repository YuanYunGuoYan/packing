import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/09.
 */
//改进的带深度限制的深度优先搜索算法
public class DepthFirstSearch {
    public void depthFirstSearch(List<Box> boxList, List<Block> blockTable, PackingSequence ps, int depth, int branch, int layer, List<PackingSequence> heap) throws Exception {
        if (depth != 0) {
            Container space = ps.spaceStack.peek();
            List<Block> blockList = new ArrayList<>();
            blockList = new GenBlockList().genBlockList(blockTable, space, ps.avail);
            if (blockList != null) {
                for (int i = 0; i < branch - 1; i++) {
                    new PlaceBlock().placeBlock(boxList, ps, blockList.get(i));
                    depthFirstSearch(boxList, blockTable, ps, depth - 1, branch, layer, heap);
                    new RemoveBlock().removeBlock(boxList, ps, blockList.get(i), space);
                }
            } else {
                new TransferSpace().transferSpace(space, ps.spaceStack);
                depthFirstSearch(boxList, blockTable, ps, depth, branch, layer, heap);
                new TransferSpaceBack().transferSpaceBack(space, ps.spaceStack);
            }
        } else {
            new Complete().complete(ps);
            heap.add(ps);
        }
    }
}
