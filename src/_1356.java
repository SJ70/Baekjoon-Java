import java.io.*;

public class _1356 {
    public static void main(String[] args) throws IOException{
        String num = new BufferedReader(new InputStreamReader(System.in)).readLine();
        for(int i=1; i<num.length(); i++){
            String a = num.substring(0,i);
            String b = num.substring(i);
            if(multiply(a)==multiply(b)){
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");
    }
    public static int multiply(String str){
        int value = 1;
        for(int i=0; i<str.length(); i++){
            value *= str.charAt(i)-'0';
        }
        return value;
    }
}
