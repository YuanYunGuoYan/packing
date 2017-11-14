import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/02.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        //解决报错
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");

        //箱子向量，指定可用于装载的箱子
        List<Box> boxList = new ArrayList<Box>();

        //自定义箱子
        Box box1 = new Box();
        box1.setBox(2.0, 3.5, 3.0, 0);
        Box box2 = new Box();
        box2.setBox(2.0, 2.5, 3.0, 1);
        Box box3 = new Box();
        box3.setBox(1.0, 2.0, 3.0, 2);
//        Box box4 = new Box();
//        box4.setBox(5.00, 3.00, 2.00, 3);
        boxList.add(box1);
        boxList.add(box2);
//        boxList.add(box3);

        //自定义容器大小
        Container container = new Container();
        container.setContainer(15.0, 14.0, 14.5);

        Problem problem = new Problem();
        problem.setBoxList(boxList);
        problem.setContainer(container);
        problem.num = new int[2];
        problem.num[0] = 10;
        problem.num[1] = 20;
//        problem.num[2] = 30;

//        //生成简单块
//        SimpleBlock simpleBlock = new SimpleBlock();
//        List<Block> blockTable = simpleBlock.genSimpleBlock(container, boxList, problem.num);
//        System.out.println("所有简单块：");
//        print(blockTable);
//
//        //生成复合块
//        ComplexBlock complexBlock = new ComplexBlock();
//        List<Block> blockTable1 = complexBlock.genComplexBlock(container, boxList, num);
//        System.out.println("所有复杂块：");
//        print(blockTable1);
//
//        System.out.println("简单块总数量：" + blockTable.size());
//        System.out.println("复杂块总数量：" + blockTable1.size());

        List<Plan> planList = new BasicHeuristic().basicHeuristic(true, problem);
        System.out.println("共有"+planList.size()+"块");
        for (Plan plan:planList) {
            System.out.println(plan.block.realVolume(problem.boxList));
        }

    }

    public static void print(List<Block> blockTable) {
        java.text.DecimalFormat df = new java.text.DecimalFormat("#.00");
        for (Block block : blockTable) {
            System.out.println("长：" + block.getLx() + "," + "宽：" + block.getLy() + "," + "高："
                    + block.getLz() + "----体积:" + df.format(block.volume()));
            HashMap<Integer, Integer> map = block.getRequire();
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                System.out.println("箱子类型：" + entry.getKey() + " 数量：" + entry.getValue());
            }
//            System.out.println(block.getAx() + " " + block.getAy());
            System.out.println("***********");
        }
    }
}
