import java.io.*;

public class _1343{
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)=='X'){
                cnt++;
            }
            else{
                if(isImpossible(cnt)) return;
                buildString(sb, cnt);
                sb.append('.');
                cnt=0;
            }
        }
        if(isImpossible(cnt)) return;
        buildString(sb, cnt);
        System.out.println(sb);
    }
    public static void buildString(StringBuilder sb, int cnt){
        sb.append("AAAA".repeat(cnt/4));
        if(cnt%4==2){
            sb.append("BB");
        }
    }
    public static boolean isImpossible(int cnt){
        if(cnt%2==1){
            System.out.println(-1);
            return true;
        }
        return false;
    }
}
