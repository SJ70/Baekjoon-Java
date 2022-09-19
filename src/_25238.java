import java.util.Scanner;
import java.util.StringTokenizer;

public class _25238 {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int A = Integer.parseInt(st.nextToken());
        if(A<100){
            System.out.println(1);
            return;
        }
        int B = Integer.parseInt(st.nextToken());
        A -= A*B/100;
        System.out.println(A<100?1:0);
    }
}
