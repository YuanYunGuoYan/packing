
/**
 * Created by Administrator on 2017/11/07.
 */
//一个放置是一个剩余空间和块的二元组
public class Plan {
    Container container;
    Block block;

    public Plan setPlan(Container container, Block block) {
        this.container = container;
        this.block = block;
        //块的参考点和剩余空间的参考点重合
        this.block.x = this.container.x;
        this.block.y = this.container.y;
        this.block.z = this.container.z;
        return this;
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
