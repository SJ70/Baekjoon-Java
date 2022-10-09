import java.util.Scanner;

public class _10991 {
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        StringBuilder sb = new StringBuilder();
        for(int r=1; r<=N; r++){
            for(int i=0; i<N-1+r; i++){
                if(i<N-r){
                    sb.append(' ');
                }
                else if((N+i+r)%2==1){
                    sb.append(' ');
                }
                else{
                    sb.append('*');
                }
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }
}
