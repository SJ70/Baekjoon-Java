import java.io.*;

public class _1254 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int i=0;
        for(; i<str.length(); i++){
            if(isPal(str, i)) break;
        }
        System.out.println(str.length()+i);
    }
    public static boolean isPal(String str, int k){
        for(int i=0; k+i<str.length(); i++){
            char left = str.charAt(k+i);
            char right = str.charAt((str.length()-1)-i);
            if(left != right) return false;
        }
        return true;
    }
}
