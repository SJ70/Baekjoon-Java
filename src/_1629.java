import java.math.BigInteger;
import java.util.Scanner;

public class _1629 {
    static BigInteger C;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        BigInteger A = new BigInteger(sc.next());
        int B = sc.nextInt();
        C = new BigInteger(sc.next());
        System.out.println(POW(A,B).remainder(C));
    }
    public static BigInteger POW(BigInteger A, int B){
        if(A.compareTo(C)>0) A=A.remainder(C);
        if(B==1) return A;
        if(B%2==0) return POW(A.multiply(A),B/2);
        else return POW(A.multiply(A),B/2).multiply(A);
    }
}