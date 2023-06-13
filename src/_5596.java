import java.io.*;
import java.util.*;

public class _5596 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = getSum(br.readLine());
        int B = getSum(br.readLine());
        System.out.println(Math.max(A,B));
    }
    public static int getSum(String str){
        StringTokenizer st = new StringTokenizer(str);
        int sum = 0;
        while(st.hasMoreTokens()){
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}
