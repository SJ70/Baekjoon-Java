import java.io.*;
import java.util.*;

public class _1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        ArrayList<String> arr = new ArrayList<>();
        for(int i=0; i<N; i++){
            String str = br.readLine();
            if(set.contains(str)) {
                arr.add(str);
            }
        }
        Collections.sort(arr);
        bw.write(arr.size()+"\n");
        for(int i=0; i<arr.size(); i++){
            bw.write(arr.get(i)+"\n");
        }
        bw.flush();
        bw.close();
    }
}
