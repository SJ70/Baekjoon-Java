import java.util.Scanner;

public class _2523 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=N; r++){
            for(int i=0; i<r; i++){
                sb.append('*');
            }
            sb.append('\n');
        }
        for(int r=N-1; r>=1; r--){
            for(int i=0; i<r; i++){
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
