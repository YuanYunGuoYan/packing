import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/02.
 */
public class Test {
    public static void main(String[] args) {
        //解决报错
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

        //箱子向量，指定可用于装载的箱子
        List<Box> boxList = new ArrayList<Box>();

        //自定义箱子
        Box box1 = new Box();
        box1.setBox(3.00, 2.00, 1.00, 0);
        Box box2 = new Box();
        box2.setBox(1.00, 2.00, 3.00, 1);
        Box box3 = new Box();
        box3.setBox(1.00, 3.00, 2.00, 2);
//        Box box4 = new Box();
//        box4.setBox(5.00, 3.00, 2.00, 3);
        boxList.add(box1);
        boxList.add(box2);
        boxList.add(box3);

        //每个箱子类型对应的数量
        int[] num = new int[3];
        num[0] = 8;
        num[1] = 6;
        num[2] = 10;
//        num[3] = 3;

        //自定义容器大小
        Container container = new Container();
        container.setContainer(10.00, 10.00, 10.00);

        //生成简单块
        SimpleBlock simpleBlock = new SimpleBlock();
        List<Block> blockTable = simpleBlock.genSimpleBlock(container, boxList, num);
        System.out.println("所有简单块：");
        print(blockTable);

        //生成复合块
        ComplexBlock complexBlock = new ComplexBlock();
        List<Block> blockTable1 = complexBlock.genComplexBlock(container, boxList, num);
        System.out.println("所有复杂块：");
        print(blockTable1);
        System.out.println("复杂块总数量：" + blockTable1.size());
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
