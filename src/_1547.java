import java.io.*;
import java.util.*;

public class _1547 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ball = 1;
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(ball==a) ball=b;
            else if(ball==b) ball=a;
        }
        System.out.println(ball);
    }
}
