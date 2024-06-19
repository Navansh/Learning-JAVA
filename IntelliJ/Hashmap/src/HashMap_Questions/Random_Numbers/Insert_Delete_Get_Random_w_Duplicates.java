package HashMap_Questions.Random_Numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class Insert_Delete_Get_Random_w_Duplicates {
    public static void main(String[] args) {
        //https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/
    }

    class RandomizedCollection {
        HashMap<Integer, HashSet<Integer>> hx;
        ArrayList<Integer> arrList;
        Random r;

        public RandomizedCollection() {
            hx = new HashMap<>();
            arrList = new ArrayList<>();
            r = new Random();
        }

        public boolean insert(int val) {
            HashSet<Integer> numHashSet;
            boolean flag;
            if(hx.containsKey(val)) {
                numHashSet = hx.get(val);
                flag = false;
            } else {
                numHashSet = new HashSet<>();
                flag = true;
            }

            //hence you either have a hashset or you create one
            //now add the index where the new elements will be
            //stored in ArrayList
            numHashSet.add(arrList.size());
            //as arrList.size() - 1 par toh element hai hi abhi
            hx.put(val, numHashSet);
            arrList.add(val);

            return flag;
        }

        public boolean remove(int val) {
            HashSet<Integer> numHashSet;
            if(hx.containsKey(val)) {
                numHashSet = hx.get(val);

                //now we need anyone of the remIndex present inside
                //the set
                //hence we get this as :
                int remIndex = -1;
                for(int x : numHashSet) {
                    remIndex = x;
                    //we'll just take any of the index that we can take
                    //out from the set
                    break;
                }

                numHashSet.remove(remIndex);
                hx.put(val, numHashSet);
                //cz we've updated the set

                if(remIndex == arrList.size() - 1) {
                    //then just remove
                    arrList.remove(remIndex);
                    //there can be a case, when we do this
                    //the hashset becomes empty
                    if(hx.get(val).isEmpty()) {
                        //remove the hashSet for this val
                        //so that when we insert again
                        //it won't just return false
                        //because of containsKey
                        hx.remove(val);
                    }
                    return true;
                }

                //now get the element at the last index of the arrList
                int lastEleIndex = arrList.size() - 1;
                int lastElement = arrList.get(arrList.size() - 1);
                //now we'll swap the remIndex value with the last index
                swap(arrList, remIndex, arrList.size() - 1);

                //now remove the last index element
                arrList.remove(arrList.size() - 1);

                //now update the position of lastElement in the HashMap
                HashSet<Integer> s = hx.get(lastElement);
                //first remove the last index and then add the new
                //index where our lastElement resides now
                s.remove(lastEleIndex);
                s.add(remIndex);
                hx.put(lastElement, s);

                //when the Hashset of particular element becomes
                //empty, meaning the element is completely removed
                //hence we should return false
                //but when we check in this remove function
                //it wil still give containsKey as true, as that ele is still
                //present, only its HashSet is empty

                //hence jaate jaate we check for that also
                if(hx.get(val).size() == 0) {
                    //remove the hashSet for this val
                    hx.remove(val);
                }
                return true;
            } else {
                return false;
            }
        }

        public int getRandom() {
            //we were able to keep this same with duplicates also
            //using all the changes we made
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
