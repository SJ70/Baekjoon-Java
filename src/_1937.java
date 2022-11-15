import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1937 {
    static int N;
    static int[][] Map;
    static Integer[][] Value;
    static int MaxValue = 1;
    public static void main(String[] args) throws IOException{
        init();
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                Value[r][c] = ValueOf(r,c);
//                printStatus();
            }
        }
        System.out.println(MaxValue);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Map = new int[N][N];
        Value = new Integer[N][N];
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                Map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static int ValueOf(int r, int c){
        if(Value[r][c]!=null) return Value[r][c];
        int value = 1;
        if(r-1>=0 && Map[r-1][c]>Map[r][c]) value = Math.max(value, ValueOf(r-1,c)+1);
        if(r+1<N  && Map[r+1][c]>Map[r][c]) value = Math.max(value, ValueOf(r+1,c)+1);
        if(c-1>=0 && Map[r][c-1]>Map[r][c]) value = Math.max(value, ValueOf(r,c-1)+1);
        if(c+1<N  && Map[r][c+1]>Map[r][c]) value = Math.max(value, ValueOf(r,c+1)+1);
        MaxValue = Math.max(MaxValue, value);
        Value[r][c] = value;
        return value;
    }
    public static void printStatus(){
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                if(Value[r][c]==null) System.out.print("  .");
                else System.out.printf("%3d",Value[r][c]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
