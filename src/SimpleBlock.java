import java.util.*;

/**
 * Created by Administrator on 2017/11/01.
 */
public class SimpleBlock {

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
                            block.setRequire(box.type,nx*ny*nz);
                            block.setLevel(0);
                            blockTable.add(block);
                        }
                    }
                }
            }
        }
        Collections.sort(blockTable, new SortByVolume());

        return blockTable;
    }


}
