import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/09.
 */
//块装载算法
public class PlaceBlock {

    public void placeBlock(List<Box> boxList, PackingSequence ps, Block block) throws Exception {
        Container space = ps.spaceStack.peek();

        //移除栈顶空间
        ps.spaceStack.pop();

        //去掉已使用的箱子
        HashMap<Integer, Integer> map = block.getRequire();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ps.avail[entry.getKey()] = ps.avail[entry.getKey()] - entry.getValue();
        }

        //将块和栈顶空间结合成一个装载加入当前装载方案
        ps.plan.add(new Plan().setPlan(space, block));

        //ps的箱子总体积
        ps.volume = ps.volume + block.realVolume(boxList);

        //ps划分未填充的空间并加入到剩余空间堆栈中
        Container[] c = new GenResidulSpace().genResidulSpace(space, block);
        ps.spaceStack.push(c[0]);
        ps.spaceStack.push(c[1]);
        ps.spaceStack.push(c[2]);
    }
}
