import java.io.*;
import java.util.*;

public class _10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Boolean> map = new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            map.put(Integer.parseInt(st.nextToken()),Boolean.TRUE);
        }
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            if(map.get(N)==Boolean.TRUE) bw.write("1 ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }
}