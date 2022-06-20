import java.io.*;
import java.util.*;

public class _15652 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new boolean[N];
        Output = new int[M];
        Bt(0,0);
        bw.flush();
        bw.close();
    }
    static int N,M;
    static boolean[] Arr;
    static int[] Output;
    public static void Bt(int index, int cnt) throws IOException{
        if(cnt==M){
            for(int i=0; i<M; i++)
                bw.write(Output[i]+" ");
            bw.write('\n');
            return;
        }
        for(int i=index; i<N; i++){
            Output[cnt]=i+1;
            Bt(i,cnt+1);
        }
    }
}
