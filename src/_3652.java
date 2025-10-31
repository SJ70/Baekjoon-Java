import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _3652 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int son = Integer.parseInt(st.nextToken());
        int mom = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        while (son != mom) {
            if (son > mom) {
                sb.append('R');
                int newSon = mom;
                int newMom = son - mom;
                son = newSon;
                mom = newMom;
            }
            else {
                sb.append('L');
                int newSon = mom - son;
                int newMom = son;
                son = newSon;
                mom = newMom;
            }
//            System.out.printf("%d/%d\n", son, mom);
        }
        System.out.println(sb);
    }

}
