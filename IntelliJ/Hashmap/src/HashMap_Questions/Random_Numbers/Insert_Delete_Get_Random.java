package HashMap_Questions.Random_Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Insert_Delete_Get_Random {
    public static void main(String[] args) {
       //https://leetcode.com/problems/insert-delete-getrandom-o1/description/
        HashMap<Integer, Integer> hx = new HashMap<>();

    }

    class RandomizedSet {
        HashMap<Integer, Integer> hx;
        //hx.put(5, 1);
        //can use the function inside method, constructor etc.
        //and not here
        ArrayList<Integer> arrList;
        Random r;
        public RandomizedSet() {
            hx = new HashMap<>();
            arrList = new ArrayList<>();
            r = new Random();
        }

        public boolean insert(int val) {
            if(hx.containsKey(val)) {
                //acc to problem statement duplicates are not allowed
                return false;
            } else {
                //Insert in HashMap as well as ArrayList
                //first insert in ArrayList
                //and the index it will be added is the last index
                //of arrList
                int index = arrList.size();
                //as arrList.size() - 1 par toh element hai hi abhi
                arrList.add(val);
                hx.put(val, index);
                return true;
            }
        }

        public boolean remove(int val) {
            if(!hx.containsKey(val)) {
                return false;
            }
            //else :
            //firsly get the index in which in the ele is in
            //arraylist
            int removeIndex = hx.get(val);
            hx.remove(val);

            //this edge case is imp
            if(removeIndex == arrList.size() - 1) {
                //meaning what if there was just a single element
                //which we now removed
                //then we don't need to do swapping and all
                arrList.remove(arrList.size() - 1);
                return true;
            }

            //now swap the element at this index with the ele
            //at the last index

            int lastEle = arrList.get(arrList.size() - 1);
            //now we get the number at the last index

            swap(arrList, removeIndex, arrList.size() - 1);
            arrList.remove(arrList.size() - 1);

            //now update the position of lastElement in the HashMap
            hx.put(lastEle, removeIndex);
            return true;
        }

        public int getRandom() {
            //just select any random index from the arrayList
            //and return the number from there
            int randIndex = r.nextInt(0 , arrList.size());
            //and not size() - 1, cz the end is not inclusive
            return arrList.get(randIndex);
        }

        public void swap(ArrayList<Integer> arrList, int a, int b) {
            //swap index a element with index b
            int temp = arrList.get(a);
            arrList.set(a, arrList.get(b));
            arrList.set(b, temp);
        }
    }
}
