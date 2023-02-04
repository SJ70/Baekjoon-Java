import java.io.*;
import java.util.StringTokenizer;

public class _9777 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[12];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            st = new StringTokenizer(st.nextToken(),"/");
            st.nextToken();
            arr[Integer.parseInt(st.nextToken())-1]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<12; i++){
            sb.append(i+1).append(' ').append(arr[i]).append('\n');
        }
        System.out.print(sb);
    }
}
