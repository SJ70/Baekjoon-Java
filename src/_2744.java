import java.util.*;

public class _2744 {
    public static void main(String[] args){
        String str = new Scanner(System.in).next();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c<='Z') c+=32;
            else c-=32;
            System.out.print(c);
        }
    }
}
