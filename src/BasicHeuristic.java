import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */
public class BasicHeuristic {

    public Plan basicHeuristic(boolean isComplex, SearchParams ps, Problem problem) {
        SimpleBlock simpleBlock = new SimpleBlock();
        ComplexBlock complexBlock = new ComplexBlock();
        List<Block> blockTable = new ArrayList<>();
        if (isComplex)
            blockTable = complexBlock.genComplexBlock(problem.container, problem.boxList, problem.num);
        else
            blockTable = simpleBlock.genSimpleBlock(problem.container, problem.boxList, problem.num);

        ps.avail = problem.num;
        ps.plan = null;
        ps.volume = 0;
        ps.spaceStack = null;
        ps.spaceStack.push(problem.container);

        while (ps.spaceStack != null) {
//            Container space=ps.spaceStack.pop();

        }
        return ps.plan;
    }

}

