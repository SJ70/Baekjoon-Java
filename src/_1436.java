import java.util.Scanner;

public class _1436 {
    public static boolean Check(int n){
        String N = String.valueOf(n);
        for(int i=0; i<N.length()-2; i++){
            if( N.charAt(i)=='6' && N.charAt(i+1)=='6' && N.charAt(i+2)=='6' )
                return true;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 666;
        int cnt = 0;
        while(true){
            if(Check(i)) cnt++;
            if(cnt==N) break;
            i++;
        }
        System.out.println(i);
    }
}
