import java.io.*;
import java.util.*;

public class _2506 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        int continued = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            if(Integer.parseInt(st.nextToken())==1){
                continued++;
                result += continued;
            }
            else{
                continued=0;
            }
        }
        System.out.println(result);
    }
}
