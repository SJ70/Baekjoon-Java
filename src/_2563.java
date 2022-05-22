import java.io.*;
import java.util.StringTokenizer;

public class _2563 {
    public static void main(String[] args) throws IOException{
        Input();
        System.out.println(result);
    }
    static boolean[][] Map = new boolean[100][100];
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            Color(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
    static int result=0;
    public static void Color(int r, int c){
        for(int i=r; i<r+10; i++){
            for(int j=c; j<c+10; j++){
                if(!Map[i][j]){
                    result++;
                    Map[i][j]=true;
                }
            }
        }
    }
}
