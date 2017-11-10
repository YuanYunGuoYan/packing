/**
 * Created by Administrator on 2017/11/09.
 */

//多层启发式搜索算法
public class MultiLayerSearch {
    public int multiLayerSearch(PackingSequence ps, int depth, int maxD, int MaxHeap, int effort) {
        int maximum;
//        result.volumeComplete=0;
        int[] heap = new int[depth];
//        add ps to heap[0];
        for (int layer = 0; layer < depth - 1; layer++) {
//            keep heap[layer] containing only the best MaxHeap elements
            for (PackingSequence newps : heap[layer]) {
                for (int d = 1; d < maxD; d++) {
//                    branch=max{b|b^d<=effort}
                    new DepthFirstSearch().depthFirstSearch(newps, d, branch, layer + d);
                }
            }
        }

        //return the maximun in heap[depth]
        return maximum;
    }
}
