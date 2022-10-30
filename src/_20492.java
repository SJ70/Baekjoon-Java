import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _20492 {
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();
        int value1 = (int)(N*0.78);
        int value2 = (int)((N*0.8)+(N*0.2)*0.78);
        sb.append(value1).append(' ').append(value2);
        System.out.print(sb);
    }
}
