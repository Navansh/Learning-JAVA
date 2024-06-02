package Questions;

import java.util.Arrays;

public class Insertion_and_Search_using_Arrays {
    static final int ALPHABET_SIZE = 26;

    // trie node
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];

        // isEndOfWord is true if the node represents
        // end of a word
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;
            Arrays.fill(children, null);
        }
    };

    static void insert(TrieNode root, String data) {
        TrieNode temp = root;

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            int position = ch - 'a';
            //check if the root contains a child named ch
            if(temp.children[position] !=null) {
                //means there is this node present already
                //so take us to that node
                temp = temp.children[position];
            } else {
                //create a node with the given character value and attatch it
                //to the root node ( accessing it here using temp )
                TrieNode forch = new TrieNode();
                temp.children[position] = forch;
                temp = forch;
            }
        }

        temp.isEndOfWord = true;
    }

    //Function to use TRIE data structure and search the given string.
    static boolean search(TrieNode root, String data) {
        // Your code here
        TrieNode temp = root;

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            int position = ch - 'a';

            if(temp.children[position] !=null) {
                //if yes then move forward to that Node
                temp = temp.children[position];
            } else {
                //meaning this word is not possible
                return false;
            }
        }
        //hence this for loop just checks if the I/P string is present
        //as string or substring in the trie or not

        //if after this all letters are there exactly in order in the trie as the
        //input data, we still don't return true, as that word maybe a substring
        //of the word we inserted and not an actual word
        //Ex : we inserted "dampen", and then we called the search func for word "damp"
        //then it is present in the trie, so it will return true
        //but "damp" is not part of our N strings
        //hence we verify it using endOfWord

        return temp.isEndOfWord && true;
    }
}
