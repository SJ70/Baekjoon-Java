import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25755 {
    static int N;
    static int[][] Arr;
    static char dir;
    public static void main(String[] args) throws IOException{
        init();
        printFlipped();
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        dir = st.nextToken().charAt(0);
        N = Integer.parseInt(st.nextToken());

        Arr = new int[N][N];
        for(int r=0; r<N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                Arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void printFlipped(){
        StringBuilder sb = new StringBuilder();
        boolean LR = (dir=='L'||dir=='R');
        for(int r=(LR?0:N-1); LR?r<=N-1:r>=0; r+=(LR?1:-1)){
            for(int c=(LR?N-1:0); LR?c>=0:c<=N-1; c+=(LR?-1:1)){
                char C = (Arr[r][c]==1)?'1':(Arr[r][c]==8)?'8':(Arr[r][c]==2)?'5':(Arr[r][c]==5)?'2':'?';
                sb.append(C).append(' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
