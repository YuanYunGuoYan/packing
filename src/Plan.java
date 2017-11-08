import java.util.List;

/**
 * Created by Administrator on 2017/11/07.
 */
//一个放置是一个剩余空间和块的二元组
public class Plan {
    Container container;
    Block block;

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
