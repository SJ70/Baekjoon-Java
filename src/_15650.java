import java.io.*;
import java.util.*;

public class _15650 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Arr = new boolean[N];
        Bt(0,0);
        bw.flush();
        bw.close();
    }
    static int N,M;
    static boolean[] Arr;
    public static void Bt(int index, int cnt) throws IOException{
        if(cnt==M){
            for(int i=0; i<N; i++)
                if(Arr[i]) bw.write((i+1)+" ");
            bw.write('\n');
            return;
        }
        if(index==N) return;
        if( N-index < M-cnt ) return;   // 남은 인덱스가 모두 참이어도 불가능한 경우
        Arr[index]=true;
        Bt(index+1, cnt+1);
        Arr[index]=false;
        Bt(index+1, cnt);
    }
}
