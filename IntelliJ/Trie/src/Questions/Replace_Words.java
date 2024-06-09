package Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Replace_Words {
    public static void main(String[] args) {
        //https://leetcode.com/problems/replace-words/
        List<String> dictionary = new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.printf(replaceWords(dictionary, sentence));
    }
    static class TrieNode {
        HashMap<Character, TrieNode> hx;
        boolean endOfWord;
        public TrieNode() {
            endOfWord = false;
            hx = new HashMap<>();
        }
    }
    public static String replaceWords(List<String> dictionary, String sentence) {
        //insert the dictionary in the Trie
        TrieNode root = new TrieNode();
        insertInTrie(root, dictionary);
        //now search for each word
        String[] sent = sentence.split(" ");
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < sent.length; i++) {
            output.append(searchRoot(root, sent[i]));
            output.append(" ");
        }
        
        return output.substring(0, output.toString().length() - 1);
    }

    private static String searchRoot(TrieNode root, String s) {
        TrieNode temp = root;
        String out = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(temp.hx.containsKey(ch)) {
                if(temp.hx.get(ch).endOfWord) {
                    out = out + ch;
                    return out;
                } else {
                    out = out + ch;
                    temp = temp.hx.get(ch);
                }
            } else {
                return s;
            }
        }

        return out;
    }

    private static void insertInTrie(TrieNode root, List<String> dictionary) {
        //given the dictionary add each word to trie
        for (int i = 0; i < dictionary.size(); i++) {
            //get each root word from the dict and add to trie
            String toAdd = dictionary.get(i);
            TrieNode temp = root;
            for (int j = 0; j < toAdd.length(); j++) {
                char ch = toAdd.charAt(j);
                if(temp.hx.containsKey(ch)) {
                    //if yes then move to that
                    temp = temp.hx.get(ch);
                } else {
                    TrieNode forch = new TrieNode();
                    temp.hx.put(ch, forch);
                    temp = forch;
                }
            }
            temp.endOfWord = true;
        }
    }

}
