import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/11/09.
 */

//多层启发式搜索算法
public class MultiLayerSearch {
    public double multiLayerSearch(List<Box> boxList, List<Block> blockTable, PackingSequence ps, int depth, int maxD, int MaxHeap, int effort) throws Exception {
        double maximum = 0;
        HashMap<Integer,List<PackingSequence>> heap=new HashMap<>();
//        result.volumeComplete=0;
        List<PackingSequence> psList=new ArrayList<>();
        psList.add(ps);
        heap.put(0,psList);
        for (int layer = 0; layer < depth - 1; layer++) {
            List<PackingSequence> layerList=heap.get(layer);

            //keep heap[layer] containing only the best MaxHeap elements
            if (layerList.size() > MaxHeap) {
                Collections.sort(layerList, new SortByPs());
                layerList = layerList.subList(0, MaxHeap - 1);
            }

            for (PackingSequence newps : layerList) {
                for (int d = 1; d < maxD; d++) {
                    int branch = getMaxB(d, effort);
                    new DepthFirstSearch().depthFirstSearch(boxList, blockTable, newps, d, branch, layer + d, heap.get(layer+d));
                }
            }
        }

        //return the maximun in heap[depth]
        List<PackingSequence> maxList=heap.get(depth);
        for (int i = 0; i < maxList.size() - 1; i++) {
            PackingSequence maxps = maxList.get(i);
            if (maxps.volume > maximum) {
                maximum = maxps.volume;
            }
        }

        return maximum;
    }

    public static int getMaxB(int d, int effort) {
        List<Integer> list = new ArrayList<>();
        int branch;
        int b = 1;
        while (Math.pow(b, d) <= effort) {
            list.add(b);
            b++;
        }
        Collections.sort(list);
        branch = list.get(list.size() - 1);
        return branch;
    }
}
