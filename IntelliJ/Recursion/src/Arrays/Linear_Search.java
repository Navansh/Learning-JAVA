package Arrays;

import java.util.ArrayList;

public class Linear_Search
{
    public static void main(String[] args) {
    int[] arr = {1,443,4231,31213,13321,12,2,3,4,4,4,4,4,4};
        System.out.println(Find(arr,32,0));
        System.out.println(FindIndex(arr,3,0));
        System.out.println(FindIndexfromLast(arr,3,arr.length-1));
//        FindAllIndexes(arr,4,0);
//        System.out.println(list);
        ArrayList<Integer> ans = FindAllIndexes(arr,4,0,new ArrayList<>());
        System.out.println(ans);

        System.out.println(FindAllIndexes2(arr,4,0));
    }
    public static boolean Find(int[] arr,int target, int index)
    {
        //here index means the starting index from where we'll start searching
        if (index==arr.length) {
            return false;
        }
        return arr[index] == target || Find(arr,target,index+1);
    }
    public static int FindIndex(int[] arr, int target, int index)
    {
        //here index means the starting index from where we'll start searching
        if (index==arr.length) {
            return -1;
        }
        if (arr[index] == target)
        {
            return index;
        }
        else {
            return FindIndex(arr, target, index + 1);
        }
    }
    public static int FindIndexfromLast(int[] arr, int target, int index)
    {
        if (index==-1) {
            return -1;
        }
        if (arr[index] == target)
        {
            return index;
        }
        else {
            return FindIndexfromLast(arr, target, index - 1);
        }
    }
    static ArrayList<Integer> list = new ArrayList<>();
    public static void FindAllIndexes(int[] arr, int target, int index)
    {
        //will give all the indexes in which a particular number is occurring
        //we'll add all the corresponding appearing indices to the Arraylist and print Arraylist at last
        //here index means the starting index from where we'll start searching
        if (index==arr.length) {
            return;
        }
        if (arr[index] == target)
        {
            list.add(index);
        }
        FindAllIndexes(arr, target, index + 1);

    }
    public static ArrayList<Integer> FindAllIndexes(int[] arr, int target, int index,ArrayList<Integer> list)
    {
        //will give all the indexes in which a particular number is occurring
        //we'll add all the corresponding appearing indices to the Arraylist and print Arraylist at last
        //here index means the starting index from where we'll start searching
        //all the list vars here are just ref vars who point to same object, hence if we change any the OG gets changed
        if (index==arr.length) {
            return list;
        }
        if (arr[index] == target)
        {
            list.add(index);
        }
        return FindAllIndexes(arr, target, index + 1,list);

    }
    public static ArrayList<Integer> FindAllIndexes2(int[] arr, int target, int index)
    {
        //VVI Concept
        //will give all the indexes in which a particular number is occurring
        //here index means the starting index from where we'll start searching

        //we'll here create new Arraylist at every function call
        ArrayList<Integer> list = new ArrayList<>();
        if (index==arr.length) {
            return list;
        }
        //this will add the ans to the list for that func call only
        if (arr[index] == target)
        {
            list.add(index);
        }
        //now any previous answers will be stored in the below arraylist
        ArrayList<Integer> ansfrombelowfunctioncalls = FindAllIndexes2(arr, target, index + 1);

        //now what we'll do is that whether this function call's arraylist has any ans in it's list, if yes then we'll
        //add ansfrombelowfunctioncalls into our current function call Arraylist
        list.addAll(ansfrombelowfunctioncalls);

        //now our list contains all the answers collectively till this current function call, hence return list
        return list;
    }

}
