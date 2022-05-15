import java.io.*;
import java.util.*;

public class _17609 {
    static int failedIndex;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        int result;
        for(int i=0; i<T; i++){
            String str = br.readLine();
            if(Palindrome(str,0, str.length()-1)) result=0;
            else if(canBePalindrome(str)) result=1;
            else result=2;
            bw.write(result+"\n");
        }
        bw.flush();
    }
    public static boolean Palindrome(String str, int index1, int index2){
        //System.out.println(str.charAt(index1)+"~"+str.charAt(index2));
        for(int i=0; i<=str.length()/2-index1; i++){
            //System.out.println(str.charAt(index1+i)+":"+str.charAt(index2-i));
            if( str.charAt(index1+i) != str.charAt(index2-i) ){
                failedIndex=index1+i;
                return false;
            }
        }
        return true;
    }
    public static boolean canBePalindrome(String str){
        int fIndex = failedIndex;
        return (Palindrome(str,fIndex+1,str.length()-1-fIndex) || Palindrome(str,fIndex,str.length()-2-fIndex));
    }
}