/**
 * Created by Administrator on 2017/11/08.
 */
//剩余空间的切割算法：划分未填充的空间
public class GenResidulSpace {
    public Container[] genResidulSpace(Container space, Block block) {
        Container[] c = new Container[3];
        double mx = space.lx - block.lx;
        double my = space.ly - block.ly;
        double mz = space.lz - block.lz;

        //spaceZ由块顶部的可放置矩形决定
        Container spaceZ = new Container().setContainer(block.ax, block.ay, mz);
        spaceZ.setCoordinatePoint(space.x, space.y, space.z+block.lz);
        c[0] = spaceZ;

        if (my >= mx) {
            Container spaceY = new Container().setContainer(space.lx, my, space.lz);
            spaceY.setCoordinatePoint(space.x, space.x+block.ly, space.z);
            Container spaceX = new Container().setContainer(mx, block.ly, space.lz);
            spaceX.setCoordinatePoint(space.x+block.lx, space.y, space.z);
            c[0].cutway = "Y";
            c[1] = spaceX;
            c[1].cutway = "Y";
            c[2] = spaceY;
            c[2].cutway = "Y";
        } else {
            Container spaceX = new Container().setContainer(mx, space.ly, space.lz);
            spaceX.setCoordinatePoint(space.x, space.x+block.ly, space.z);
            Container spaceY = new Container().setContainer(block.lx, my, space.lz);
            spaceY.setCoordinatePoint(space.x+block.lx, space.y, space.z);
            c[0].cutway = "X";
            c[1] = spaceY;
            c[1].cutway = "X";
            c[2] = spaceX;
            c[2].cutway = "X";
        }
        return c;
    }
}
