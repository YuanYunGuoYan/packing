import java.util.Comparator;

/**
 * Created by Administrator on 2017/11/10.
 */
//按适应度降序排列
public class SortByFitness implements Comparator {

    public int compare(Object o1, Object o2) {
        Block b1 = (Block) o1;
        Block b2 = (Block) o2;

        if (b1.fitness> b2.fitness)
            return -1;

        return 1;
    }
}
