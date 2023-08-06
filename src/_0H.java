import java.io.*;
import java.util.*;

public class _0H {
    static int R,C,Q;
    static int[] RowSum, ColumnSum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        RowSum = new int[R];
        ColumnSum = new int[C];

        for(int q=0; q<Q; q++){
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken()) -1;
            int v = Integer.parseInt(st.nextToken());

            switch(operation){
                case 1 : RowSum[n] += v;    break;
                case 2 : ColumnSum[n] += v; break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(RowSum[r] + ColumnSum[c]).append(c<C-1 ? ' ' : '\n');
            }
        }
        System.out.print(sb);
    }
}
