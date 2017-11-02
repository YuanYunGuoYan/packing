import java.util.*;

/**
 * Created by Administrator on 2017/11/02.
 */
public class ComplexBlock {
    final static int MaxLevel = 5;
    final static double MinFillRate = 0.98;
    final static double MinAreaRate = 0.96;
    final static int MaxBlocks = 10000;

    public List<Block> genComplexBlock(Container container, List<Box> boxList, int[] num) {
        List<Block> blockTable = new ArrayList<>();
        blockTable = new SimpleBlock().genSimpleBlock(container, boxList, num);
        for (int level = 0; level <= MaxLevel - 1; level++) {
            List<Block> newBlockTable = new ArrayList<>();

            for (Block a : blockTable) {
                if (blockTable.size() >= MaxBlocks)
                    break;
                for (Block b : blockTable) {
                    if (b.equals(a))
                        continue;
                    if (a.level == level || b.level == level) {
                        int nx, ny, nz;
                        //X轴方向
                        if (a.ax == a.lx && b.ax == b.lx && a.lz == b.lz) {
                            Block c1 = new Block();
                            c1.lx = a.lx + b.lx;
                            c1.ly = Math.max(a.ly, b.ly);
                            c1.lz = Math.max(a.lz, b.lz);
                            c1.ax = a.ax + b.ax;
                            c1.ay = Math.min(a.ay, b.ay);
//                            nx = a.getRequire()[0] + b.getRequire()[0];
//                            ny = a.getRequire()[1] + b.getRequire()[1];
//                            nz = a.getRequire()[2] + b.getRequire()[2];
//                            c1.setRequire(nx, ny, nz);
                            c1.level = Math.max(a.level, b.level) + 1;
                            if (isComplexBlock(container, c1, a, b))
                                newBlockTable.add(c1);
                        }
                        //Y轴方向
                        if (a.ay == a.ly && b.ay == b.ly && a.lz == b.lz) {
                            Block c2 = new Block();
                            c2.lx = Math.max(a.lx, b.lx);
                            c2.ly = a.ly + b.ly;
                            c2.lz = Math.max(a.lz, b.lz);
                            c2.ax = Math.min(a.ax, b.ax);
                            c2.ay = a.ay + b.ay;
//                            nx = a.getRequire()[0] + b.getRequire()[0];
//                            ny = a.getRequire()[1] + b.getRequire()[1];
//                            nz = a.getRequire()[2] + b.getRequire()[2];
//                            c2.setRequire(nx, ny, nz);
                            c2.level = Math.max(a.level, b.level) + 1;
                            if (isComplexBlock(container, c2, a, b))
                                newBlockTable.add(c2);
                        }
                        //Z轴方向
                        if (a.ax >= b.lx && a.ay >= b.ly) {
                            Block c3 = new Block();
                            c3.lx = Math.max(a.lx, b.ly);
                            c3.ly = Math.max(a.ly, b.ly);
                            c3.lz = a.lz + b.lz;
                            c3.ax = b.ax;
                            c3.ay = b.ay;
//                            nx = a.getRequire()[0] + b.getRequire()[0];
//                            ny = a.getRequire()[1] + b.getRequire()[1];
//                            nz = a.getRequire()[2] + b.getRequire()[2];
//                            c3.setRequire(nx, ny, nz);
                            c3.level = Math.max(a.level, b.level) + 1;
                            if (isComplexBlock(container, c3, a, b))
                                newBlockTable.add(c3);
                        }
                    }
                }
            }

            blockTable.addAll(newBlockTable);
            removeDuplicateBlock(blockTable);
        }
        //按体积降序排列
        Collections.sort(blockTable, new SortByVolume());
        return blockTable;
    }

    //去除重复块
    public static void removeDuplicateBlock(List<Block> list) {
        for (int i = 0; i < list.size() - 1; i++) {   //从左向右循环
            for (int j = list.size() - 1; j > i; j--) {  //从右往左内循环
                Block b1 = list.get(i);
                Block b2 = list.get(j);
                if (b1.lx == b2.lx && b1.ly == b2.ly && b1.lz == b2.lz && b1.ax == b2.ax && b1.ay == b2.ay)
//                        && b1.require[0] == b2.require[0] && b1.require[1] == b2.require[1] &&
//                        b1.require[2] == b2.require[2])
                    list.remove(j);                     //相等则移除
            }
        }
    }

    public static boolean isComplexBlock(Container container, Block c, Block a, Block b) {
        double fillRate = (a.volume() + b.volume()) / c.volume();
        double areaRate = (c.ax * c.ay) / (c.lx * c.ly);
        //复合块大小不大于容器大小
        if (c.lx > container.lx || c.ly > container.ly || c.lz > container.lz)
            return false;
        //填充率至少达到MinFillRate
        if (fillRate < MinFillRate)
            return false;
        //空隙不能过大
        if (areaRate < MinAreaRate)
            return false;
        //复杂度最大为5
        if (c.level > MaxLevel)
            return false;

        return true;
    }
}
