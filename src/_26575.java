import java.io.*;
import java.util.*;

public class _26575 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            double result = 1f;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                result *= Double.parseDouble(st.nextToken());
            }
            System.out.printf("$%.2f\n",result);
        }
    }
}
