package Question;

import java.util.ArrayList;
import java.util.List;

public class Count_of_Smaller_Numbers_After_Self {
    public static void main(String[] args) {
        //https://leetcode.com/problems/count-of-smaller-numbers-after-self/
        //IMP Question ***********
    }
    class Pair {
        int index;
        int val;
        Pair(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> lx = new ArrayList<>();

        //create the pair class array
        Pair[] pairer = new Pair[nums.length];
        int[] count = new int[nums.length];

        //nopw initialize the pairer array
        for (int i = 0; i < pairer.length; i++) {
            pairer[i] = new Pair(i, nums[i]);
        }

        modifiedMergeSort(pairer, count, 0, nums.length - 1);
        //this will givue us the filled count array

        for (int i = 0; i < count.length; i++) {
            lx.add(count[i]);
        }

        return lx;
    }

    static void modifiedMergeSort(Pair[] pairer, int[] count, int left, int right)
    {
        if(left>=right){
            return;
        }
        int mid = (left+right)/2;

        modifiedMergeSort(pairer, count,left,mid);
        modifiedMergeSort(pairer, count,mid+1,right);

        //till now we have got sorted array from left to mid and mid + 1 to right
        //now it is the job of merge to combine them into a total sorted array
        //reminder*** : here we have to sort in decreasing order


        mergeSpecial(pairer, count,left,mid,right);
    }

    static void mergeSpecial(Pair[] pairer, int[] count, int l, int m, int r)
    {
        //sort in decreasing order *******

        int size1 = m - l + 1;
        int size2 = r - (m + 1) + 1;

        Pair[] arr1 = new Pair[size1];
        Pair[] arr2 = new Pair[size2];

        //copy the items from the main array on to the arr1

        for (int i = 0; i < size1; i++) {
            arr1[i] = pairer[i + l];
        }

        //copy the items from the main array on to the arr2

        for (int i = 0; i < size2; i++) {
            arr2[i] = pairer[m + 1 + i];
        }

        //merge these 2 arrays

        int p1 = 0;
        int p2 = 0;
        int p3 = l;
        //as this is the count for the main array which we start from left and go till r


        while(p1 < size1 && p2 < size2){
            if(arr1[p1].val >  arr2[p2].val){
                count[arr1[p1].index] += size2 - p2;
                //this ^^ is the step when we create the ans
                pairer[p3] = arr1[p1];
                p1++;
                p3++;
            }else{
                //this is our normal case when the right element is equal to
                //or greater than the self ele
                //hence we just sort and put it in the order

                pairer[p3] = arr2[p2];
                p2++;
                p3++;
            }
        }

        while(p1 < size1) {
            //using size1 here and not mid as mid will give the mid of the complete arr
            //but we actually need mid - l
            pairer[p3] = arr1[p1];
            p1++;
            p3++;
        }

        while(p2 < size2){
            pairer[p3] = arr2[p2];
            p2++;
            p3++;
        }

    }


}
