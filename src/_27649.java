import java.io.*;
import java.util.*;

public class _27649 {
    static String str;
    public static void main(String[] args) throws IOException{
        str = (new BufferedReader(new InputStreamReader(System.in)).readLine());

        Deque<Character> D = new ArrayDeque<>();
        for(int i=0; i<str.length(); i++){
            char C = str.charAt(i);
            switch(C){
                case '<' :
                case '>' :
                case '(' :
                case ')' :
                    if(D.size()>0 && D.peekLast()!=' '){
                        D.addLast(' ');
                    }
                    D.addLast(C);
                    D.addLast(' ');
                    break;
                case ' ' :
                    if(D.size()>0 && D.peekLast()!=' '){
                        D.addLast(' ');
                    }
                    break;
                case '|' :
                case '&' :
                    if(i+1<str.length() && str.charAt(i+1)==C){
                        i++;
                        if(D.size()>0 && D.peekLast()!=' '){
                            D.addLast(' ');
                        }
                        D.addLast(C);
                        D.addLast(C);
                        D.addLast(' ');
                    }
                    else D.addLast(C);
                    break;
                default :
                    D.addLast(C);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!D.isEmpty()){
            if(D.size()==1 && D.peek()==' ') break;
            sb.append(D.pollFirst());
        }
        System.out.print(sb);
    }
}
