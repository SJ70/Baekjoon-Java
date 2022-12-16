import java.io.*;

public class _14581 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static final String FAN = ":fan:";
    public static void main(String[] args) throws IOException {
        for(int i=0; i<3; i++) sb.append(FAN);
        sb.append('\n').append(FAN).append(':').append(br.readLine()).append(':').append(FAN).append('\n');
        for(int i=0; i<3; i++) sb.append(FAN);
        System.out.println(sb);
    }
}
