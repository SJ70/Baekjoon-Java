import java.io.*;

public class _11365 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = "";
        while(!(str=br.readLine()).equals("END")){
            for(int i=str.length()-1; i>=0; i--){
                sb.append(str.charAt(i));
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
