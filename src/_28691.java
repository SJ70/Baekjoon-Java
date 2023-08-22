import java.io.*;

public class _28691 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char c = br.readLine().charAt(0);
        String str = c=='M' ? "MatKor" : c=='W' ? "WiCys" : c=='C' ? "CyKor" : c=='A' ? "AlKor" : "$clear";
        System.out.println(str);
    }
}
