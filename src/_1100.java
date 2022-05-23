import java.util.Scanner;

public class _1100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cnt = 0;
        for(int r=0; r<8; r++){
            String str = sc.nextLine();
            for(int c=0; c<8; c++){
                if( (r+c)%2 == 0 && str.charAt(c)=='F' ) cnt++;
            }
        }
        System.out.println(cnt);
    }
}
