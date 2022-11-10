import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1236 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        boolean[] Row = new boolean[R];
        boolean[] Column = new boolean[C];
        int safeRowCnt = 0;
        int safeColumnCnt = 0;
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                if(str.charAt(c)=='X'){
                    if(!Row[r]){
                        Row[r] = true;
                        safeRowCnt++;
                    }
                    if(!Column[c]){
                        Column[c] = true;
                        safeColumnCnt++;
                    }
                }
            }
        }
        System.out.println(Math.max(R-safeRowCnt, C-safeColumnCnt));
    }
}
