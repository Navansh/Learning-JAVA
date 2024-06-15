package HashMap_Questions;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap_Construction {
    public static void main(String[] args) {

    }

    public static class HashMap<K, V> {
        //K and V are generic data types
        private class HMNode {
            //as we need to create an array of LL
            K Key;
            V Value;

            HMNode(K Key, V Value) {
                this.Key = Key;
                this.Value = Value;
            }
        }

        private int size;
        private LinkedList<HMNode>[] buckets;
        //an array of LinkedList

        public HashMap() {
            initBuckets(4);
            size = 0;
        }

        public void initBuckets(int N) {
            buckets = new LinkedList[N];
            for (int i = 0; i < buckets.length; i++) {
                buckets[i] = new LinkedList<>();
            }
        }

        public void put(K Key, V Value) throws Exception {
            int bucketIndex = hashFunction(Key);
            //this hashFunction will return the index in the array,
            //this key will go

            int dataIndex = findInBucket(bucketIndex, Key);
            //using this function we check whether
            //the given index has the key already

            //represents the dataIndex in a given BucketIndex
            //which is essentially a LinkedList

            //if yes then update the value, if not
            //then put the value

            if(dataIndex == -1) {
                //meaning the key is not present at the bucketIndex
                //which is linkedList array names buckets
                //uski ith linkedList mein present nhi

                //then create a new HMNode
                HMNode newNode = new HMNode(Key, Value);
                buckets[bucketIndex].add(newNode);
                //add function directly adds in Last
                //here we're using the inbuilt LinkedList
                //now increase the size of Hashmap
                size++;
            } else {
                HMNode old = buckets[bucketIndex].get(dataIndex);
                //the dataIndex is the index at which our key is present
                //in the buckets[bucketIndex] LinkedList
                old.Value = Value;
                //hence we just updated its value
            }

            //now calculate the lambda or the load factor
            double lambda = size * 1.0 / buckets.length;
            //buckets.length is the size of the array

            if (lambda > 2.0) {
                //means we now have average of more than 2 elements
                //per bucketIndex
                reHash();
                //increase the size of array buckets
                //or simply increase the number of buckets
            }
        }

        public boolean containsKey(K Key) {
            int bucketIndex = hashFunction(Key); //O(1)
            int dataIndex = findInBucket(bucketIndex, Key); //O(lambda)

            if(dataIndex == -1) {
                return false;
            } else {
                return true;
            }
        }

        public V get(K Key) throws Exception {
            int bucketIndex = hashFunction(Key); //O(1)
            int dataIndex = findInBucket(bucketIndex, Key); //O(lambda)

            if(dataIndex == -1) {
                return null;
            } else {
                HMNode node = buckets[bucketIndex].get(dataIndex);
                return node.Value;
            }
        }

        public V remove(K Key) {
            int bucketIndex = hashFunction(Key); //O(1)
            int dataIndex = findInBucket(bucketIndex, Key); //O(lambda)

            if(dataIndex == -1) {
                return null;
            } else {
                HMNode node = buckets[bucketIndex].remove(dataIndex);
                size--;
                return node.Value;
                //return the deleted node's value
            }
        }

        public int size() {
            return size;
        }

        public ArrayList<K> keyset() throws Exception {
            //this is an O(N) operation
            ArrayList<K> set = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {
                for(HMNode node : buckets[i]) {
                    //this represents a node in the ith LinkedList
                    //of the tempBuckets LinkedList array
                    set.add(node.Key);
                }
            }

            return set;
        }

        private void reHash() throws Exception {
            LinkedList<HMNode>[] tempbuckets = buckets;

            //now call the initbuckets with twice the length
            //of the old buckets
            initBuckets(2 * tempbuckets.length);
            //now the buckets name points to an array
            //which has double the indexes and all are empty
            //so buckets now doesn't have any prev data
            //that is now named as tempBuckets
            size = 0;

            for(int i = 0; i < tempbuckets.length; i++) {
                for(HMNode node : tempbuckets[i]) {
                    //this represents a node in the ith LinkedList
                    //of the tempBuckets LinkedList array
                    put(node.Key, node.Value);
                }
            }

            //after this line tempBuckets will go out of scope
            //so the Array it points to will be removed from memory

        }

        private int findInBucket(int bucketIndex, K key) {
            int dataIndex = 0;
            for(HMNode n: buckets[bucketIndex]) {
                if(n.Key.equals(key)) {
                    //as we're doing generic thing and for string
                    //it is advisable to use .equals, so we're
                    //using .equals for all


                    //then key already present
                    return dataIndex;
                }
                dataIndex++;
            }

            return -1;
            //meaning the key is not present at the given bucketIndex
        }

        private int hashFunction(K key) {
            //return the index in the array where the key should go
            int hashed = key.hashCode();
            //so anything that this .hashCode doesn't support
            //you cannot create that as a key
            //hence an array cannot be used a key

            //if you will still want to create it then you
            //need to write your own hashFunction which handles this


            //also the .equals function, which we used
            //in findInBucket won't also work for Pair Class
            //or an array, so you need to implement that also

            int index = Math.abs(hashed);
            //as the hashed value may be negative
            index = index % buckets.length;
            return index;
        }


    }
}
