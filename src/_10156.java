import java.io.*;
import java.util.*;

public class _10156 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int cost = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(st.nextToken());
        int money = Integer.parseInt(st.nextToken());
        int goal = cost * cnt;
        if(goal>money) System.out.println(goal-money);
        else System.out.println(0);
    }
}
