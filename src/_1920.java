import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _1920 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Map<Integer,Boolean> M = new HashMap<>();
        int N = sc.nextInt();
        for(int i=0; i<N; i++){
            M.put(sc.nextInt(),true);
        }
        N = sc.nextInt();
        for(int i=0; i<N; i++){
            Integer tmp = sc.nextInt();
            if(M.get(tmp)!=null) System.out.println(1);
            else System.out.println(0);
        }
    }
}