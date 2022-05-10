import java.util.*;
import java.io.*;

public class _4949 {
    static Scanner sc = new Scanner(System.in);
    static String str="";
    static Stack<Integer> s;
    public static void main(String[] args){
        while(true){
            String bool = (isBalanced())?"yes":"no";
            if(str.equals(".")) break;
            else System.out.println(bool);
        }
    }
    public static boolean isBalanced(){
        str = sc.nextLine();
        s = new Stack<>();
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c=='[') s.add(1);
            else if(c=='(') s.add(0);
            else if(c==']'){
                if(s.empty())
                    return false;
                else if(s.pop()!=1)
                    return false;
            }
            else if(c==')'){
                if(s.empty())
                    return false;
                else if(s.pop()!=0)
                    return false;
            }
        }
        if(!s.empty()) return false;
        else return true;
    }
}
