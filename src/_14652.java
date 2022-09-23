import java.util.Scanner;
import java.util.StringTokenizer;

public class _14652 {
    public static void main(String[] args){
        StringTokenizer st = new StringTokenizer(new Scanner(System.in).nextLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        System.out.printf("%d %d",K/C,K%C);
    }
}