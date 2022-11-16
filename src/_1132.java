import java.io.*;

public class _1132 {
    static int N;
    static String[] Arr;
    static long[] Influence = new long[10];
    static Integer[] AlphabetValue = new Integer[10];
    static boolean[] ZeroUnable = new boolean[10];
    public static void main(String[] args) throws IOException{
        init();
        checkZeroUnable();
        observeInfluence();
        setValue();
//        printStatus();
        System.out.println(Sum());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Arr = new String[N];
        for(int i=0; i<N; i++)
            Arr[i] = br.readLine();
    }
    public static void checkZeroUnable(){
        for(int num=0; num<N; num++){
            ZeroUnable[Arr[num].charAt(0)-'A'] = true;
        }
    }
    public static void observeInfluence(){
        for(int num=0; num<N; num++){
            for(int i=Arr[num].length()-1; i>=0; i--){
                Influence[Arr[num].charAt(i)-'A'] += digit(Arr[num].length()-1-i);
            }
        }
    }
    public static long digit(int n){
        long result = 1;
        for(int i=0; i<n; i++){
            result *= 10;
        }
        return result;
    }
    public static void setValue(){
        int MinIndex;
        long MinInfluence;
        for(int num=0; num<10; num++){
            MinIndex = -1;
            MinInfluence = 9999999999999L;
            for(int i=0; i<10; i++){
                if(AlphabetValue[i]==null && MinInfluence>Influence[i]){
                    if(num==0 && ZeroUnable[i]) continue;
                    MinIndex = i;
                    MinInfluence = Influence[i];
                }
            }
            AlphabetValue[MinIndex] = num;
        }
    }
    public static long Sum(){
        long sum = 0L;
        for(int i=0; i<10; i++){
            sum += Influence[i] * (long)AlphabetValue[i];
        }
        return sum;
    }
    public static void printStatus(){
        System.out.println(" # | 0 | 값 | 배수");
        for(int i=0; i<10; i++){
            System.out.printf(" %c | %c | %d | %13d\n",'A'+i, ZeroUnable[i]?'x':'o', AlphabetValue[i],Influence[i]);
        }
    }
}
