import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2530 {
    static int[] time = new int[3];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<3; i++){
            time[i] = Integer.parseInt(st.nextToken());
        }

        int n = Integer.parseInt(br.readLine());
        time[0] += n/3600;
        n%=3600;
        time[1] += n/60;
        n%=60;
        time[2] += n;

        time[1] += time[2]/60;
        time[2] %= 60;
        time[0] += time[1]/60;
        time[1] %= 60;
        time[0] %= 24;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            sb.append(time[i]).append(' ');
        }
        System.out.println(sb);
    }
}
