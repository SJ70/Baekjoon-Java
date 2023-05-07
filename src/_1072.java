import java.io.*;
import java.util.*;

public class _1072 {
    static int N, Win, WinRate;
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        N = Integer.parseInt(st.nextToken());
        Win = Integer.parseInt(st.nextToken());
        WinRate = (int)((long)Win*100/N);

        if(WinRate==99 || WinRate==100){
            System.out.println(-1);
            return;
        }

        System.out.println(BS(0,N));
    }
    public static int BS(int left, int right){
        if(left==right) return left;
//        System.out.println(left+"~"+right);

        int mid = (left+right)/2;
        int currentWinRate = (int)((long)(Win+mid)*100/(N+mid));
        if( currentWinRate == WinRate ){
            return BS(mid+1,right);
        }
        else{
            return BS(left,mid);
        }
    }
}
