package LL_Questions.DLL;

import java.util.HashMap;

public class LRU_Cache {
    public static void main(String[] args) {

    }

    class LRUCache {

        class Node {
            int key = 0;
            int val = 0;
            Node next;
            Node prev;

            public Node() {

            }

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.next = null;
                this.prev = null;
            }
        }

        HashMap<Integer, Node> hx;
        Node head;
        Node tail;
        int capacity;


        public LRUCache(int capacity) {
            //constructor
            hx = new HashMap<>();
            this.capacity = capacity;
            //create head and tail for the doubly LL also
            head = new Node();
            tail = new Node();

            //link them
            head.next = tail;
            tail.prev = head;


        }

        public Node delete(Node head, Node d) {
            //here we are given a node ( not head or tail )
            //which we need to delete and return its value


            //find the Node - 1 node
            //and find the Node + 1 node
            Node dm1 = d.prev;
            Node dp1 = d.next;

            dm1.next = dp1;
            dp1.prev = dm1;

            d.next = null;
            d.prev = null;

            return d;
        }

        public void insertBeforeTail(Node head, Node tail, Node n1) {
            //insert Node n1 before tail
            Node beforeTail = tail.prev;
            beforeTail.next = n1;
            n1.next = tail;
            n1.prev = tail.prev;
            tail.prev = n1;
        }

        public int get(int key) {
            //we have to return the val here corresponding to the key
            //but for edge case we check, if the key is present in our
            //DLL or not
            if(hx.containsKey(key)) {
                //means this app was opened and now we shift to before tail
                //or in the latest section
                int ans = hx.get(key).val;
                //delete it from its original place
                Node temp = delete(head, hx.get(key));
                //now insert it just before tail
                insertBeforeTail(head, tail, temp);
                return ans;
            } else {
                return -1;
            }

        }

        public void put(int key, int value) {
            //key is unique, val can be same

            //here if key is already there then update the value
            //otherwise normal put operation
            if(hx.containsKey(key)) {
                //means we need to update value
                //remove the node from its current position
                Node temp = delete(head, hx.get(key));
                temp.val = value;
                //update the value and now insert it before tail
                insertBeforeTail(head, tail, temp);
                //update this in hashMap also
                hx.put(key, temp);
            } else {
                //if its not present the check the capacity of the cache
                if(hx.size() == capacity){
                    //then we need to prune the oldest node, which hasn't been used
                    //hence remove the one right next to head

                    hx.remove(head.next.key);
                    delete(head , head.next);
                }
                //insert normally
                Node n1 = new Node(key, value);
                hx.put(key , n1);
                insertBeforeTail(head, tail, n1);
            }
        }
    }
}
