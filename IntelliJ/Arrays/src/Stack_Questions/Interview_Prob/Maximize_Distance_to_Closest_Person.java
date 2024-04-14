package Stack_Questions.Interview_Prob;

public class Maximize_Distance_to_Closest_Person {
    public static void main(String[] args) {

    }

    public int maxDistToClosest(int[] seats) {
        int max_possible_distance = Integer.MIN_VALUE;

        int i = -1;
        //this is the occurance index of 1 from left

        //now we need to find for right
        for (int j = 0; j < seats.length; j++) {
            if(seats[j] == 1) {
                //we've found the right 1
                if(i == -1) {
                    //means there exists no left 1
                    //there are all zeroes on the left side
                    max_possible_distance = Math.max(max_possible_distance, j);
                } else {
                    max_possible_distance = Math.max(max_possible_distance, (j - i)/2);
                }

                i = j;
            }
        }

        max_possible_distance = Math.max(max_possible_distance, seats.length - 1 - i);

        return max_possible_distance;
    }
}
