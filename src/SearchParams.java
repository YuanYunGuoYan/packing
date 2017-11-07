/**
 * Created by Administrator on 2017/11/07.
 */
public class SearchParams {
    int[] avail;
    Plan plan;
    SpaceStack spaceStack;
    double volume;

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

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public SpaceStack getSpaceStack() {
        return spaceStack;
    }

    public void setSpaceStack(SpaceStack spaceStack) {
        this.spaceStack = spaceStack;
    }
}
