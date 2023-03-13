import java.io.*;

public class _1371 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = new char[26];
        while(true){
            try{
                String str = br.readLine();
                for(int i=0; i<str.length(); i++){
                    char c = str.charAt(i);
                    if(c>='a' && c<='z'){
                        arr[(int)c-'a']++;
                    }
                }
            }
            catch(Exception e){
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        int cnt = -1;
        for(int i=0; i<26; i++){
            if(cnt<arr[i]){
                sb = new StringBuilder();
                sb.append((char)(i+'a'));
                cnt = arr[i];
            }
            else if(cnt==arr[i]){
                sb.append((char)(i+'a'));
            }
        }
        System.out.print(sb);
    }
}
