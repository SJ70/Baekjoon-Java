import java.io.*;
import java.util.*;

public class _1673 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int N = sc.nextInt();
            int K = sc.nextInt();
            int result = 0;
            while(true){
                int add = N/K;
                result += K*add;
                N = N + add - K*add;
                if(N<K){
                    result+=N;
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
