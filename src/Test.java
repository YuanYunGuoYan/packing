import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/02.
 */
public class Test {
    public static void main(String[] args) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        List<Box> boxList = new ArrayList<Box>();
        Box box1 = new Box();
        box1.setBox(3.00, 2.00, 1.00, 0);
        Box box2 = new Box();
        box2.setBox(1.00, 2.00, 3.00, 1);
        Box box3 = new Box();
        box3.setBox(1.00, 3.00, 2.00, 2);
        Box box4 = new Box();
        box4.setBox(5.00, 3.00, 2.00, 3);
        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);
        int[] num = new int[4];
        num[0] = 3;
        num[1] = 3;
        num[2] = 3;
        num[3] = 3;
        Container container = new Container();
        container.setContainer(10.00, 10.00, 10.00);
        SimpleBlock simpleBlock = new SimpleBlock();
        List<Block> blockTable = simpleBlock.genSimpleBlock(container, boxList, num);
        System.out.println("所有简单块：");
        print(blockTable);

        ComplexBlock complexBlock = new ComplexBlock();
        List<Block> blockTable1 = complexBlock.genComplexBlock(container, boxList, num);
        System.out.println("所有复杂块：");
        print(blockTable1);
    }

    public static void print(List<Block> blockTable) {
        for (Block block : blockTable) {
            System.out.println("长：" + block.getLx() + "," + "宽：" + block.getLy() + "," + "高："
                    + block.getLz() + "----体积:" + block.volume());
            HashMap<Integer, Integer> map = block.getRequire();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("箱子类型：" + entry.getKey() + " 数量：" + entry.getValue());
            }
//            System.out.println(block.getAx() + " " + block.getAy());
            System.out.println("***********");
        }
    }
}
