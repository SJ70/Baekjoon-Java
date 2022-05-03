import java.io.*;
import java.util.*;

public class _1546 {
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] arr = new double[n];
        double max = 0;
        double result = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            if(max<arr[i]) max=arr[i];
        }
        for(int i=0; i<n; i++){
            arr[i] = arr[i]*100/max;
            result += arr[i];
        }
        System.out.println(result/n);
    }
}
