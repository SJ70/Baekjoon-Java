import java.util.*;

public class _10809 {
    public static void main(String[] args){
        String S = new Scanner(System.in).next();
        int[] Alphabet = new int[26];
        for(int i=S.length()-1; i>=0; i--)
            Alphabet[S.charAt(i)-97] = i+1;
        for(int i=0; i<26; i++)
            System.out.print(Alphabet[i]-1+" ");
    }
}
