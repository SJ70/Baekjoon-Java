import java.io.*;
import java.util.*;

public class _10797 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++){
            if(Integer.parseInt(st.nextToken())==N) cnt++;
        }
        System.out.println(cnt);
    }
}
