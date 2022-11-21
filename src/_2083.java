import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2083 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while(!(str = br.readLine()).equals("# 0 0")){
            StringTokenizer st = new StringTokenizer(str);
            sb.append(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if(age>17 || weight>=80) sb.append(" Senior\n");
            else sb.append(" Junior\n");
        }
        System.out.println(sb);
    }
}
