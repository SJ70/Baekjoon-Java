import java.util.Scanner;

public class _10995 {
    public static void main(String[] args) {
        int N = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=N; r++){
            if(r%2==0){
                sb.append(' ');
            }
            for(int c=1; c<=2*N-1; c++){
                sb.append(c%2==1?'*':' ');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}