import java.util.*;

/**
 * Created by Administrator on 2017/11/01.
 */
public class SimpleBlock {

    /**
     * 枚举所有合法的组合(nx,ny,nz)，并将其对应的简单块block加入块表blockTable
     *
     * @param container 容器
     * @param boxList  用于装载的箱子清单
     * @param num   每一种类型箱子的数目
     * @return blockTable   生成的简单块块表
     */
    public List<Block> genSimpleBlock(Container container, List<Box> boxList, int[] num) {
        List<Block> blockTable = new ArrayList<>();
        for (Box box : boxList) {
            for (int nx = 1; nx <= num[box.type]; nx++) {
                for (int ny = 1; ny <= num[box.type] / nx; ny++) {
                    for (int nz = 1; nz <= num[box.type] / nx / ny; nz++) {
                        if (box.lx * nx <= container.lx && box.ly * ny <= container.ly && box.lz * nz <= container.lz) {
                            Block block = new Block();
                            block.setLx(box.lx * nx);
                            block.setLy(box.ly * ny);
                            block.setLz(box.lz * nz);
                            block.setAx(box.lx * nx);
                            block.setAy(box.ly * ny);
                            //设置block所需箱子类型，及其数量
                            block.setRequire(box.type, nx * ny * nz);
                            //简单块的复杂度为0
                            block.setLevel(0);
                            blockTable.add(block);
                        }
                    }
                }
            }
        }
        //按体积降序排列
        Collections.sort(blockTable, new SortByVolume());

        return blockTable;
    }


}
