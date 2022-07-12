import java.util.*;

public class _1316 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Result = 0;
        for(int i=0; i<N; i++){
            if(isGrouped(sc.next())) {
                Result++;
            }
        }
        System.out.println(Result);
    }
    public static boolean isGrouped(String str){
        Set<String> set = new HashSet<>();
        char previous = ' ';
        for(int i=0; i<str.length(); i++){
            char C = str.charAt(i);
            if(C==previous) continue;
            else previous = C;

            if(set.contains(String.valueOf(C))) return false;
            else set.add(String.valueOf(C));
        }
        return true;
    }
}
