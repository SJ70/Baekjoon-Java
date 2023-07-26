import java.io.*;
import java.util.*;

public class _1924 {
    static int[] DAYS_PER_MONTHS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    static String[] DATES = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int M = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int Days = D;
        for(int m=0; m<M-1; m++){
            Days += DAYS_PER_MONTHS[m];
        }

        System.out.println(DATES[Days%7]);
    }
}
