import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25966 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] changedRow;
    static int R,C,query;
    static int[][] M;
    public static void main(String[] args) throws IOException{
        init();
        for(int q=0; q<query; q++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order==0){
                changeValue(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            else{
                swap(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        printM();
    }
    public static void init() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        query = Integer.parseInt(st.nextToken());

        M = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                M[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        changedRow = new int[R];
        for(int r=0; r<R; r++)
            changedRow[r] = r;
    }
    public static void changeValue(int r, int c, int k){
        r = changedRow[r];
        M[r][c] = k;
    }
    public static void swap(int r1, int r2){
        int tmp = changedRow[r2];
        changedRow[r2] = changedRow[r1];
        changedRow[r1] = tmp;
    }
    public static void printM(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                sb.append(M[changedRow[r]][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
