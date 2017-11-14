/**
 * Created by Administrator on 2017/11/09.
 */
//是TransferSpace算法的逆过程，用于取消被加入的剩余空间以便进行搜索
public class TransferSpaceBack {

    public void transferSpaceBack(Container space, SpaceStack spaceStack) throws Exception {
        Container space1, space2;
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
                    space1.ly=space1.ly-space.ly;
                } else if (space.cutway.equals("X")) {
//                    transfer.setContainer(space.lx, space1.ly, space.lz);
                    space1.lx=space1.lx-space.lx;
                }
                spaceStack.push(space1);
                spaceStack.push(space);
            }
        }
    }
}
