import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1264 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        StringBuilder sb = new StringBuilder();
        while(!(str=br.readLine()).equals("#")){
            int cnt = 0;
            for(int i=0; i<str.length(); i++){
                if(isVowel(str.charAt(i))){
                    cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.print(sb);
    }
    public static boolean isVowel(char c){
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}