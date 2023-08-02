import java.io.*;
import java.util.*;

public class _1350 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long cluster = Long.parseLong(br.readLine());
        long count = 0;

        for(int i=0; i<N; i++){
            long size = Long.parseLong(st.nextToken());
            count += size/cluster + (size%cluster > 0 ? 1 : 0);
        }
        System.out.println(count * cluster);
    }
}
