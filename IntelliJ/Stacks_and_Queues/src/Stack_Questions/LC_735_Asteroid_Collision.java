package Stack_Questions;

import java.util.Arrays;
import java.util.Stack;

public class LC_735_Asteroid_Collision {
    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                //we can decide the result of collision using difference of their values
                //now as both are of different signs so
                int resultant_collision = asteroids[i] + stack.peek();
                if(resultant_collision > 0) {
                    //meaning the element currently in the stack wins
                    //then make this asteroid value as 0
                    //as given in ques, no asteroid initially has 0 value
                    asteroids[i] = 0;
                } else if(resultant_collision < 0) {
                    //the incoming one wins and we pop this ele from stack
                    stack.pop();
                } else {
                    //meaning it is equal to 0
                    asteroids[i] = 0;
                    stack.pop();
                    //we destroyed both the asteroids
                }
            }
            //now after all this is a remains then append it to the stack
            if(asteroids[i] != 0) {
                stack.add(asteroids[i]);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;


    }

    public static int[] asteroidCollisionNotWorking(int[] asteroids) {
        //this represents wrong code******
        //means poora wrong nhi hai, but approach can be refined as here there are
        //a lot of ifs
        Stack<Integer> stacker = new Stack<>();
        //this will contain our result also

        for (int i = 0; i < asteroids.length; i++) {

            if(stacker.isEmpty()) {
                stacker.push(asteroids[i]);
                continue;
            }

            boolean sign = stacker.peek() > 0;
            boolean sign2 = asteroids[i] > 0;

            if(sign == sign2) {
                stacker.push(asteroids[i]);
            }

            //check if sign1 and sign2 are different
            while (sign != sign2) {
                //then these asteroids will collide
                //check who's bigger
                if(Math.abs(stacker.peek()) > Math.abs(asteroids[i])) {
                    break;
                } else {
                    stacker.pop();
                    if(stacker.isEmpty()) {
                        continue;
                    }
                }

                if(!stacker.isEmpty()) {
                    sign = stacker.peek() > 0;
                    sign2 = asteroids[i] > 0;
                } else {
                    stacker.push(asteroids[i]);
                }
            }
        }

        //finally we'll be left with our stacker stack
        Stack<Integer> second = new Stack<>();
        if(stacker.isEmpty()) {
            return new int[] {};
        } else {
            //transfer contents to another stack
            while (!stacker.isEmpty()) {
                second.push(stacker.pop());
            }
        }

        int[] ans = new int[second.size()];
        int i = 0;
        while (!second.isEmpty()) {
            ans[i++] = second.pop();
        }

        return ans;

    }
}
