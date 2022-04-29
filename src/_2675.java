import java.io.*;
import java.util.*;

public class _2675 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void Repeat(String S) throws IOException{
        int n = S.charAt(0)-48;
        for(int i=2; i<S.length(); i++)
            for(int j=0; j<n; j++)
                bw.write(S.charAt(i));
        bw.write("\n");
    }
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++)
            Repeat(br.readLine());
        bw.flush();
    }
}
