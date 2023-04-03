import java.io.*;
import java.util.*;

public class _10163 {
    static int[][] arr = new int[1001][1001];
    static int[] result;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] paper = new int[4];
            for(int j=0; j<4; j++){
                paper[j] = Integer.parseInt(st.nextToken());
            }

            for(int r=paper[0]; r<paper[0]+paper[2]; r++){
                for(int c=paper[1]; c<paper[1]+paper[3]; c++){
                    result[arr[r][c]]--;
                    result[i]++;
                    arr[r][c] = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append(result[i]).append('\n');
        }
        System.out.print(sb);
    }
}
