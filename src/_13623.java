import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13623 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int num = a*100 + b*10 + c;

        switch (num){
            case 000:
            case 111:
                System.out.println('*');
                break;
            case 100:
            case 011:
                System.out.println('A');
                break;
            case 010:
            case 101:
                System.out.println('B');
                break;
            case 001:
            case 110:
                System.out.println('C');
                break;
        }
    }
}
