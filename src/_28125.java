import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class _28125 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultSb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            int length = str.length();
            StringBuilder sb = new StringBuilder();
            int changeCnt = 0;
            for (int j=0; j<length; j++) {
                switch (str.charAt(j)) {
                    case '@' : sb.append('a'); changeCnt++; break;
                    case '[' : sb.append('c'); changeCnt++; break;
                    case '!' : sb.append('i'); changeCnt++; break;
                    case ';' : sb.append('j'); changeCnt++; break;
                    case '^' : sb.append('n'); changeCnt++; break;
                    case '0' : sb.append('o'); changeCnt++; break;
                    case '7' : sb.append('t'); changeCnt++; break;
                    case '\\' :
                        switch (str.charAt(j+1)) {
                            case '\'' : sb.append('v'); j++; changeCnt++; break;
                            case '\\' : sb.append('w'); j+=2; changeCnt++; break;
                        }
                        break;
                    default: sb.append(str.charAt(j));
                }
            }
            String result = sb.toString();
            if (changeCnt * 2 >= result.length()) {
                resultSb.append("I don't understand\n");
            }
            else {
                resultSb.append(result);
                resultSb.append('\n');
            }
        }
        System.out.print(resultSb);
    }

}
