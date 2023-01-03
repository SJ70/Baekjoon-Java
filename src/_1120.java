import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1120 {
    public static void main(String[] args) throws IOException{
        init();
        System.out.println(getResult());
    }
    static String A,B;
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = st.nextToken();
        B = st.nextToken();
    }
    public static int getResult(){
        int result = 50;
        for(int i=0; i + A.length() <= B.length(); i++){
            result = Math.min(result, compare(i));
        }
        return result;
    }
    public static int compare(int startIndex){
        int diff = 0;
        for(int i=0; i<A.length(); i++){
            if(A.charAt(i) != B.charAt(startIndex + i))
                diff++;
        }
        return diff;
    }
}
