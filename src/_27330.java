import java.io.*;
import java.util.*;

public class _27330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A_Cnt = Integer.parseInt(br.readLine());
        StringTokenizer A = new StringTokenizer(br.readLine());
        int B_Cnt = Integer.parseInt(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        boolean[] existsInB = new boolean[1001];
        for(int i=0; i<B_Cnt; i++){
            existsInB[Integer.parseInt(B.nextToken())] = true;
        }

        int score = 0;
        for(int i=0; i<A_Cnt; i++){
            score += Integer.parseInt(A.nextToken());
            if(existsInB[score]) score=0;
        }
        System.out.println(score);
    }
}
