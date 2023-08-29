import java.io.*;

public class _26068 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        for(int i=0; i<N; i++){
            int date = Integer.parseInt(br.readLine().substring(2));
            if(date<=90) result++;
        }
        System.out.println(result);
    }
}
