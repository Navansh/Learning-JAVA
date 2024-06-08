package Questions;

import java.util.HashMap;

public class Check_given_String_is_Present {
    public static void main(String[] args) {
        int[] arr = new int[45];
        
    }

    class TrieNode {
//        char val;
        //we don't actually need character data, as we can just use HashMap for that
        //cz we already know this data and that's why we're able to find that
        //node, with this value from the HashMap
        //and its not like that ki we can search the node using this data, we
        //cannot, we have to travel through the parent node and then only
        //we'll be able to get to this Node
        HashMap<Character, TrieNode> hx;
        boolean endOfWord;

        public TrieNode() {
//            this.val = val;
            hx = new HashMap<>();
            endOfWord = false;
            //this will represent the node where our word will end
            //otherwise we won't know
        }
    }

    boolean searchForWord(TrieNode root, String data) {
        //given string check if its one of the N strings given
        //so we already formed the trie for the N strings, and we've the root of it
        //hence we just check if the given string is part of that or not
        TrieNode temp = root;

        for (int i = 0; i < data.length(); i++) {
            char ch = data.charAt(i);
            if(temp.hx.containsKey(ch)) {
                //if yes then move forward to that Node
                temp = temp.hx.get(ch);
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

        return temp.endOfWord && true;
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
}
