import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2163 {
    static int N,M,cutCnt;
    static Integer[][] History;
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(getCutCnt(N,M));
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cutCnt = 0;
        int size = Math.max(N,M)+1;
        History = new Integer[size][size];
        History[1][1] = 0;
    }
    public static int getCutCnt(int L, int S){
//        System.out.printf("%d, %d\n",L,S);
        if(L<S){
            int tmp = S;
            S = L;
            L = tmp;
        }
        if(History[L][S]!=null) return History[L][S];
//        System.out.printf("--> Calculated\n");

        int half = L/2;
        int value = getCutCnt(half,S) + getCutCnt(L-half,S) + 1;
        History[L][S] = value;
        return value;
    }
}
