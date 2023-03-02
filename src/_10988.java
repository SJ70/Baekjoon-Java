import java.io.*;

public class _10988 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        for(int i=0; i<str.length()/2; i++){
            char left = str.charAt(i);
            char right = str.charAt(str.length()-1-i);
            if(left!=right){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
