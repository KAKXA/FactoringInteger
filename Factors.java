import java.math.BigInteger;
import java.util.ArrayList;

class Factors{
    ArrayList<BigInteger> sq;
    ArrayList<BigInteger> fac;
    ArrayList<ArrayList<Boolean>> bools;
    ArrayList<Boolean> finalBools;
    int dim;
    int vectorNums;
    BigInteger num;
    Factors(){
        sq = new ArrayList<>();
        fac = new ArrayList<>();
        bools = new ArrayList<>();
        finalBools = new ArrayList<>();
    }
}
