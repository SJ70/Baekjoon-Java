import java.io.*;

public class _1284 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str;
        while(!(str = br.readLine()).equals("0")){
            int result = str.length() + 1;
            for(int i=0; i<str.length(); i++){
                switch(str.charAt(i)){
                    case '0' : result+=4; break;
                    case '1' : result+=2; break;
                    default : result+=3; break;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.print(sb);
    }
}
