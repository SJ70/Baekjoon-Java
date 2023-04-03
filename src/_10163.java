import java.io.*;
import java.util.*;

public class _10163 {
    static Stack<int[]> papers = new Stack<>();
    static int[][] arr = new int[1001][1001];
    static int[] result;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        result = new int[N];

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] paper = new int[4];
            for(int j=0; j<4; j++){
                paper[j] = Integer.parseInt(st.nextToken());
            }
            papers.push(paper);
        }

        for(int i=N-1; i>=0; i--){
            int[] paper = papers.pop();
            for(int r=paper[0]; r<paper[0]+paper[2]; r++){
                for(int c=paper[1]; c<paper[1]+paper[3]; c++){
                    if(arr[r][c]==0){
                        arr[r][c] = i;
                        result[i]++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int e : result){
            sb.append(e).append('\n');
        }
        System.out.print(sb);
    }
}
