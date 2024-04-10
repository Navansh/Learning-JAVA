package Questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Stack;

public class LC_735_Asteroid_Collision {
    public static void main(String[] args) {
        int[] asteroids = {8,-8};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stacker = new Stack<>();

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
