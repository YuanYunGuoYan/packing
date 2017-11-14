/**
 * Created by Administrator on 2017/11/08.
 */
//剩余空间转移算法：当可行块列表为空时，TransferSpace尝试将space中可利用的部分转移到堆栈中相应的剩余空间
public class TransferSpace {

    public void transferSpace(Container space, SpaceStack spaceStack) throws Exception {
        Container space1, space2;
        spaceStack.pop();
        if (!spaceStack.isEmpty()) {
            space1 = spaceStack.peek();
            spaceStack.pop();
        } else {
            space1 = null;
        }
        if (!spaceStack.isEmpty()) {
            space2 = spaceStack.peek();
        } else {
            space2 = null;
        }

        if (space1 != null && space2 != null) {
            if (space.n == space1.n && space.n == space2.n) {
                if (space.cutway.equals("Y")) {
//                    transfer.setContainer(space1.lx, space.ly, space.lz);
                    space1.ly=space.ly+space1.ly;
                    spaceStack.push(space1);
                } else if (space.cutway.equals("X")) {
//                    transfer.setContainer(space.lx, space1.ly, space.lz);
                    space1.lx=space.lx+space1.lx;
                    spaceStack.push(space1);
                }
            }
        }
    }
}
