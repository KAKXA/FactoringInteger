import java.math.BigInteger;
import java.util.ArrayList;

class GetSquare {
    static void getSquare(Factors factor){
        BigInteger num = factor.num;
        BigInteger sqrtNum = num.sqrt().add(BigInteger.valueOf(1));

        ArrayList<Boolean> finalBools = factor.finalBools;
        ArrayList<BigInteger> sq = factor.sq;
        ArrayList<BigInteger> fac = factor.fac;
        BigInteger temp1 = BigInteger.valueOf(1);
        BigInteger temp2 = BigInteger.valueOf(1);
        int vectorNums = factor.vectorNums;
        for(int i = 0; i < vectorNums; i++){
            if(finalBools.get(i)){
                temp1 = (fac.get(i)).multiply(temp1);//.mod(num);
                temp2 = sq.get(i).multiply(temp2);//.mod(num);
            }
        }
        BigInteger a1 = GL.gcd((temp1.sqrt()).add(temp2.sqrt()),num);
        BigInteger a2 = GL.gcd((temp1.sqrt()).subtract(temp2.sqrt()),num);
        System.out.println(a1);
        System.out.println(a2);
    }
}
