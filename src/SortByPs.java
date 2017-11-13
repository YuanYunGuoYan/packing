import java.util.Comparator;

/**
 * Created by Administrator on 2017/11/13.
 */
public class SortByPs implements Comparator {

    public int compare(Object o1, Object o2) {
        PackingSequence ps1 = (PackingSequence) o1;
        PackingSequence ps2 = (PackingSequence) o2;

        if (ps1.getVolume() > ps2.getVolume())
            return -1;

        return 1;
    }
}
