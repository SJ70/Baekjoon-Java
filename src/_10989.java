import java.io.*;
import java.util.*;

public class _10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] cnt = new int[10000];
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            cnt[Integer.parseInt(br.readLine())-1]++;
        }
        for(int i=0; i<10000; i++){
            for(int j=0; j<cnt[i]; j++){
                bw.write(i+1+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}