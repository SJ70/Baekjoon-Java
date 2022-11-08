import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _25918 {
    static int N;
    static String str;
    static Stack<Boolean> S = new Stack<>();
    public static void main(String[] args) throws IOException {
        init();
        if(isUnable()){
            System.out.println(-1);
            return;
        }

        int PopCombo = 0;
        int MaxPopCombo = 0;
        for(int i=0; i<N; i++){
            boolean C = str.charAt(i)=='(';
            if(!S.isEmpty() && S.peek()!=C){
                S.pop();
                PopCombo++;
                MaxPopCombo = Math.max(MaxPopCombo,PopCombo);
            }
            else{
                S.push(C);
                if(PopCombo>0) PopCombo--;
            }
        }

        System.out.println(MaxPopCombo);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        str = br.readLine();
    }
    public static boolean isUnable(){
        int OpenClose = 0;
        for(int i=0; i<N; i++){
            if(str.charAt(i)=='(') OpenClose++;
            else OpenClose--;
        }
        return OpenClose!=0;
    }
}
