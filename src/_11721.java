import java.io.*;

public class _11721 {
    public static void main(String[] args)throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = new BufferedReader(new InputStreamReader(System.in)).readLine();
        for(int i=0; i<input.length(); i++){
            bw.write(input.charAt(i));
            if((i+1)%10==0) bw.write("\n");
        }
        bw.flush();
    }
}
