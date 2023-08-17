import java.io.*;
import java.util.*;

public class _19944 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(M<=2 ? "NEWBIE!" : M<=N ? "OLDBIE!" : "TLE!");
    }
}
