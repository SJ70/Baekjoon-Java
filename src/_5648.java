import java.util.*;

public class _5648 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long[] arr = new long[N];
        for(int i=0; i<N; i++){
            String str = sc.next();
            long n = 0;
            for(int k=str.length()-1; k>=0; k--){
                n = n * 10 + (str.charAt(k)-'0');
            }
            arr[i] = n;
        }
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(long e : arr){
            sb.append(e).append('\n');
        }
        System.out.print(sb);
    }
}
