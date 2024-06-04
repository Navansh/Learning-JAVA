package Questions;

import java.util.HashMap;

public class Find_URL {
    public static void main(String[] args) {

    }

    static class TrieNode {
        HashMap<String, TrieNode> hx;
        boolean endOfWord;
        //end of word not req here, as string lengths are diff, here all string
        //lengths are same and will terminate at leaf node only

        public TrieNode() {
            endOfWord = false;
            hx = new HashMap<>();
        }
    }

    //AMAZON BERLIN QUES
    public static boolean findURL(String[] arr, String query) {
        //given query check if the query is available in the string set given in arr
        //insert in Trie
        TrieNode root = new TrieNode();
        insertTrie(arr, root);
    }

    private static void insertTrie(String[] arr, TrieNode root) {
        TrieNode temp = root;
        //insert each string into Trie
        //firstly 
        for (int i = 0; i < arr.length; i++) {
            String get = arr[i];
            //now split this
            String[] toInsert = get.split("/");
            //now insert each of this String into the Trie
            if(temp.hx.containsKey())

        }

    }
}
