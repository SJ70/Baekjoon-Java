import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1357 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String X = st.nextToken();
        String Y = st.nextToken();
        String Sum = Reverse(String.valueOf( Integer.parseInt(Reverse(X)) + Integer.parseInt(Reverse(Y)) ));
        System.out.println(Sum);
    }
    public static String Reverse(String str){
        StringBuilder sb = new StringBuilder();
        for(int i=str.length()-1; i>=0; i--){
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
