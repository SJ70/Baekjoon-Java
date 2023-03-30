import java.io.*;
import java.util.*;

public class _2864 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] A = st.nextToken().toCharArray();
        char[] B = st.nextToken().toCharArray();

        int min = replace(A,6,5) + replace(B,6,5);
        int max = replace(A,5,6) + replace(B,5,6);
        System.out.printf("%d %d",min,max);
    }
    public static int replace(char[] arr, int from, int to){
        int value = 0;
        for(int i=0; i<arr.length; i++){
            int n = arr[i]-'0';
            n = n==from ? to : n;
            value = value * 10 + n;
        }
        return value;
    }
}
