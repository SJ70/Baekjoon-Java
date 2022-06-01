import java.io.*;
import java.util.*;

public class _2812 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int NeedToErase;
    static String X;
    static int Xsize;
    static int RemainedX;
    static int Xindex=0;
    public static void main(String[] args) throws IOException{
        Input();
        //System.out.println(Result+" "+X.substring(Xindex)+" "+NeedToErase+" "+RemainedX);
        while(NeedToErase>0){
            Solve();
            //System.out.println(Result+" "+X.substring(Xindex)+" "+NeedToErase+" "+RemainedX);
            if(RemainedX==NeedToErase){ // 반례 해결 : 7 3 7654321
                //System.out.println("break");
                Xindex=Xsize;
                break;
            }
        }
        bw.flush();
        System.out.println(X.substring(Xindex));
    }
    public static void Input(){
        Scanner sc = new Scanner(System.in);
        RemainedX = Xsize = sc.nextInt();
        NeedToErase = sc.nextInt();
        X = sc.next();
    }
    public static void Solve() throws IOException {
        int FirstIndex=0;
        int Max=-1;
        for(int i=Xindex; i<=Xindex+NeedToErase; i++){
            int N = X.charAt(i);
            if (N > Max) {
                FirstIndex = i;
                Max = N;
            }
            if(N=='9') break;
        }
        NeedToErase -= FirstIndex-Xindex;
        bw.write(X.charAt(FirstIndex));
        Xindex = FirstIndex+1;
        RemainedX = Xsize - Xindex;
    }
}
