import java.io.*;

public class _28235 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        System.out.println(
            str.equals("SONGDO") ? "HIGHSCHOOL" :
            str.equals("CODE") ? "MASTER" :
            str.equals("2023") ? "0611" : "CONTEST"
        );
    }
}
