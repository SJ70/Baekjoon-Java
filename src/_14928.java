import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _14928 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int divisor = 20000303;
        int value = 0;
        for(int i=0; i<str.length(); i++){
//            System.out.println(value);
            value *= 10;
            value += str.charAt(i)-'0';
            value %= divisor;
        }
        System.out.println(value);
    }
}
