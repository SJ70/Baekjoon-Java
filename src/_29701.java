import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class _29701 {

    public static void main(String[] args) throws IOException {

        final HashMap<String, String> MORSE_CODES = new HashMap<>();
        MORSE_CODES.put(".-", "A");
        MORSE_CODES.put("-...", "B");
        MORSE_CODES.put("-.-.", "C");
        MORSE_CODES.put("-..", "D");
        MORSE_CODES.put(".", "E");
        MORSE_CODES.put("..-.", "F");
        MORSE_CODES.put("--.", "G");
        MORSE_CODES.put("....", "H");
        MORSE_CODES.put("..", "I");
        MORSE_CODES.put(".---", "J");
        MORSE_CODES.put("-.-", "K");
        MORSE_CODES.put(".-..", "L");
        MORSE_CODES.put("--", "M");
        MORSE_CODES.put("-.", "N");
        MORSE_CODES.put("---", "O");
        MORSE_CODES.put(".--.", "P");
        MORSE_CODES.put("--.-", "Q");
        MORSE_CODES.put(".-.", "R");
        MORSE_CODES.put("...", "S");
        MORSE_CODES.put("-", "T");
        MORSE_CODES.put("..-", "U");
        MORSE_CODES.put("...-", "V");
        MORSE_CODES.put(".--", "W");
        MORSE_CODES.put("-..-", "X");
        MORSE_CODES.put("-.--", "Y");
        MORSE_CODES.put("--..", "Z");
        MORSE_CODES.put(".----", "1");
        MORSE_CODES.put("..---", "2");
        MORSE_CODES.put("...--", "3");
        MORSE_CODES.put("....-", "4");
        MORSE_CODES.put(".....", "5");
        MORSE_CODES.put("-....", "6");
        MORSE_CODES.put("--...", "7");
        MORSE_CODES.put("---..", "8");
        MORSE_CODES.put("----.", "9");
        MORSE_CODES.put("-----", "0");
        MORSE_CODES.put("--..--", ",");
        MORSE_CODES.put(".-.-.-", ".");
        MORSE_CODES.put("..--..", "?");
        MORSE_CODES.put("---...", ":");
        MORSE_CODES.put("-....-", "-");
        MORSE_CODES.put(".--.-.", "@");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        List<String> morseCodes = Arrays.stream(br.readLine().split(" ")).collect(Collectors.toList());
        System.out.println(morseCodes.stream().map(MORSE_CODES::get).collect(Collectors.joining("")));
    }

}
