import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */
public class Plan {
    Container container;
    Block block;

    //被装载箱子的总体积
    public double volume(List<Box> boxList){
        return this.block.complexBlockRealVolume(boxList);
    }

    public Container getContainer() {
        return container;
    }

    public void setContainer(Container container) {
        this.container = container;
    }

    public Block getBlock() {
        return block;
    }

    public void setBlock(Block block) {
        this.block = block;
    }
}
