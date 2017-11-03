import java.util.Comparator;

/**
 * Created by Administrator on 2017/11/02.
 */
//按体积降序排列
class SortByVolume implements Comparator {

    public int compare(Object o1, Object o2) {

        Block b1 = (Block) o1;

        Block b2 = (Block) o2;

        if (b1.volume() > b2.volume())
            return -1;

        return 1;
    }
}
