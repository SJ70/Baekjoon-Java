import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class _2590_test {

    @ParameterizedTest
    @CsvSource({
            "0,0,0,0,0,0,0",

            "1,0,0,0,0,0,1",
            "36,0,0,0,0,0,1",
            "37,0,0,0,0,0,2",

            "0,1,0,0,0,0,1",
            "0,9,0,0,0,0,1",
            "0,10,0,0,0,0,2",

            "0,0,1,0,0,0,1",
            "0,0,4,0,0,0,1",
            "0,0,5,0,0,0,2",

            "0,0,0,1,0,0,1",
            "0,0,0,2,0,0,2",

            "0,0,0,0,1,0,1",
            "0,0,0,0,2,0,2",

            "0,0,0,0,0,1,1",
            "0,0,0,0,0,2,2",
    })
    public void test(int one, int two, int three, int four, int five, int six, int expected){
        int[] arr = new int[]{0, one, two, three, four, five, six};
        Assertions.assertEquals(_2590.getBoardCnt(arr), expected);
    }
}
