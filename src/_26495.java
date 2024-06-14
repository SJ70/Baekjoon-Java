import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26495 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] values = br.readLine().toCharArray();

        for (int i = 0; i < values.length; i++) {
            switch (values[i]) {
                case '0' : sb.append("0000\n0  0\n0  0\n0  0\n0000"); break;
                case '1' : sb.append("   1\n   1\n   1\n   1\n   1"); break;
                case '2' : sb.append("2222\n   2\n2222\n2\n2222"); break;
                case '3' : sb.append("3333\n   3\n3333\n   3\n3333"); break;
                case '4' : sb.append("4  4\n4  4\n4444\n   4\n   4"); break;
                case '5' : sb.append("5555\n5\n5555\n   5\n5555"); break;
                case '6' : sb.append("6666\n6\n6666\n6  6\n6666"); break;
                case '7' : sb.append("7777\n   7\n   7\n   7\n   7"); break;
                case '8' : sb.append("8888\n8  8\n8888\n8  8\n8888"); break;
                case '9' : sb.append("9999\n9  9\n9999\n   9\n   9"); break;
            }
            if (i < values.length - 1) {
                sb.append("\n\n");
            }
        }

        System.out.print(sb);

    }

}
