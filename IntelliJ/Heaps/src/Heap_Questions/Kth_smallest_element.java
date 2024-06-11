package Heap_Questions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Kth_smallest_element {
    public static void main(String[] args) {

    }

    public static int kthSmallest(int[] arr, int l, int r, int k)
    {
        //Your code here
        //we'll use maxHeap ( PQ) for this solution
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        //this will create a maxHeap

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        //now after we've added some k elements, for every next element, check the
        //following condition

        for (int i = k; i < arr.length; i++) {
            if(arr[i] < pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        //now if we want to return all k element that remove all elements from the
        // PQ and add it to an arrayList ( or some other Data. Struct.) and return

        //if we just want the kth smallest, we just do :
        return pq.peek();
    }

    public static int kthSmallestOptimized(int[] arr, int l, int r, int k)
    {
        //This is more optimized than the above one
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            while(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();

    }

    public static int kthLargestOptimized(int[] arr, int l, int r, int k)
    {
        //This is more optimized than the above one
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0;i<arr.length;i++){
            pq.add(arr[i]);
            while(pq.size()>k){
                pq.remove();
            }
        }
        return pq.peek();

    }
}
