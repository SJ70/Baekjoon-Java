import java.io.*;

public class _15988 {
    public static void main(String[] args) throws IOException{
        init();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            sb.append(arr[Integer.parseInt(br.readLine())]).append('\n');
        }
        System.out.print(sb);
    }
    static long[] arr;
    public static void init(){
        arr = new long[1000001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1 + arr[1];
        arr[3] = 1 + arr[1] + arr[2];
        for(int i=4; i<=1000000; i++){
            arr[i] = arr[i-1] + arr[i-2] + arr[i-3];
            arr[i] %= 1000000009;
        }
    }
}
