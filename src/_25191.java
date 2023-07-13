import java.io.*;
import java.util.*;

public class _25191 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Chicken = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Coke = Integer.parseInt(st.nextToken());
        int Beer = Integer.parseInt(st.nextToken());
        int Drink = Coke/2 + Beer;
        System.out.println(Math.min(Chicken, Drink));
    }
}
