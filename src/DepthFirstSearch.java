import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/09.
 */
//改进的带深度限制的深度优先搜索算法
public class DepthFirstSearch {
    public void depthFirstSearch(PackingSequence ps, int depth, int branch, int layer) throws Exception {
        if (depth != 0) {
            Container space = ps.spaceStack.peek();
            List<Block> blockList = new ArrayList<>();
            blockList = new GenBlockList().genBlockList(ps, space, ps.avail);
            if (blockList != null) {
                for (int i = 0; i < branch - 1; i++) {
                    new PlaceBlock().placeBlock(ps, blockList.get(i));
                    depthFirstSearch(ps, depth - 1, branch, layer);
                    new RemoveBlock().removeBlock(ps, blockList.get(i), space);
                }
            } else {
                new TransferSpace().transferSpace(space, ps.spaceStack);
                depthFirstSearch(ps, depth, branch, layer);
                new TransferSpaceBack().transferSpaceBack(space, ps.spaceStack);
            }
        } else {
            new Complete().complete(ps);
//            add ps to heap[layer]
        }
    }
}
