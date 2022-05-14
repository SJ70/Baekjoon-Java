import java.util.*;
import java.io.*;

public class _5052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static boolean able;
    public static class Tree{
        boolean End;
        Tree[] value = new Tree[10];
        public Tree(boolean End){
            this.End = End;
        }
    }

    public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            able = true;
            Solve();
            bw.write((able)?"YES\n":"NO\n");
        }
        bw.flush();
    }
    public static void Solve() throws IOException{
        int n = Integer.parseInt(br.readLine());
        Tree t = new Tree(false);
        for(int i=0; i<n; i++)
            InputTree(t,br.readLine(),0);
    }
    public static void InputTree(Tree t, String str, int I){
        if(I<str.length() && able){
            int N = str.charAt(I)-'0';
            // 값이 있는 경우 : 해당 값이 '다른 값의 끝나는 지점'이거나 '본인이 끝나는 지점'일 경우
            if (t.value[N]!=null && (t.value[N].End || I==str.length()-1)){
                able = false;
                //System.out.println(N+",break");
            }
            else if(I==str.length()-1){ // 문자열 마지막
                t.value[N] = new Tree(true);
                //System.out.println(N+",end");
            }
            else { //I<str.length()-1   // 문자열 마지막 이전
                if(t.value[N]==null) t.value[N] = new Tree(false);
                //System.out.print(N+".");
                InputTree(t.value[N], str, I + 1);
            }
        }
    }
}
