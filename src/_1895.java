import java.io.*;
import java.util.*;

public class _1895 {
    static int R, C;
    static int[][] Arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Arr = new int[R][C];
        for(int r=0; r<R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<C; c++){
                Arr[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        int T = Integer.parseInt(br.readLine());
        int result = 0;
        for(int r=0; r<R-2; r++){
            for(int c=0; c<C-2; c++){
                if(getMosaic(r,c)>=T){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
    private static int getMosaic(int r, int c){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=r; i<=r+2; i++){
            for(int j=c; j<=c+2; j++){
                arr.add(Arr[i][j]);
            }
        }
        Collections.sort(arr);
//        System.out.println(arr);
        return arr.get(4);
    }
}
