import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        long sysTime1 = System.currentTimeMillis();
        /*Trial Division*/
        System.out.println("Trial division starts.");
        BigInteger num = new BigInteger("18393075391668469672027802484408130559");
        int max = 20000000;
        for(int i = 2; i < max; i++){
            if(num.mod(BigInteger.valueOf(i)).equals(BigInteger.valueOf(0))){
                num = num.divide(BigInteger.valueOf(i));
                System.out.println(i);
            }
        }
        long sysTime2 = System.currentTimeMillis();
        System.out.println("Trial division is over in " + (sysTime2 - sysTime1)/1000 + " seconds.");
        /*Quadratic Sieve*/
        System.out.println("Quadratic Sieve starts.");
        int dim = 500;
        Factors factors = GetFactors.getFactors(num, dim);
        System.out.println("Found 501 Q(x) which is Y-smooth, and their vector contains module-2 exponents.");
        Congruence.congruence(factors);
        System.out.println("Found a result of Ax = 0, A is a 500*501 matrix.");
        GetSquare.getSquare(factors);
        long sysTime3 = System.currentTimeMillis();
        System.out.println("Quadratic sieve is over with " + (sysTime3 - sysTime2)/1000 + " seconds.");
    }
}
