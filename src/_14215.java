import java.io.*;
import java.util.*;

public class _14215 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[3];
        for(int i=0; i<3; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int tmp = arr[0]+arr[1];
        if(tmp <= arr[2]){
            System.out.println(tmp*2-1);
        }
        else System.out.println(tmp + arr[2]);
    }
}
