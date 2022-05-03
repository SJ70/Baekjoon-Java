import java.io.*;
import java.util.StringTokenizer;

public class _7568 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());
        int[] weight = new int[N];
        int[] height = new int[N];
        int[] rank = new int[N];
        //입력
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
        }
        //rank 산출
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if( weight[i] < weight[j] && height[i] < height[j] )
                    rank[i]++;
            }
        }
        //출력
        for(int i=0; i<N; i++){
            bw.write((rank[i]+1)+" ");
        }
        bw.flush();
    }
}
