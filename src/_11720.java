import java.io.*;

public class _11720 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String X = br.readLine();
        X = br.readLine();
        int result = 0;
        for(int i=0; i<X.length(); i++){
            result += (X.charAt(i)-48);
        }
        System.out.println(result);
    }
}
