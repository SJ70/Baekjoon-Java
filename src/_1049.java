import java.util.*;
public class _1049 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] min_price = {1000,1000};   // 6패키지,낱개
        // 최저가 설정
        for(int i=0;i<M;i++){
            min_price[0] = Math.min(min_price[0],sc.nextInt());
            min_price[1] = Math.min(min_price[1],sc.nextInt());
        }
        int result;
        // 패키지 >= 낱개*6 = 낱개로만 구매
        if(min_price[0] >= min_price[1]*6)
            result = N * min_price[1];
        // 패키지 < 낱개*6 = 패키지로 구매 +a
        else{
            result = N/6 * min_price[0];
            N %= 6;
            // 패키지 >= 낱개*rest = 낱개로만 구매
            if(min_price[0] >= min_price[1]*N)
                result += N * min_price[1];
            // 패키지 < 낱개*rest = 패키지 1개 구매
            else result += min_price[0];
        }
        System.out.println(result);
    }
}
