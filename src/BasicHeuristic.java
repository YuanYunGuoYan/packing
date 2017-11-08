import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */

//块装载启发式算法
public class BasicHeuristic {

    public List<Plan> basicHeuristic(boolean isComplex, int searchParams, Problem problem) throws Exception {
        List<Block> blockTable = new ArrayList<>();
        List<Plan> planList = new ArrayList<>();

        if(searchParams<=0){
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
//        ps.index=0;
        for (int i = 0; i < ps.length; i++) {
            while (ps[i].spaceStack != null) {
                try {
                    Container space = ps[i].spaceStack.pop();
                    List<Block> blockList = new GenBlockList().genBlockList(space, ps[i].avail);
                    if (blockList != null) {
                        Block block = new FindNextBlock().findNextBlock(ps[i], blockList);
                        ps[i].spaceStack.pop();
//                    ps.avail=ps.avail-block.getRequire();
//                    ps.plan=ps.plan+(space,block);
//                    ps.plan.volume=ps.plan.volume+block.complexBlockRealVolume();
//                    ps.spaceStack.push(GenResidulSpace(space,block));
                    } else {
//                    TransferSpace(space,ps.spaceStack);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            planList.add(ps[i].plan);
        }
        return planList;
    }

}

