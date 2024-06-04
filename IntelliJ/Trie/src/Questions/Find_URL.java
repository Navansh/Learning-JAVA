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
    //DON'T KNOW IF THE CODE IS CORRECT ****************************
    public static boolean findURL(String[] arr, String query) {
        //given query check if the query is available in the string set given in arr
        //insert in Trie
        TrieNode root = new TrieNode();
        insertTrie(arr, root);
        return searchInTrie(root, query, 0);
    }

    private static boolean searchInTrie(TrieNode root, String query, int k) {
        String[] toFind = query.split("/");
        TrieNode temp = root;
        boolean usual = false;
        boolean id = false;

        for (int i = k; i < toFind.length; i++) {
            String to = toFind[i];
            if(temp.hx.containsKey(to)) {
                //go to that string
                usual = searchInTrie(temp.hx.get(to), query, i + 1);
                //check  if we get the ans going through the usual path
            } else if (temp.hx.containsKey("{id}")) {
                //now we have to find recursively
                id = searchInTrie(temp.hx.get("{id}"), query, i + 1);
                //next string se hi start karoge as ye toh milgyi ya phir id hai
            } else {
                return false;
            }
        }

        return usual || id;
        //meaning if usual is true then return true else if id is true then return
        //true else return false
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
            for (int j = 0; j < toInsert.length; j++) {
                String to = toInsert[i];
                if(temp.hx.containsKey(to)) {
                    //jump temp to that
                    temp = temp.hx.get(to);
                } else {
                    TrieNode forch = new TrieNode();
                    temp.hx.put(to, forch);
                    temp = temp.hx.get(to);
                }
            }
            temp.endOfWord = true;
        }
    }
}
