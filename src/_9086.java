import java.util.*;

public class _9086 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            String str = sc.next();
            System.out.print(str.charAt(0));
            System.out.println(str.charAt(str.length()-1));
        }
    }
}