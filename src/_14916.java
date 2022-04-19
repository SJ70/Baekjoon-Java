import java.util.*;
public class _14916 {
    public static void main(String[] args){
        int n = new Scanner(System.in).nextInt();
        int cnt = 0;
        if(n==1||n==3)
            System.out.println(-1);
        else{
            while(n%5!=0){
                n-=2;
                cnt++;
            }
            cnt+=n/5;
            System.out.println(cnt);
        }
    }
}