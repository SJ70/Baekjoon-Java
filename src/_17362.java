import java.io.*;

public class _17362 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        int result = N%8;

        switch(result){
            case 6 : result = 4; break;
            case 7 : result = 3; break;
            case 0 : result = 2; break;
        }

        System.out.println(result);
    }
}
