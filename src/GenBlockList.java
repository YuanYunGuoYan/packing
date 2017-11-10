import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/08.
 */
//可行块列表生成算法：用于从blockTable中获取适合当前剩余空间的可行块列表
public class GenBlockList {
    public List<Block> genBlockList(List<Block> blockTable, Container container, int[] avail) {
        List<Block> blockList = new ArrayList<>();
        for (Block block : blockTable) {
            if (block.lx <= container.lx && block.ly <= container.ly && block.lz <= container.lz) {
                HashMap<Integer, Integer> map = block.getRequire();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    if (avail[entry.getKey()] >= entry.getValue())
                        blockList.add(block);
                }
            }
        }
        return blockList;
    }
}
