import java.util.Scanner;

public class _1019_test {
    static Scanner sc = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static int N;
    static int[] arr = new int[10];
    public static void main(String[] args) {
        N = sc.nextInt();
        for(int i=1; i<=N; i++){
            String str = String.valueOf(i);
            for(int k=0; k<str.length(); k++){
                arr[(str.charAt(k)-'0')]++;
            }
            if(i>=1 && i<=N){
                sb.append(i).append(" : ");
                for(int element : arr)
                    sb.append(element).append(' ');
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }
}