import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/07.
 */

//块装载启发式算法
public class BasicHeuristic {

    public List<Plan> basicHeuristic(boolean isComplex, int searchParams, Problem problem) throws Exception {
        List<Block> blockTable = new ArrayList<>();
        List<Plan> planList = new ArrayList<>();

        if (searchParams <= 0) {
            throw new Exception("请输入大于0的整数！");
        }

        PackingSequence[] ps = new PackingSequence[searchParams];
        if (isComplex)
            blockTable = new ComplexBlock().genComplexBlock(problem.container, problem.boxList, problem.num);
        else
            blockTable = new SimpleBlock().genSimpleBlock(problem.container, problem.boxList, problem.num);

        ps[0].avail = problem.num;
        ps[0].plan = null;
        ps[0].volume = 0;
        ps[0].spaceStack = null;
        ps[0].spaceStack.push(problem.container);

        for (int i = 0; i < ps.length; i++) {
            while (ps[i].spaceStack != null) {
                try {
                    Container space = ps[i].spaceStack.peek();
                    List<Block> blockList = new GenBlockList().genBlockList(blockTable, space, ps[i].avail);
                    if (blockList != null) {
                        Block block = new FindNextBlock().findNextBlock(ps[i], blockList);
                        ps[i].spaceStack.pop();

                        //ps[i+1]的剩余箱子
                        ps[i + 1].avail = ps[i].avail;
                        HashMap<Integer, Integer> map = block.getRequire();
                        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                            ps[i + 1].avail[entry.getKey()] = ps[i].avail[entry.getKey()] - entry.getValue();
                        }

                        //ps[i+1]的放置序列
                        ps[i].plan.add(new Plan().setPlan(space, block));
                        ps[i + 1].plan.addAll(ps[i].plan);

                        //ps[i+1]的箱子总体积
                        ps[i + 1].volume = ps[i].volume + block.complexBlockRealVolume(problem.boxList);

                        //ps[i+1]划分未填充的空间并插入堆栈
                        Container[] c = new GenResidulSpace().genResidulSpace(space, block);
                        ps[i + 1].spaceStack.push(c[0]);
                        ps[i + 1].spaceStack.push(c[1]);
                        ps[i + 1].spaceStack.push(c[2]);

                    } else {
//                    new TransferSpace(space,ps[i].spaceStack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
        return ps[searchParams].plan;
    }

}

