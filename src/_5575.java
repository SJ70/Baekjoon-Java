import java.io.*;
import java.util.StringTokenizer;

public class _5575 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<3; i++){
            sb.append(getStrValue((getTimeDiff(br.readLine())))).append('\n');
        }
        System.out.print(sb);
    }
    public static int getTimeDiff(String str){
        StringTokenizer st = new StringTokenizer(str);
        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());
        int Time1 = getIntValue(h1, m1, s1);
        int Time2 = getIntValue(h2, m2, s2);
        return Time2 - Time1;
    }
    public static int getIntValue(int H, int M, int S){
        return H*60*60 + M*60 + S;
    }
    public static String getStrValue(int Time){
        StringBuilder sb = new StringBuilder();

        int divider = 60*60;
        for(int i=0; i<3; i++, Time%=divider, divider/=60){
            sb.append(Time/divider).append(' ');
        }
        return sb.toString();
    }
}
