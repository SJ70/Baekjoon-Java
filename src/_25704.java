import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class _25704 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int couponCnt = Integer.parseInt(br.readLine());
        int price = Integer.parseInt(br.readLine());
        List<Integer> discountedPrices = new ArrayList<>();
        if (couponCnt >= 20) {
            discountedPrices.add(price * 3 / 4);
        }
        if (couponCnt >= 15) {
            discountedPrices.add(Math.max(price - 2000, 0));
        }
        if (couponCnt >= 10) {
            discountedPrices.add(price * 9 / 10);
        }
        if (couponCnt >= 5) {
            discountedPrices.add(Math.max(price - 500, 0));
        }
        System.out.println(discountedPrices.stream().min(Integer::compareTo).orElse(price));
    }

}
