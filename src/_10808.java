import java.util.*;

public class _10808{
    public static void main(String[] args){
        String str = new Scanner(System.in).nextLine();
        int[] arr = new int[26];
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        for(int i=0; i<26; i++){
            System.out.print(arr[i]+" ");
        }
    }
}