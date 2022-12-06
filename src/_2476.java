import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2476 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int MaxReward = 0;
        for(int i=0; i<N; i++){
            MaxReward = Math.max(MaxReward, getReward(new StringTokenizer(br.readLine())));
        }
        System.out.println(MaxReward);
    }
    public static int getReward(StringTokenizer st){
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        if(a==b && b==c)
            return 10000 + a*1000;
        else if(a==b || a==c)
            return 1000 + a*100;
        else if(b==c)
            return 1000 + b*100;
        else
            return Math.max(a,Math.max(b,c))*100;
    }
}
