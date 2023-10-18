import java.io.*;
import java.util.*;

public class _3495 {

    private static int h;
    private static int w;
    private static List<String> shape = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(getArea());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        h = Integer.parseInt(st.nextToken());
        w = Integer.parseInt(st.nextToken());

        for (int i=0; i<h; i++) {
            shape.add(br.readLine());
        }
    }

    private static int getArea() {
        int result = 0;

        for (String str : shape) {
            boolean isArea = false;
            for (int i=0; i<w; i++) {
                char value = str.charAt(i);
                if (isOutLine(value)) {
                    isArea = !isArea;
                }
                if (isArea) {
                    result++;
                }
            }
        }

        return result;
    }

    private static boolean isOutLine(char c) {
        return c=='/' || c=='\\';
    }
}
