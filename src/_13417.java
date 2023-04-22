import java.io.*;
import java.util.*;

public class _13417 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            sb.append(getResult(Integer.parseInt(br.readLine()), new StringTokenizer(br.readLine())));
        }
        System.out.print(sb);
    }
    public static String getResult(int N, StringTokenizer st){
        StringBuilder sb = new StringBuilder();
        char front = st.nextToken().charAt(0);
        sb.append(front);

        while(st.hasMoreTokens()){
            char c = st.nextToken().charAt(0);
            if(c>front) sb.append(c);
            else{
                sb.insert(0, c);
                front = c;
            }
        }
        return sb.append('\n').toString();
    }
}
