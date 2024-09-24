import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _32154 {

    private static String[] values = {
            "",
            "A B C D E F G H J L M",
            "A C E F G H I L M",
            "A C E F G H I L M",
            "A B C E F G H L M",
            "A C E F G H L M",
            "A C E F G H L M",
            "A C E F G H L M",
            "A C E F G H L M",
            "A C E F G H L M",
            "A B C F G H L M",
    };

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println((values[N].length() + 1) / 2);
        System.out.println(values[N]);

    }

}
