import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2566 {
    public static void main(String[] args) throws IOException{
        final int N = 9;
        int Max_value = -1;
        int Max_row = 0;
        int Max_column = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                int value = Integer.parseInt(st.nextToken());
                if(value > Max_value){
                    Max_value = value;
                    Max_row = r+1;
                    Max_column = c+1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(Max_value).append('\n').append(Max_row).append(' ').append(Max_column);
        System.out.print(sb);
    }
}
