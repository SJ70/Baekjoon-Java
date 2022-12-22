import java.io.*;

public class _5341 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int[] Arr = new int[101];
    public static void main(String[] args) throws IOException {
        init();
        int n;
        while((n=Integer.parseInt(br.readLine()))>0)
            sb.append(Arr[n]).append('\n');
        System.out.println(sb);
    }
    public static void init(){
        for(int i=1; i<=100; i++){
            Arr[i] = Arr[i-1]+i;
        }
    }
}
