import java.io.*;
import java.util.*;

public class _10814 {
    static Info[] User = new Info[201];
    public static class Info{
        ArrayList<String> arr = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        for(int i=1; i<=200; i++){
            User[i] = new Info();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            User[Integer.parseInt(st.nextToken())].arr.add(st.nextToken());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i=1; i<=200; i++){
            for(int j=0; j<User[i].arr.size(); j++){
                bw.write(i+" "+User[i].arr.get(j)+"\n");
            }
        }
        bw.flush();
        bw.close();
    }
}