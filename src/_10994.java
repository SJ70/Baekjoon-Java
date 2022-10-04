import java.util.Scanner;

public class _10994 {
    static boolean[][] Map;
    static int N,half,size;
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        half = N*2-1;
        size = half*2-1;
        Map = new boolean[size][size];
        for(int i=0; i<=half; i+=2){
            FillMap(i);
            //PrintMap();
        }
        PrintMap();
    }
    public static void FillMap(int n){
        for(int i=n; i<size-n; i++){
            Map[i][n] = true;
            Map[i][size-n-1] = true;
            Map[n][i] = true;
            Map[size-n-1][i] = true;
        }
    }
    public static void PrintMap(){
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                sb.append(Map[r][c]?'*':' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
