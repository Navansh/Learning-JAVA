package Questions;

import java.util.HashMap;

public class Prefix_match_with_other_Strings {
    public static void main(String[] args) {

    }

    class TrieNode {
        HashMap<Character, TrieNode> hx;
        boolean endOfWord;
        int prefixCount;

        public TrieNode() {
//            this.val = val;
            hx = new HashMap<>();
            endOfWord = false;
            //this will represent the node where our word will end
            //otherwise we won't know
            prefixCount = 0;
            //this will help us count the no of words with the prefix starting
            //with the value of that node or nodes traversed till that node
        }
    }

    void insertInTrie(TrieNode root, String data) {
        //this insertion insert one word in the trie
        TrieNode temp = root;

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);

            //check if the root contains a child named ch
            if(temp.hx.containsKey(ch)) {
                //means there is this node present already
                //so take us to that node
                temp = temp.hx.get(ch);
            } else {
                //create a node with the given character value and attatch it
                //to the root node ( accessing it here using temp )
                TrieNode forch = new TrieNode();
                temp.hx.put(ch, forch);
                temp = forch;
            }
            temp.prefixCount++;
            //as we have to do this for each character
        }

        temp.endOfWord = true;
        //as this for loop will end at the end node of the String
        //representing the ending character, so for that Node
        //we make the endOfWord as true, which means
        //while traversing from top and you find  this true, then you know
        //some word ended here
        //and that word value is what you've just traversed
        //from the root
    }

    public int klengthpref(String[] arr, int n, int k, String str) {
        TrieNode root = new TrieNode();

        for (int i = 0; i < arr.length; i++) {
            insertInTrie(root,arr[i]);
        }

        //aftrer we've inserted, calculate the substring that we want to find out
        if(str.length() < k) {
            return 0;
        }

        String subString = str.substring(0, k);
        //as the ending index is not included
        TrieNode temp = root;
        //now find this substring in the trie
        for (int i = 0; i < subString.length(); i++) {
            char ch = subString.charAt(i);

            if(temp.hx.containsKey(ch)) {
                //if yes then
                temp = temp.hx.get(ch);
            } else {
                return 0;
            }
        }

        return temp.prefixCount;
    }
}
