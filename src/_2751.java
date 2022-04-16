import java.util.*;
import java.io.*;
public class _2751 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> n = new ArrayList<>();
        for(int i=0;i<N;i++)
            n.add(Integer.parseInt(br.readLine()));
        Collections.sort(n);
        for(int i=0;i<N;i++)
            bw.write(n.get(i)+"\n");
        bw.flush();
    }
}
