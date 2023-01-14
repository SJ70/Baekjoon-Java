import java.io.*;
import java.util.*;

public class _27160 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[4];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = NumberOf(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[index] += value;
        }

        for(int i=0; i<4; i++){
            if(arr[i]==5){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
    public static int NumberOf(String str){
        switch(str.charAt(0)){
            case 'S': return 0;
            case 'B': return 1;
            case 'L': return 2;
            case 'P': return 3;
            default : return -1;
        }
    }
}
