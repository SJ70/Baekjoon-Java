import java.io.*;

public class _27866 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(str.charAt(Integer.parseInt(br.readLine())-1));
    }
}
