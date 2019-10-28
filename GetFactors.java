import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;

class GetFactors {
    static Factors getFactors(BigInteger num, int dim){
        BigInteger sqrtNum = (num.sqrt()).add(BigInteger.valueOf(1));

        Factors tempFacs = new Factors();
        HashMap<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        ArrayList<BigInteger> tempSq = new ArrayList<>();
        ArrayList<BigInteger> tempFac = new ArrayList<>();
        ArrayList<ArrayList<Boolean>> tempBools = new ArrayList<>();
        //The dimension of the vector
        int vectorNums = dim + 1;

        /*make vector*/
        map = MakeVector.makeVector(dim, num);

        /*iterate sqrtNum to sqrt + 1000000000*/
        Factors factors = new Factors();
        int matrixCount = 0;
        for (int i = 0; i <= 1000000000; i++) {
            BigInteger Square = sqrtNum.add(BigInteger.valueOf(i)).pow(2);
            BigInteger Num = Square.mod(num);
            BigInteger tempNum = Num;
            HashMap<Integer, Boolean> tempMap = new HashMap<>(map);
            for (HashMap.Entry<Integer, Boolean> entry : tempMap.entrySet()) {
                while (tempNum.mod(BigInteger.valueOf(entry.getKey())).equals(BigInteger.valueOf(0))) {
                    tempNum = tempNum.divide(BigInteger.valueOf(entry.getKey()));
                    entry.setValue(!entry.getValue());
                }
            }
            if (tempNum.equals(BigInteger.valueOf(1))) {
                ArrayList<Boolean> thisBool = new ArrayList<>(tempMap.values());
                tempBools.add(thisBool);
                tempFac.add(Num);
                tempSq.add(Square);
                matrixCount++;
                if (matrixCount == vectorNums) {
                    break;
                }
            }
        }

        ArrayList<ArrayList<Boolean>> rBools = new ArrayList<>();
        for(int i = 0; i < dim; i++){
            ArrayList<Boolean> temp = new ArrayList<>();
            for(int j = 0; j < vectorNums; j++) {
                temp.add(tempBools.get(j).get(i));
            }
            rBools.add(temp);
        }
        tempBools = rBools;

        tempFacs.sq = tempSq;
        tempFacs.fac = tempFac;
        tempFacs.bools = tempBools;
        tempFacs.dim = dim;
        tempFacs.vectorNums = vectorNums;
        tempFacs.num = num;
        return tempFacs;
    }
}
