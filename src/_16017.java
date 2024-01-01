import java.io.*;

public class _16017 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        int second = Integer.parseInt(br.readLine());
        int third = Integer.parseInt(br.readLine());
        int last = Integer.parseInt(br.readLine());
        if ((first == 8 || first == 9) && (last == 8 || last == 9) && second == third) {
            System.out.println("ignore");
            return;
        }
        System.out.println("answer");
    }

}
