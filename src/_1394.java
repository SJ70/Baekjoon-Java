import java.io.*;
import java.util.*;

public class _1394 {
    static String memo, pw;
    static HashMap<Character, Integer> chars;
    public static void main(String[] args) throws IOException{
        input();
        init();
        System.out.println(getResult());
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        memo = br.readLine();
        pw = br.readLine();
    }
    public static void init(){
        chars = new HashMap<>();
        for(int i=0; i<memo.length(); i++){
            chars.put(memo.charAt(i), i+1);
        }
    }
    public static int getResult(){
        int result = 0;
        for(int i=0; i<pw.length(); i++){
            result *= memo.length();

            char num = pw.charAt(i);
            result += chars.get(num);
            result %= 900528;
        }
        return result;
    }
}
