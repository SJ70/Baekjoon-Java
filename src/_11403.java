import java.io.*;
import java.util.*;

public class _11403 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] B = new int[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                B[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int r=0; r<N; r++){
                for(int c=0; c<N; c++){
                    if(B[r][i]+B[i][c]==2){
                        B[r][c] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                sb.append(B[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
