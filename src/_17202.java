import java.io.*;
import java.util.*;

public class _17202 {
    public static void main(String[] args) throws IOException{
        // init
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[16];
        for(int i=0; i<2; i++){
            String str = br.readLine();
            for(int j=0; j<8; j++){
                arr[j*2+i] = str.charAt(j)-'0';
            }
        }
//        for(int e : arr) System.out.printf("%d ",e);
//        System.out.println();

        // dp
        for(int i=15; i>=2; i--){
            for(int j=0; j<i; j++){
                arr[j] = (arr[j] + arr[j+1]) % 10;
//                System.out.printf("%d ",arr[j]);
            }
//            System.out.println();
        }

        // print
        System.out.printf("%d%d",arr[0],arr[1]);
    }
}
