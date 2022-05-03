import java.io.*;
import java.util.*;

public class _11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static int GetInt(StringTokenizer st){
        return Integer.parseInt(st.nextToken());
    }

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] N = new int[GetInt(st)+1];
        int M = GetInt(st);
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<N.length; i++)
            N[i] = GetInt(st)+N[i-1];
        for(int a=0; a<M; a++){
            st = new StringTokenizer(br.readLine());
            int i = GetInt(st);
            int j = GetInt(st);
            bw.write((N[j]-N[i-1])+"\n");
        }
        bw.flush();
    }
}
