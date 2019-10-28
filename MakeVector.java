import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

class MakeVector {
    static HashMap<Integer,Boolean> makeVector(int dim, BigInteger num){
        HashMap<Integer, Boolean> map = new HashMap<>();
        /*make vector*/
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ar.add(2);
        int start = 2;
        int count = 10000;
        while(count > 0){
            boolean sign = true;
            for(int item : ar){
                if(start % item == 0){
                    sign = false;
                    break;
                }
            }
            if(sign){
                ar.add(start);
                count--;
            }
            start++;
        }
        /*The dimension of the vector*/
        int countDim = 0;
        for(int it : ar){
            if(1 == GL.legendre(num, BigInteger.valueOf(it))){
                map.put(it,false);
                if(countDim == dim - 1){
                    break;
                }
                else{
                    countDim++;
                }
            }
        }
        return map;
    }
}
