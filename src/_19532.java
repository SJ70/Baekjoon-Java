import java.io.*;
import java.util.*;

public class _19532 {
    static int A, B, C, D, E, F, x, y;
    public static void main(String[] args) throws IOException{
        input();
        if(A==0){
            y = C/B;
            x = (F-E*y)/D;
        }
        else if(B==0){
            x = C/A;
            y = (F-D*x)/E;
        }
        else if(D==0){
            y = F/E;
            x = (C-B*y)/A;
        }
        else if(E==0){
            x = F/D;
            y = (C-A*x)/B;
        }
        else{
            for(x=-999; x<=999; x++){
                if( (C-A*x)/B == (F-D*x)/E && (C-A*x)%B==0 && (F-D*x)%E==0 ){
                    y = (C-A*x)/B;
                    break;
                }
            }
        }
        System.out.printf("%d %d",x,y);
    }
    public static void input() throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
    }
}
