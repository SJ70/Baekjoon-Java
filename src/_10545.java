import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10545 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] values = new String[9];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<9; i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            values[idx] = String.valueOf(i + 1);
        }
        String str = br.readLine();

        char last = '.';
        for (char c : str.toCharArray()) {
            String add = ".";
            switch (c) {
                case ' ' : add = values[0]; break;
                case 'a' : add = values[1]; break;
                case 'b' : add = values[1].repeat(2); break;
                case 'c' : add = values[1].repeat(3); break;
                case 'd' : add = values[2]; break;
                case 'e' : add = values[2].repeat(2); break;
                case 'f' : add = values[2].repeat(3); break;
                case 'g' : add = values[3]; break;
                case 'h' : add = values[3].repeat(2); break;
                case 'i' : add = values[3].repeat(3); break;
                case 'j' : add = values[4]; break;
                case 'k' : add = values[4].repeat(2); break;
                case 'l' : add = values[4].repeat(3); break;
                case 'm' : add = values[5]; break;
                case 'n' : add = values[5].repeat(2); break;
                case 'o' : add = values[5].repeat(3); break;
                case 'p' : add = values[6]; break;
                case 'q' : add = values[6].repeat(2); break;
                case 'r' : add = values[6].repeat(3); break;
                case 's' : add = values[6].repeat(4); break;
                case 't' : add = values[7]; break;
                case 'u' : add = values[7].repeat(2); break;
                case 'v' : add = values[7].repeat(3); break;
                case 'w' : add = values[8]; break;
                case 'x' : add = values[8].repeat(2); break;
                case 'y' : add = values[8].repeat(3); break;
                case 'z' : add = values[8].repeat(4); break;
            }
            if (last == add.charAt(0)) {
                sb.append('#');
            }
            last = add.charAt(0);
            sb.append(add);
        }

        System.out.println(sb);

    }

}
