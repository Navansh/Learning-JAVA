package Stack_Questions.Pattern_2_Adapters;

import java.util.HashMap;
import java.util.Stack;

public class Maximum_frequency_Stack {
    public static void main(String[] args) {

    }
}

class FreqStack {
    HashMap<Integer, Integer> hx;
    HashMap<Integer, Stack<Integer>> storage;
    int mf;

    public FreqStack() {
        //the constructor
        hx = new HashMap<>();
        storage = new HashMap<>();
        mf = 0;
        //represents the max freq in the storage HashMap freq
    }

    public void push(int val) {
        //set the freq for the incoming ele
        if(hx.containsKey(val)) {
            int temp = hx.get(val);
            hx.put(val, temp + 1);
        } else {
            hx.put(val, 1);
        }

        //we can also use getOrDefault method here to do all of this

        int position = hx.get(val);
        //this represents the freq

        //now check if corresponding to this freq does a stack exist ?
        if(storage.containsKey(position)) {
            //then get the corresponding stack and add the ele to it
            Stack<Integer> stacker = storage.get(position);
            stacker.push(val);
        } else {
            //create the stack for that position ( freq )
            Stack<Integer> temp = new Stack<>();
            //push the ele to the stack
            temp.push(val);
            storage.put(position, temp);

            //now update the maxFreq var also
            mf = position;
        }
    }

    public int pop() {
        //we have to pop from the mf position
        // so get that stack
        Stack<Integer> temp = storage.get(mf);
        //pop from this stack
        int popped_ele = temp.pop();

        //now firstly update the freq of this ele in the HashMap hx
        int freq = hx.get(popped_ele);
        hx.put(popped_ele, freq - 1);

        //now if after doing temp.pop the stack becomes empty, then we decrease our mf

        if(temp.isEmpty()) {
            storage.remove(mf);
            //removing the corresponding stack is necessary otherwise it will give error
            mf--;
        }

        return popped_ele;
    }
}
