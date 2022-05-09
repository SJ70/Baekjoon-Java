import java.util.Scanner;

public class _1152 {
    public static void main(String[] args){
        int cnt = 1;
        String str = new Scanner(System.in).nextLine();
        for(int i=1; i<str.length()-1; i++)
            if(str.charAt(i)==' ') cnt++;
        System.out.println(cnt);
    }
}