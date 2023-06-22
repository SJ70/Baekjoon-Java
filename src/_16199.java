import java.io.*;
import java.util.*;

public class _16199 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer A = new StringTokenizer(br.readLine());
        StringTokenizer B = new StringTokenizer(br.readLine());

        int Ay = Integer.parseInt(A.nextToken());
        int Amd = Integer.parseInt(A.nextToken())*100 + Integer.parseInt(A.nextToken());
        int By = Integer.parseInt(B.nextToken());
        int Bmd = Integer.parseInt(B.nextToken())*100 + Integer.parseInt(B.nextToken());

        int y_diff = By - Ay;
        int md_diff = Bmd - Amd;

        int a = y_diff + ((md_diff>=0)?0:-1);
        int b = y_diff + 1;
        int c = y_diff;
        System.out.printf("%d\n%d\n%d\n",a,b,c);
    }
}
