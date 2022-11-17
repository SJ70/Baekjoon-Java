import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _8437 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Apple = Integer.parseInt(br.readLine());
        int Diff = Integer.parseInt(br.readLine());
        int cnt = (Apple-Diff)/2;
        System.out.printf("%d\n%d",Apple-cnt,cnt);
    }
}
