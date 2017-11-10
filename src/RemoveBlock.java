import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/09.
 */
//块移除算法
public class RemoveBlock {
    public void removeBlock(PackingSequence ps, Block block, Container space) throws Exception {

        //恢复已使用的箱子
        HashMap<Integer, Integer> map = block.getRequire();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ps.avail[entry.getKey()] = ps.avail[entry.getKey()] + entry.getValue();
        }

        //从当前部分装载方案中移除当前所属的装载
        ps.plan.remove(new Plan().setPlan(space, block));

        //ps的箱子总体积
        ps.volume = ps.volume - block.realVolume();

        //移除空间堆栈栈顶的3个划分出来的剩余空间，并将已使用剩余空间重新插入栈顶
        ps.spaceStack.pop();
        ps.spaceStack.pop();
        ps.spaceStack.pop();
        ps.spaceStack.push(space);
    }
}
