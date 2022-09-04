import java.io.*;
import java.util.*;

public class _1929 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        boolean[] NotDecimal = new boolean[M+1];
        NotDecimal[1]=true;
        for(int i=2; i<=M; i++){
            if(i>=N && !NotDecimal[i]){
                bw.write(i+"\n");
            }
            for(int j=i*2; j<=M; j+=i){
                NotDecimal[j]= true;
            }
        }
        bw.flush();
        bw.close();
    }
}