import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Bucket_Sort {
    public static void BucketSort(float[] arr){
        //create the buckets, according to the Logic :
        //logic : Jitna size of array, utni buckets
        int n = arr.length;
        ArrayList<Float>[] buckets = new ArrayList[n];
        // this will create an array of ArrayList ( of size : n ) of type float

        //Create empty buckets
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<Float>();
        }

        //add elements into our buckets, according to some logic
        //logic here : multiply the number by 10 and put it at index which is the
        // ones place of that number
        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) arr[i] * n;
            //where n is the size of array, here we took 10
            buckets[bucketIndex].add(arr[i]);
        }

        //sort each bucket individually
        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        //merge all individually sorted buckets to get our final sorted array
        int index = 0;
        for (int i = 0; i < buckets.length; i++) {
            ArrayList<Float> currentBucket = buckets[i];
            //now traverse each of this buckets and add their each element to the arr
            for (int j = 0; j < currentBucket.size() ; j++) {
                arr[index++] = currentBucket.get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] arr = { 0.42f, 0.32f, 0.25f, 0.52f, 0.23f, 0.47f, 0.51f, 0.92f, 0.08f, 0.75f, 0.63f};
        BucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
