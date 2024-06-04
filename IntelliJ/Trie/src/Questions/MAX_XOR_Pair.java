package Questions;

import java.util.HashMap;

public class MAX_XOR_Pair {
    public static void main(String[] args) {
        int[] arr =  {1, 2, 3, 4, 5, 6, 7};
        System.out.println(max_xor(arr, 5));
    }

    static class TrieNode {
        HashMap<Integer, TrieNode> hx;
//        boolean endOfWord;
        //end of word not req here, as string lengths are diff, here all string
        //lengths are same and will terminate at leaf node only

        public TrieNode() {
            hx = new HashMap<>();
        }
    }
    static TrieNode root = new TrieNode();
    //we'll create the global root var

    public static int max_xor(int arr[], int n) {
        //first we need to get the max set bits in a number in this array
        //we'll do our iteration for that number of times only, instead of doing
        //it 32 times

        int x = findMax(arr); // O(N)
        int lastSetBitPosition = lastSetBitPositionCalc(x); // O(32)
        //as max set bit usi number ki hongi joh largest hoga
        //(not in number of 1) wise, but in placevalue wise kiski set bit hai
        //this is the last position jab aapko 1 milega and uske baad bas 0 milega


        //create Trie now
        for (int i = 0; i < arr.length; i++) { // O(N * 32)
            insertInTrie(arr[i], lastSetBitPosition);
        }

        int ans = 0;

        for (int i = 0; i < arr.length; i++) { // O(N * 32)
            int a = arr[i];
            int b = searchInTrie(a, lastSetBitPosition);
            //find me the best number to make the max pair for a, within the given
            //number of set bits
            int xor = a ^ b;
            ans = Math.max(ans, xor);
        }

        return ans;
    }

    private static int searchInTrie(int a, int lastSetBitPosition) {
        //search for the best number to make the pair with a
        TrieNode temp = root;
        int b = 0;
        //this is what we've to build

        for (int i = lastSetBitPosition; i >= 0; i--) {
            int myBit = checkBit(a, i);
            int bitLookingFor = 1 - myBit;

            if(temp.hx.containsKey(bitLookingFor)) {
                //meaning we found the bit which is opp to a for the ith position
                //then add the value to b
                b = (int) (b + (1 << i) * bitLookingFor);
                //1 << i is just 2 ^i
                //by this we converted to decimal system
                //we are not forming xor here, we're just forming b here
                temp = temp.hx.get(bitLookingFor);
            } else {
                //if you don't get then bitLookingFor, then we continue with myBit
                //as that is default of the original number a, toh woh
                //toh present
                b = (int) (b + (1 << i) * myBit);
                temp = temp.hx.get(myBit);
            }
        }

        return b;
    }

    private static void insertInTrie(int a, int lastSetBitPosition) {
        TrieNode temp = root;

        //we first start inserting from the MSB position and then move to LSB
        for (int j = lastSetBitPosition; j >= 0; j--) {
            int myBit = checkBit(a, j);
            //for value a, what is the bit at jth index, 0 or 1

            if(temp.hx.containsKey(myBit)) {
                temp = temp.hx.get(myBit);
            } else {
                TrieNode forch = new TrieNode();
                temp.hx.put(myBit, forch);
                temp = temp.hx.get(myBit);
            }
        }
    }

    private static int checkBit(int a, int j) {
        int ans = a >> j;
        if((ans & 1) == 1) {
            return 1;
        }

        return 0;
    }

    private static int lastSetBitPositionCalc(int x) {
        int lastSetBitPosition = 0;
        //this is the bit index
        //hence this starts from right
        while (x != 0) {
            lastSetBitPosition++;
            x >>= 1;
        }
        return lastSetBitPosition;

    }

    private static int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for(int num : arr) {
            max = Math.max(max, num);
        }

        return max;
    }
}
