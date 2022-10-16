import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _25793 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long[] constantTerm = new long[1000001];
        for(int i=1; i<=1000000; i++){
            constantTerm[i] = constantTerm[i-1]+ (long)i*(long)i;
        }

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long R = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());
            long Height = Math.min(R,C);
            long Sum_OneToHeight = (Height/2)*(Height+1) + (Height%2)*(Height/2+1);
            long tmp = (2 * ( Height*R*C - Sum_OneToHeight*(R+C) + constantTerm[(int)Height] ));

            long White = R*C + tmp;
            long Black = (R-1)*C + tmp + (R-Height+1)*(C-Height);
            sb.append(White+" "+Black+"\n");
        }
        System.out.print(sb);
    }
}