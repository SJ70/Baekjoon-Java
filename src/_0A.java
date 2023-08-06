import java.io.*;

public class _0A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] arr = new boolean[10];
        for(int i=0; i<5; i++){
            int n = Integer.parseInt(br.readLine());
            arr[n] = !arr[n];
        }
        for(int i=0; i<10; i++){
            if(arr[i]){
                System.out.println(i);
                return;
            }
        }
    }
}
