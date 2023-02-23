import java.io.*;
import java.util.*;

public class _26307 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int answer = (Integer.parseInt(st.nextToken())-9) *60;
        answer += Integer.parseInt(st.nextToken());
        System.out.println(answer);
    }
}
