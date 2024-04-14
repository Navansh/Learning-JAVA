package Stack_Questions;

import java.util.ArrayList;

public class Pascal_Triangle {
    public static void main(String[] args) {
        
    }

    public ArrayList<ArrayList<Integer>> solve(int A) {

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        if(A==0)return ans;
        ArrayList<Integer>l=new ArrayList<>();
        l.add(1);
        ans.add(l);
        for(int i=1;i<A;i++){
            ArrayList<Integer>t=new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0||j==i){
                    t.add(1);
                }
                else{
                    t.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
                }
            }
            ans.add(t);
        }
        return ans;
    }
}
