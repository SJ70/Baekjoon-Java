import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1251 {
    static String str;
    public static void main(String[] args) throws IOException{
        Init();
        String result = "";
        StringBuilder tmp1, tmp2;
        for(int i=0; i<str.length()-2; i++){
            tmp1 = Flip(0,i);
            if(SearchNeedless(tmp1.toString(), result)) continue;
            for(int j=i+1; j<str.length()-1; j++){
                tmp2 = new StringBuilder(tmp1);
                tmp2.append(Flip(i+1,j));
                tmp2.append(Flip(j+1,str.length()-1));
                result = Min(result, tmp2.toString());
                //System.out.println(tmp2);
            }
        }
        System.out.print(result);
    }
    public static void Init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
    }
    public static StringBuilder Flip(int start, int end){
        StringBuilder sb = new StringBuilder();
        for(int i=end; i>=start; i--){
            sb.append(str.charAt(i));
        }
        return sb;
    }
    public static String Min(String s1, String s2){
        if(s1.equals("")) return s2;
        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i)<s2.charAt(i)) return s1;
            if(s1.charAt(i)>s2.charAt(i)) return s2;
        }
        return s1;
    }
    public static boolean SearchNeedless(String tmp, String min){
        if(min.equals("")) return false;
        for(int i=0; i<tmp.length(); i++){
            if(tmp.charAt(i) > min.charAt(i)) return true;
            if(tmp.charAt(i) < min.charAt(i)) return false;
        }
        return false;
    }
}