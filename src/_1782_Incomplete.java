import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1782_Incomplete {
    static long FROM, UNTIL;
    static int fromDigit, untilDigit;
    public static void main(String[] args) throws IOException{
        while(true){
        init();
        System.out.printf("fromDigit:%d, untilDigit:%d\n",fromDigit,untilDigit);
        long Result = 0;
        if(untilDigit > fromDigit+1)
            Result += getMiddleCnt();
        System.out.println(Result);
        //Result +=
        }
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        FROM = Long.parseLong(st.nextToken());
        UNTIL = Long.parseLong(st.nextToken());
        fromDigit = (FROM==0) ? 1 : (int)Math.log10(FROM) +1;
        untilDigit = (UNTIL==0) ? 1 : (int)Math.log10(UNTIL) +1;
    }
    public static long getMiddleCnt(){
        long Sum_FROM_odd = 12 * GP_Sum(fromDigit/2 - (1-fromDigit%2) );
        long Sum_FROM_even = 20 * GP_Sum(fromDigit/2 - 1 );
        System.out.printf("from : odd:%d, even:%d\n",Sum_FROM_odd,Sum_FROM_even);
        long Sum_FROM = Sum_FROM_odd + Sum_FROM_even;
        if(fromDigit>=1) Sum_FROM+=3;
        if(fromDigit>=2) Sum_FROM+=4;

        long Sum_UNTIL_odd = 12 * GP_Sum( (untilDigit-1)/2 - (1-(untilDigit-1)%2) );
        long Sum_UNTIL_even = 20 * GP_Sum( (untilDigit-1)/2 - 1 );
        System.out.printf("until : odd:%d, even:%d\n",Sum_UNTIL_odd,Sum_UNTIL_even);
        long Sum_UNTIL = Sum_UNTIL_odd + Sum_UNTIL_even;
        if((untilDigit-1)>=1) Sum_UNTIL+=3;
        if((untilDigit-1)>=2) Sum_UNTIL+=4;
        System.out.printf("sum_from:%d, sum_until:%d\n",Sum_FROM,Sum_UNTIL);

        return Sum_UNTIL - Sum_FROM;
    }
    public static long GP_Sum(long n){
        if(n<0) return 0;
        return (long)((Math.pow(5,n)-1)/4);
    }

    // 가장 작은 자릿수에서 큰 수와 가장 큰 자릿수에서 작은 수를 구하는 로직 필요
}
