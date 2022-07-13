import java.util.*;

public class _11478 {
    public static void main(String[] args){
        String str = new Scanner(System.in).next();
        Set<String> set = new HashSet<>();
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<=str.length(); j++){
                String tmp = str.substring(i,j);
                //if(!set.contains(tmp))System.out.println(tmp);
                set.add(tmp);
            }
        }
        System.out.println(set.size());
    }
}
