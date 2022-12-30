import java.io.*;

public class _5543 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int burger = Math.min(Integer.parseInt(br.readLine()),Math.min(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine())));
        int drink = Math.min(Integer.parseInt(br.readLine()),Integer.parseInt(br.readLine()));
        System.out.println(burger+drink-50);
    }
}
