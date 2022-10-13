import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int Diff = Y-X;

            int Date = 0;
            int i = 1;
            while(Diff>0){
                Diff -= i;
                Date++;
                if(Diff<=0) break;
                Diff -= i;
                Date++;
                i++;
            }
            sb.append(Date+"\n");
        }
        System.out.print(sb);
    }
}
