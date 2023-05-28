import java.io.*;
import java.util.*;

public class _1057 {
    static int N;
    static boolean[] arr;
    public static void main(String[] args) throws IOException{
        init();
        int round = 1;
        int tmp = 2;
        loop : while(true){
            for(int i=0; i<N; i+=tmp){
                boolean left = arr[i];
                boolean right = arr[i+tmp/2];
//                System.out.println(i+","+(i+tmp/2));
                if(left && right) break loop;
                arr[i] = left || right;
            }
            round++;
            tmp*=2;
        }
        System.out.println(round);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        // N을 2의 제곱수로 변경
        int k=2;
        for(; k<N; k*=2);
        N = k;

        arr = new boolean[N];
        for(int i=0; i<2; i++){
            arr[ Integer.parseInt(st.nextToken())-1 ] = true;
        }
    }
}
