import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class _4378 {

    private static Map<Character, Character> map = Map.ofEntries(
            Map.entry(' ', ' '),

            Map.entry('1', '`'),
            Map.entry('2', '1'),
            Map.entry('3', '2'),
            Map.entry('4', '3'),
            Map.entry('5', '4'),
            Map.entry('6', '5'),
            Map.entry('7', '6'),
            Map.entry('8', '7'),
            Map.entry('9', '8'),
            Map.entry('0', '9'),
            Map.entry('-', '0'),
            Map.entry('=', '-'),

            Map.entry('W', 'Q'),
            Map.entry('E', 'W'),
            Map.entry('R', 'E'),
            Map.entry('T', 'R'),
            Map.entry('Y', 'T'),
            Map.entry('U', 'Y'),
            Map.entry('I', 'U'),
            Map.entry('O', 'I'),
            Map.entry('P', 'O'),
            Map.entry('[', 'P'),
            Map.entry(']', '['),
            Map.entry('\\', ']'),

            Map.entry('S', 'A'),
            Map.entry('D', 'S'),
            Map.entry('F', 'D'),
            Map.entry('G', 'F'),
            Map.entry('H', 'G'),
            Map.entry('J', 'H'),
            Map.entry('K', 'J'),
            Map.entry('L', 'K'),
            Map.entry(';', 'L'),
            Map.entry('\'', ';'),

            Map.entry('X', 'Z'),
            Map.entry('C', 'X'),
            Map.entry('V', 'C'),
            Map.entry('B', 'V'),
            Map.entry('N', 'B'),
            Map.entry('M', 'N'),
            Map.entry(',', 'M'),
            Map.entry('.', ','),
            Map.entry('/', '.')
    );

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;

        while (true) {
            input = br.readLine();
            if (input == null) {
                return;
            }
            solve(input);
        }

    }

    private static void solve(String input) {
        String result = input.chars()
                .mapToObj(value -> (char) value)
                .map(value -> map.get(value))
                .map(String::valueOf)
                .collect(Collectors.joining());

        System.out.println(result);
    }

}
