import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _10942 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        init();
        setOddPelLength();
        setEvenPelLength();
//        printPelLength();
        printResult();
    }
    static int N;
    static int[] Arr;
    static int[] OddPelLength;
    static int[] EvenPelLength;
    public static void init() throws IOException{
        N = Integer.parseInt(br.readLine());
        Arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            Arr[i] = Integer.parseInt(st.nextToken());
        }
        OddPelLength = new int[N];
        EvenPelLength = new int[N-1];
    }
    public static void setOddPelLength(){
        for(int i=0; i<N; i++){
            OddPelLength[i]=1;
            int left = i-1;
            int right = i+1;
            while(left>=0 && right<N && Arr[left]==Arr[right]){
                OddPelLength[i]+=2;
                left--;
                right++;
            }
        }
    }
    public static void setEvenPelLength(){
        for(int i=0; i<N-1; i++){
            EvenPelLength[i]=0;
            int left = i;
            int right = i+1;
            while(left>=0 && right<N && Arr[left]==Arr[right]){
                EvenPelLength[i]+=2;
                left--;
                right++;
            }
        }
    }
    public static void printPelLength(){
        for(int element : OddPelLength)
            System.out.printf("%d ",element);
        System.out.println();
        for(int element : EvenPelLength)
            System.out.printf(" %d",element);
        System.out.println();
    }
    public static void printResult() throws IOException{
        int Question = Integer.parseInt(br.readLine());
        for(int i=0; i<Question; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) -1;
            int right = Integer.parseInt(st.nextToken()) -1;
            int result = isPelLength(left,right)?1:0;
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
    public static boolean isPelLength(int left, int right){
        boolean odd = (right-left)%2==0;
        int length = right-left+1;
        int mid = (right+left)/2;

//        System.out.printf("%d~%d~%d,(%d)\n",left,mid,right,length);
//        System.out.printf("-->%d\n",odd?OddPelLength[mid]:EvenPelLength[mid]);

        if(odd) return length<=OddPelLength[mid];
        else return length<=EvenPelLength[mid];
    }
}