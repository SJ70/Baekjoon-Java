import java.util.Scanner;

public class _10992 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=N; r++){
            for(int i=0; i<N-r; i++){
                sb.append(' ');
            }
            sb.append('*');
            if(r==N){
                for(int i=0; i<(r-1)*2; i++){
                    sb.append('*');
                }
            }
            else if(r!=1){
                for(int i=0; i<(r-1)*2-1; i++){
                    sb.append(' ');
                }
                sb.append('*');
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
