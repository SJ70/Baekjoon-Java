import java.util.*;

public class _1427 {
    public static void main(String[] args){
        String str = new Scanner(System.in).next();
        int[] cnt = new int[10];
        for(int i=0; i<str.length(); i++){
            cnt[str.charAt(i)-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=9; i>=0; i--){
            for(int j=0; j<cnt[i]; j++){
                sb.append(i);
            }
        }
        System.out.println(sb);
    }
}