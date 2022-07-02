import java.io.*;
import java.util.*;

public class _15654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new boolean[N];
        Output = new int[M];
        Num = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            Num[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(Num);
        Bt(0);
        bw.flush();
        bw.close();
    }
    static int N,M;
    static boolean[] Arr;
    static int[] Output;
    static int[] Num;
    public static void Bt(int cnt) throws IOException{
        if(cnt==M){
            for(int i=0; i<M; i++)
                bw.write(Num[Output[i]-1]+" ");
            bw.write('\n');
            return;
        }
        for(int i=0; i<N; i++){
            if(!Arr[i]){
                Arr[i]=true;
                Output[cnt]=i+1;
                Bt(cnt+1);
                Arr[i]=false;
            }
        }
    }
}
