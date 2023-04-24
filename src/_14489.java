import java.io.*;
import java.util.StringTokenizer;

public class _14489 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        int price = Integer.parseInt(br.readLine()) * 2;
        if(money>=price) money -= price;
        System.out.println(money);
    }
}
