import java.math.BigInteger;
class GL {
    static BigInteger gcd(BigInteger n, BigInteger n1){
        while(!n1.equals(BigInteger.valueOf(0))){
            BigInteger rem = n.mod(n1);
            n = n1;
            n1 = rem;
        }
        return n;
    }
    static int legendre(BigInteger a, BigInteger p){
        if (a.equals(BigInteger.valueOf(1))){
            return 1;
        }
        if (p.mod(a).equals(BigInteger.valueOf(0))) {
            return 0;
        }
        if (a.mod(BigInteger.valueOf(2)).equals(BigInteger.valueOf(0))) {
            return legendre(a.divide(BigInteger.valueOf(2)),p) * (((p.pow(2)).subtract(BigInteger.valueOf(1))).mod(BigInteger.valueOf(16)).equals(BigInteger.valueOf(0)) ? 1 : -1);
        }
        return legendre(p.mod(a), a) * ((((a.subtract(BigInteger.valueOf(1))).multiply(p.subtract(BigInteger.valueOf(1)))).mod(BigInteger.valueOf(8)).equals(BigInteger.valueOf(0)))? 1 : -1);
    }
}
