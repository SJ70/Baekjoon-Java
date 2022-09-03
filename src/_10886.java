import java.io.*;

public class _10886 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[2];
        for(int i=0; i<N; i++){
            arr[Integer.parseInt(br.readLine())]++;
        }
        if(arr[0]<arr[1]) System.out.println("Junhee is cute!");
        else System.out.println("Junhee is not cute!");
    }
}