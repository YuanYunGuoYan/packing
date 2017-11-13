import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/11/09.
 */

//多层启发式搜索算法
public class MultiLayerSearch {
    public double multiLayerSearch(List<Box> boxList, List<Block> blockTable, PackingSequence ps, int depth, int maxD, int MaxHeap, int effort) throws Exception {
        double maximum = 0;
        List<PackingSequence>[] heap = new List[depth];
//        result.volumeComplete=0;
        heap[0].add(ps);
        for (int layer = 0; layer < depth - 1; layer++) {
//            keep heap[layer] containing only the best MaxHeap elements
            if (heap[layer].size() > MaxHeap) {
                Collections.sort(heap[layer], new SortByPs());
                List<PackingSequence> newPsList = new ArrayList<>();
                newPsList = heap[layer].subList(0, MaxHeap - 1);
                heap[layer].clear();
                heap[layer].addAll(newPsList);
            }
            for (PackingSequence newps : heap[layer]) {
                for (int d = 1; d < maxD; d++) {
                    int branch = getMaxB(d, effort);
                    new DepthFirstSearch().depthFirstSearch(boxList, blockTable, newps, d, branch, layer + d, heap[layer + d]);
                }
            }
        }

        //return the maximun in heap[depth]
        for (int i = 0; i < heap[depth].size() - 1; i++) {
            PackingSequence maxps = heap[depth].get(i);
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
