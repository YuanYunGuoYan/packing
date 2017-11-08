import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */
/*装载序列，它的每个元素对应装载阶段的一个选择。比如有装载ps,
    ps[k]表示在第K装载阶段应选择的块号
 */
public class PackingSequence {
    int[] avail;        //各种剩余箱子的数目
    List<Plan> plan;         //一个放置列表
    SpaceStack spaceStack;   //剩余空间堆栈
    double volume;          //被装载箱子的总体积

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public int[] getAvail() {
        return avail;
    }

    public void setAvail(int[] avail) {
        this.avail = avail;
    }

    public SpaceStack getSpaceStack() {
        return spaceStack;
    }

    public void setSpaceStack(SpaceStack spaceStack) {
        this.spaceStack = spaceStack;
    }

    public List<Plan> getPlan() {
        return plan;
    }

    public void setPlan(List<Plan> plan) {
        this.plan = plan;
    }
}
