import java.io.*;
import java.util.*;

public class _1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        Map<String,String> map = new HashMap<>();
        for(int i=0; i<A; i++){
            String str = br.readLine();
            String index = String.valueOf(i+1);
            map.put(str,index);
            map.put(index,str);
        }
        for(int i=0; i<B; i++){
            bw.write(map.get(br.readLine())+"\n");
        }
        bw.flush();
        bw.close();
    }
}
