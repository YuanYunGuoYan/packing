import java.util.*;

/**
 * Created by Administrator on 2017/11/02.
 */
public class ComplexBlock {
    final static int MaxLevel = 5;                  //块的最大复杂度为MaxLevel
    final static double MinFillRate = 0.98;         //复合块的填充率至少达到MinFillRate
    final static double MinAreaRate = 0.96;         //可行放置矩形与相应的复合块顶部面积的比至少达到MinAreaRate
    final static int MaxBlocks = 10000;             //生成块数目最大为MaxBlocks

    /**
     * 定义复合块的复合度(level)如下：
     * 简单块level为0，其它复合块的level为其子块的level的最大值加1
     * 比如两个level2的块合成为level3的复合块
     *
     * @param container
     * @param boxList
     * @param num
     * @return blockTable
     */

    public List<Block> genComplexBlock(Container container, List<Box> boxList, int[] num) {
        List<Block> blockTable = new ArrayList<>();
        blockTable = new SimpleBlock().genSimpleBlock(container, boxList, num);
        loop:
        for (int level = 0; level <= MaxLevel - 1; level++) {
            List<Block> newBlockTable = new ArrayList<>();
            for (int i = 0; i < blockTable.size() - 1; i++) {
                for (int j = i + 1; j < blockTable.size(); j++) {
                    Block a = blockTable.get(i);
                    Block b = blockTable.get(j);
                    if (a.level == level || b.level == level) {

                        //块数目达到MaxBlocks时停止生成
                        if (blockTable.size() >= MaxBlocks)
                            break loop;

                        HashMap<Integer, Integer> map1 = a.getRequire();
                        HashMap<Integer, Integer> map2 = b.getRequire();

                        //X轴方向复合
                        if (a.lz == b.lx && a.ax == a.lx) {
                            if (b.ax == b.ly) {
                                Block c1 = new Block();
                                c1.lx = a.lx + b.ly;
                                c1.ax = a.ax + b.ly;
                                c1.ly = Math.max(a.ly, b.lz);
                                c1.ay = Math.min(a.ay, b.lz);
                                c1.lz = a.lz;
                                c1.setRequire(addRequire(boxList, map1, map2));
                                c1.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c1, a, b))
                                    newBlockTable.add(c1);
                            }
                            if (b.ax == b.lz) {
                                Block c2 = new Block();
                                c2.lx = a.lx + b.lz;
                                c2.ax = a.ax + b.lz;
                                c2.ly = Math.max(a.ly, b.ly);
                                c2.ay = Math.min(a.ay, b.ay);
                                c2.lz = a.lz;
                                c2.setRequire(addRequire(boxList, map1, map2));
                                c2.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c2, a, b))
                                    newBlockTable.add(c2);
                            }
                        }
                        if (a.lz == b.ly && a.ax == a.lx) {
                            if (b.ax == b.lx) {
                                Block c3 = new Block();
                                c3.lx = a.lx + b.lx;
                                c3.ax = a.ax + b.lx;
                                c3.ly = Math.max(a.ly, b.lz);
                                c3.ay = Math.min(a.ay, b.lz);
                                c3.lz = a.lz;
                                c3.setRequire(addRequire(boxList, map1, map2));
                                c3.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c3, a, b))
                                    newBlockTable.add(c3);
                            }
                            if (b.ax == b.lz) {
                                Block c4 = new Block();
                                c4.lx = a.lx + b.lz;
                                c4.ax = a.ax + b.lz;
                                c4.ly = Math.max(a.ly, b.lx);
                                c4.ay = Math.min(a.ay, b.ax);
                                c4.lz = a.lz;
                                c4.setRequire(addRequire(boxList, map1, map2));
                                c4.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c4, a, b))
                                    newBlockTable.add(c4);
                            }
                        }
                        if (a.lz == b.lz && a.ax == a.lx) {
                            if (b.ax == b.lx) {
                                Block c5 = new Block();
                                c5.lx = a.lx + b.lx;
                                c5.ax = a.ax + b.lx;
                                c5.ly = Math.max(a.ly, b.ly);
                                c5.ay = Math.min(a.ay, b.ay);
                                c5.lz = a.lz;
                                c5.setRequire(addRequire(boxList, map1, map2));
                                c5.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c5, a, b))
                                    newBlockTable.add(c5);
                            }
                            if (b.ax == b.ly) {
                                Block c6 = new Block();
                                c6.lx = a.lx + b.ly;
                                c6.ax = a.ax + b.ly;
                                c6.ly = Math.max(a.ly, b.lx);
                                c6.ay = Math.min(a.ay, b.ax);
                                c6.lz = a.lz;
                                c6.setRequire(addRequire(boxList, map1, map2));
                                c6.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c6, a, b))
                                    newBlockTable.add(c6);
                            }
                        }

                        //Y轴方向复合
                        if (a.lz == b.lx && a.ay == a.ly) {
                            if (b.ay == b.ly) {
                                Block c7 = new Block();
                                c7.lx = Math.max(a.lx, b.lz);
                                c7.ax = Math.min(a.ax, b.lz);
                                c7.ly = a.ly + b.ly;
                                c7.ay = a.ay + b.ly;
                                c7.lz = a.lz;
                                c7.setRequire(addRequire(boxList, map1, map2));
                                c7.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c7, a, b))
                                    newBlockTable.add(c7);
                            }
                            if (b.ay == b.lz) {
                                Block c8 = new Block();
                                c8.lx = Math.max(a.lx, b.ly);
                                c8.ax = Math.min(a.ax, b.ay);
                                c8.ly = a.ly + b.lz;
                                c8.ay = a.ay + b.lz;
                                c8.lz = a.lz;
                                c8.setRequire(addRequire(boxList, map1, map2));
                                c8.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c8, a, b))
                                    newBlockTable.add(c8);
                            }
                        }
                        if (a.lz == b.ly && a.ay == a.ly) {
                            if (b.ay == b.lx) {
                                Block c9 = new Block();
                                c9.lx = Math.max(a.lx, b.lz);
                                c9.ax = Math.min(a.ax, b.lz);
                                c9.ly = a.ly + b.lx;
                                c9.ay = a.ay + b.lx;
                                c9.lz = a.lz;
                                c9.setRequire(addRequire(boxList, map1, map2));
                                c9.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c9, a, b))
                                    newBlockTable.add(c9);
                            }
                            if (b.ay == b.lz) {
                                Block c10 = new Block();
                                c10.lx = Math.max(a.lx, b.lx);
                                c10.ax = Math.min(a.ax, b.ax);
                                c10.ly = a.ly + b.lz;
                                c10.ay = a.ay + b.lz;
                                c10.lz = a.lz;
                                c10.setRequire(addRequire(boxList, map1, map2));
                                c10.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c10, a, b))
                                    newBlockTable.add(c10);
                            }
                        }
                        if (a.lz == b.lz && a.ay == a.ly) {
                            if (b.ay == b.lx) {
                                Block c11 = new Block();
                                c11.lx = Math.max(a.lx, b.ly);
                                c11.ax = Math.min(a.ax, b.ay);
                                c11.ly = a.ly + b.lx;
                                c11.ay = a.ay + b.lx;
                                c11.lz = a.lz;
                                c11.setRequire(addRequire(boxList, map1, map2));
                                c11.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c11, a, b))
                                    newBlockTable.add(c11);
                            }
                            if (b.ay == b.ly) {
                                Block c12 = new Block();
                                c12.lx = Math.max(a.lx, b.lx);
                                c12.ax = Math.min(a.ax, b.ax);
                                c12.ly = a.ly + b.ly;
                                c12.ay = a.ay + b.ly;
                                c12.lz = a.lz;
                                c12.setRequire(addRequire(boxList, map1, map2));
                                c12.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c12, a, b))
                                    newBlockTable.add(c12);
                            }
                        }

                        //Z轴方向复合
                        if (a.ax >= b.lx) {
                            if (a.ay >= b.ly) {
                                Block c13 = new Block();
                                c13.lx = a.lx;
                                c13.ax = b.ax;
                                c13.ly = a.ly;
                                c13.ay = b.ay;
                                c13.lz = a.lz + b.lz;
                                c13.setRequire(addRequire(boxList, map1, map2));
                                c13.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c13, a, b))
                                    newBlockTable.add(c13);
                            }
                            if (a.ay >= b.lz) {
                                Block c14 = new Block();
                                c14.lx = a.lx;
                                c14.ax = b.ax;
                                c14.ly = a.ly;
                                c14.ay = b.lz;
                                c14.lz = a.lz + b.ly;
                                c14.setRequire(addRequire(boxList, map1, map2));
                                c14.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c14, a, b))
                                    newBlockTable.add(c14);
                            }
                        }
                        if (a.ax >= b.ly) {
                            if (a.ay >= b.lx) {
                                Block c15 = new Block();
                                c15.lx = a.lx;
                                c15.ax = b.ay;
                                c15.ly = a.ly;
                                c15.ay = b.ax;
                                c15.lz = a.lz + b.lz;
                                c15.setRequire(addRequire(boxList, map1, map2));
                                c15.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c15, a, b))
                                    newBlockTable.add(c15);
                            }
                            if (a.ay >= b.lz) {
                                Block c16 = new Block();
                                c16.lx = a.lx;
                                c16.ax = b.ay;
                                c16.ly = a.ly;
                                c16.ay = b.lz;
                                c16.lz = a.lz + b.lx;
                                c16.setRequire(addRequire(boxList, map1, map2));
                                c16.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c16, a, b))
                                    newBlockTable.add(c16);
                            }
                        }
                        if (a.ax >= b.lz) {
                            if (a.ay >= b.lx) {
                                Block c17 = new Block();
                                c17.lx = a.lx;
                                c17.ax = b.lz;
                                c17.ly = a.ly;
                                c17.ay = b.ax;
                                c17.lz = a.lz + b.ly;
                                c17.setRequire(addRequire(boxList, map1, map2));
                                c17.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c17, a, b))
                                    newBlockTable.add(c17);
                            }
                            if (a.ay >= b.ly) {
                                Block c18 = new Block();
                                c18.lx = a.lx;
                                c18.ax = b.lz;
                                c18.ly = a.ly;
                                c18.ay = b.ay;
                                c18.lz = a.lz + b.lx;
                                c18.setRequire(addRequire(boxList, map1, map2));
                                c18.level = Math.max(a.level, b.level) + 1;
                                if (isComplexBlock(container, c18, a, b))
                                    newBlockTable.add(c18);
                            }
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

    //复合块的箱子需求
    private static HashMap<Integer, Integer> addRequire(List<Box> boxList, HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (Box box : boxList) {
            if (map1.containsKey(box.type) && !map2.containsKey(box.type)) {
                map3.put(box.type, map1.get(box.type));
            } else if (!map1.containsKey(box.type) && map2.containsKey(box.type)) {
                map3.put(box.type, map2.get(box.type));
            } else if (map1.containsKey(box.type) && map2.containsKey(box.type)) {
                map3.put(box.type, map1.get(box.type) + map2.get(box.type));
            }
        }
        return map3;
    }

    //比较两个块的箱子需求
    private static boolean compareMap(HashMap<Integer, Integer> map1, HashMap<Integer, Integer> map2) {
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            Integer m1value = entry.getValue() != null ? entry.getValue() : 0;
            Integer m2value = map2.get(entry.getKey()) != null ? map2.get(entry.getKey()) : 0;
            if (!m1value.equals(m2value)) {         //若两个map中相同key对应的value不相等
                return false;
            }
        }
        return true;
    }

    //去除重复块
    private static void removeDuplicateBlock(List<Block> list) {
        for (int i = 0; i < list.size() - 1; i++) {   //从左向右循环
            for (int j = list.size() - 1; j > i; j--) {  //从右往左内循环
                Block b1 = list.get(i);
                Block b2 = list.get(j);
                if (compareMap(b1.getRequire(), b2.getRequire())) {
                    double[] arr1 = new double[3];
                    double[] arr2 = new double[3];
                    arr1[0] = b1.lx;
                    arr1[1] = b1.ly;
                    arr1[2] = b1.lz;
                    arr2[0] = b2.lx;
                    arr2[1] = b2.ly;
                    arr2[2] = b2.lz;
                    Arrays.sort(arr1);
                    Arrays.sort(arr2);
                    if (Arrays.equals(arr1, arr2)) {
                        if (b1.ax == b2.ax && b1.ay == b2.ay)
                            list.remove(j);
                        if (b1.ax == b2.ay && b1.ay == b2.ax)
                            list.remove(j);
                    }
                }
            }
        }
    }

    //判断复合块是否满足生成条件
    private static boolean isComplexBlock(Container container, Block c, Block a, Block b) {
        double fillRate = (a.complexBlockRealVolume() + b.complexBlockRealVolume()) / c.volume();
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
        //复杂度最大为MaxLevel
        if (c.level > MaxLevel)
            return false;

        return true;
    }
}
