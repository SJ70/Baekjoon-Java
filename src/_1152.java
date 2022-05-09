import java.util.Scanner;

public class _1152 {
    public static void main(String[] args){
        int cnt = 0;
        boolean cnting = true;
        String str = new Scanner(System.in).nextLine();
        str = ' '+str+' ';
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i-1)!=' ' && str.charAt(i)==' ') cnting=true;
            else if(str.charAt(i-1)==' ' && str.charAt(i)!=' '){
                cnting=false;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}