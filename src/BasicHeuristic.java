import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/07.
 */

//块装载启发式算法
public class BasicHeuristic {

    public List<Plan> basicHeuristic(boolean isComplex, Problem problem) throws Exception {
        List<Block> blockTable = new ArrayList<>();
        if (isComplex)
            blockTable = new ComplexBlock().genComplexBlock(problem.container, problem.boxList, problem.num);
        else
            blockTable = new SimpleBlock().genSimpleBlock(problem.container, problem.boxList, problem.num);

        PackingSequence ps = new PackingSequence();
        int index = 0;
        ps.avail = new int[problem.num.length];
        System.arraycopy(problem.num, 0, ps.avail, 0, problem.num.length);
        ps.plan = new ArrayList<Plan>();
        ps.volume = 0;
        ps.spaceStack = new SpaceStack();
        problem.container.setCoordinatePoint(0, 0, 0);
        problem.container.setN(0);
        ps.spaceStack.push(problem.container);

        while (!ps.spaceStack.isEmpty()) {
            try {
                Container space = ps.spaceStack.peek();
                List<Block> blockList = new GenBlockList().genBlockList(blockTable, space, ps.avail);
                if (blockList.size()!=0) {
                    Block block = new FindNextBlock().findNextBlock(problem.boxList, blockTable, ps, blockList);
                    block.setNO(++index);
                    ps.spaceStack.pop();

                    //ps的剩余箱子
                    HashMap<Integer, Integer> map = block.getRequire();
                    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                        ps.avail[entry.getKey()] = ps.avail[entry.getKey()] - entry.getValue();
                    }

                    //ps的放置序列
                    ps.plan.add(new Plan().setPlan(space, block));

                    //ps的箱子总体积
                    ps.volume = ps.volume + block.realVolume(problem.boxList);

                    //ps划分未填充的空间并插入堆栈
                    Container[] c = new GenResidulSpace().genResidulSpace(space, block);
                    c[0].n = index;
                    c[1].n = index;
                    c[2].n = index;
                    ps.spaceStack.push(c[0]);
                    ps.spaceStack.push(c[1]);
                    ps.spaceStack.push(c[2]);

                } else {
                    //转移空间
                    new TransferSpace().transferSpace(space, ps.spaceStack);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return ps.plan;
    }

}

