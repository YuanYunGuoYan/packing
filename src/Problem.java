import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */
//problem包含容器、box列表以及可用箱子向量，形式化表示了一个装箱问题
public class Problem {
    Container container;
    List<Box> boxList;
    int[] num;

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<Box> boxList) {
        this.boxList = boxList;
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }
}
