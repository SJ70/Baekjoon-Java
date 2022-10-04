import java.util.Scanner;

public class _13015 {
    static int N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args){
        N = new Scanner(System.in).nextInt();
        for(int i=0; i<N; i++){
            AppendMap(i);
        }
        for(int i=N-2; i>=0; i--){
            AppendMap(i);
        }
        System.out.print(sb);
    }
    public static void AppendMap(int n){
        for(int i=0; i<n; i++){
            sb.append(' ');
        }
        sb.append('*');
        for(int i=0; i<N-2; i++){
            sb.append(n==0?'*':' ');
        }
        if(n<N-1){
            sb.append('*');
            int blank = 2*((N-n)-2)+1;
            for(int i=0; i<blank; i++){
                sb.append(' ');
            }
        }
        sb.append('*');
        for(int i=0; i<N-2; i++){
            sb.append(n==0?'*':' ');
        }
        sb.append('*');
        sb.append('\n');
    }
}
