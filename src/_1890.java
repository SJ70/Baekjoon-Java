import java.io.*;
import java.util.*;

public class _1890 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] arr = new long[N][N];
        arr[0][0] = 1;

        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int num = Integer.parseInt(st.nextToken());
                if(r==N-1 && c==N-1) break;
                if(r+num<N) arr[r+num][c] += arr[r][c];
                if(c+num<N) arr[r][c+num] += arr[r][c];
            }
        }

        System.out.println(arr[N-1][N-1]);
    }
}
