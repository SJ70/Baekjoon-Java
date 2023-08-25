import java.io.*;
import java.util.*;

public class _1080 {

    static int R, C;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int FlipCnt = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int[][] Map1 = inputMap();
        int[][] Map2 = inputMap();

        for(int r=0; r<R-2; r++){
            for(int c=0; c<C-2; c++){
                if(Map1[r][c] != Map2[r][c]){
                    reverse(Map1, r, c);
                }
            }
        }

        if(isDifferent(Map1, Map2)){
            System.out.println(-1);
            return;
        }

        System.out.println(FlipCnt);
    }
    private static int[][] inputMap() throws IOException {
        int[][] arr = new int[R][C];
        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                arr[r][c] = str.charAt(c)-'0';
            }
        }
        return arr;
    }
    private static void reverse(int[][] arr, int r, int c){
        FlipCnt++;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                arr[r+i][c+j] = arr[r+i][c+j]==1 ? 0 : 1;
            }
        }
    }
    private static boolean isDifferent(int[][] arr1, int[][] arr2){
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                if(arr1[r][c] != arr2[r][c]){
                    return true;
                }
            }
        }
        return false;
    }
}
