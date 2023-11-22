import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _30704 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++) {
            int count = Integer.parseInt(br.readLine());
            sb.append(getResult(count));
            sb.append('\n');
        }

        System.out.print(sb);
    }

    private static int getResult(int count) {
        int width = (int) Math.sqrt(count);
        int height = (int) Math.sqrt(count);
        if (width * height < count) {
            width++;
        }
        if (width * height < count) {
            height++;
        }
        return 2*width + 2*height;
    }

}
