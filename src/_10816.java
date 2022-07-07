import java.io.*;
import java.util.*;

public class _10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer,Integer> map = new HashMap<>();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            if(!map.containsKey(N)) map.put(N,1);
            else map.put(N,map.get(N)+1);
        }
        T = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<T; i++){
            int N = Integer.parseInt(st.nextToken());
            if(map.containsKey(N)) bw.write(map.get(N)+" ");
            else bw.write("0 ");
        }
        bw.flush();
        bw.close();
    }
}