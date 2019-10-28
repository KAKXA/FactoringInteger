import java.util.ArrayList;
import java.util.Collections;

class Congruence {
    private static int col;

    static void congruence(Factors factors){
        col = factors.vectorNums;
        int row = factors.dim;
        ArrayList<ArrayList<Boolean>> matrix = factors.bools;

        ArrayList<Integer> ranks = new ArrayList<>();
        ArrayList<Boolean> ans = new ArrayList<>();
        for(int i = 0; i < col; i++){
            ans.add(false);
        }
        for(ArrayList<Boolean> vec : matrix){
            ranks.add(getRank(vec));
        }
        for(int i = 0; i < row; i++){
            int num = maxIndex(i, row -1,ranks);
            Collections.swap(ranks,i,num);
            Collections.swap(matrix,i,num);
        }
        boolean sign = true;
        while(sign){
            sign = false;
            for(int i = 0; i < row - 1; i++){
                if(ranks.get(i) < ranks.get(i+1)){
                    Collections.swap(ranks,i,i+1);
                    Collections.swap(matrix,i,i+1);
                    sign = true;
                }
                else if(ranks.get(i) == 0){
                    break;
                }
                else if(ranks.get(i).equals(ranks.get(i+1))){
                    matrix.set(i+1,addAndMod(matrix.get(i),matrix.get(i+1)));
                    ranks.set(i+1, getRank(matrix.get(i+1)));
                    sign = true;
                }
            }
        }
        int record = col;
        for(int i = row - 1; i >= 0; i--){
            if(ranks.get(i) == 0){
                continue;
            }
            for(int j = col - ranks.get(i) + 1; j < record; j++){
                ans.set(j, true);
            }
            boolean tempBool = false;
            for(int j = col - ranks.get(i) + 1; j < col; j++){
                if(ans.get(j)){
                    tempBool ^= matrix.get(i).get(j);
                }
            }
            ans.set(col - ranks.get(i), tempBool);
            record = col - ranks.get(i);
        }
        factors.finalBools = ans;
    }

    private static int getRank(ArrayList<Boolean> ar){
        int r = col;
        for(Boolean i : ar){
            if(i){
                break;
            }
            else{
                r--;
            }
        }
        return r;
    }
    private static ArrayList<Boolean> addAndMod(ArrayList<Boolean> a, ArrayList<Boolean> b){
        for(int i = 0; i < col; i++){
            b.set(i,(a.get(i)^b.get(i)));
        }
        return b;
    }
    private static int maxIndex(int a, int b, ArrayList<Integer> ar){
        int max = ar.get(a);
        int maxIndex = a;
        for(int i = a + 1; i <= b; i++){
            if(ar.get(i) > max){
                maxIndex = i;
                max = ar.get(i);
            }
        }
        return maxIndex;
    }
}
