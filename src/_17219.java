import java.io.*;
import java.util.*;

public class _17219 {
    public static void main(String[] args) throws IOException{
        HashMap<String,String> HM = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            HM.put(st.nextToken(),st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=0; i<M; i++){
            bw.write(HM.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
    }
}