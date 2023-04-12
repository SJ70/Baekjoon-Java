import java.io.*;

public class _26489{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        while(true){
            try{
                char a = br.readLine().charAt(0);
                result++;
            }
            catch(Exception e){
                System.out.println(result);
                return;
            }
        }
    }
}