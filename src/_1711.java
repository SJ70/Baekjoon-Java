import java.io.*;
import java.util.*;

public class _1711 {
    static int N;
    static long[][] spot;
    public static void main(String[] args) throws IOException{
        input();
        System.out.println(getResult());
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        spot = new long[N][2];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            spot[i][0] = Long.parseLong(st.nextToken());
            spot[i][1] = Long.parseLong(st.nextToken());
        }
    }
    public static int getResult(){
        int result = 0;
        for(int i=0; i<N; i++){
            for(int a=i+1; a<N; a++){
                for(int b=a+1; b<N; b++){
                    if(isTriangle(spot[i], spot[a], spot[b]) || isTriangle(spot[a], spot[b], spot[i]) || isTriangle(spot[b], spot[i], spot[a])){
//                        System.out.printf("%d %d %d \n",i,a,b);
                        result++;
                    }
                }
            }
        }
        return result;
    }
    public static boolean isTriangle(long[] angle, long[] a, long[] b){
        long w1 = angle[0] - a[0];
        long h1 = angle[1] - a[1];
        long w2 = angle[0] - b[0];
        long h2 = angle[1] - b[1];
        if(w1==0 && h2==0) return true;
        if(h1==0 && w2==0) return true;
        return -w1*w2 == h1*h2; // (double)w1/h1 == (double)h2/(-w2)
    }
}
