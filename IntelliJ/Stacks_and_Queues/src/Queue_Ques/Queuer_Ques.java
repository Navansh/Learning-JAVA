package Queue_Ques;

public class Queuer_Ques {
    public static void main(String[] args) {
        int[] arr = {84,49,5,24,70,77,87,8};
        System.out.println(timeRequiredToBuy(arr, 3));
    }

    public static int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;

        while(tickets[k] != 0) {
            for(int i = 0; i < tickets.length; i++) {
                //check if tickets i is 0 ?
                if(tickets[k] == 0) {
                    break;
                }
                if(tickets[i] == 0) {
                    //do nothing
                } else {
                    time++;
                    tickets[i]--;
                }
            }
        }

        return time;
    }
}
