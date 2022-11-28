import java.io.*;

public class _1019 {
    static int N;
    static int[] Arr;
    public static void main(String[] args) throws IOException{
//        while(true){
            init();
            solve();
            print(Arr);
//        }
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Arr = new int[10];
    }
    public static void print(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int element : arr)
            sb.append(element).append(' ');
        System.out.println(sb);
    }
    public static void solve(){
        int N_digit = (int)Math.pow(10, (int)Math.log10(N));

        for(int digit=N_digit; digit>=1; digit/=10){
//            print(Arr);
            int quotient = N/digit;
            int remainder = N%digit;
//            System.out.printf("N:%d, 자릿수:%d, 몫:%d, 나머지:%d\n",N,digit,quotient,remainder);

            // 628
            // : 6xx
            Arr[quotient] += remainder+1;

            // 599
            // : 0xx~5xx (+100)
            for(int i=(digit==N_digit)?1:0; i<=quotient-1; i++)
                Arr[i] += digit;
            // : 6(0~5) * [00~99]
            addFromZeroUntil(digit-1, quotient);

            N = remainder;
        }
        removeUnlessZero(N_digit);
    }

    /* 공식
     * 0~9			    [0~9]*1*1
     * 00~99		    [0~9]*2*10
     * 000~999		    [0~9]*3*100
     * 0000~9999		[0~9]*4*1000
     * 00000~99999		[0~9]*5*10000 */
    /** until ex) 9, 99, 999, 999, 9999, 99999 등 모두 9로 이루어진 수... */
    public static void addFromZeroUntil(int until, int repeat){
        if(until<1 || repeat==0) return;

        // digit : 1, 10, 100, 1000 ...
        int digit = (until+1)/10;
        // digitLength : 1, 2, 3, 4 ...
        int digitLength = (int)Math.log10(until+1);

        // add [0~9]
        int add = digit * digitLength * repeat;
        for(int i=0; i<=9; i++)
            Arr[i] += add;
    }
    /** 앞 자리에 나올 수 있는 불필요한 0 제거 */
    public static void removeUnlessZero(int digit){
        Arr[0] -= (digit-1)/9;
    }
}
