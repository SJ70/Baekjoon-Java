import java.io.*;
import java.util.*;

public class _1756 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int D,N;
    static int[] Oven;
    static boolean[] hasPizza;
    public static void main(String[] args) throws IOException {
        InputOven();
        //test_print();
        InputPizza();
        //test_print();
        System.out.println(lastIndex);
    }
    public static void InputOven() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        D = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        Oven = new int[D];
        EndIndex = D-1;
        st = new StringTokenizer(br.readLine());
        Oven[0] = Integer.parseInt(st.nextToken());
        for(int i=1; i<D; i++){
            int tmp = Integer.parseInt(st.nextToken());
            Oven[i] = Math.min(Oven[i-1],tmp);  // 중간이 위보다 넓어도 소용이 없음
        }
    }
    static int EndIndex;
    static int lastIndex;
    public static void InputPizza() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int pizza = Integer.parseInt(st.nextToken());
            if( pizza > Oven[0] ){  // 입구에 안 들어가는 경우
                lastIndex=0;
                return;
            }
            lastIndex = BS(pizza,0,EndIndex);
        }
    }
    public static int BS(int pizza, int left, int right){
        int mid = (right+left)/2;
        //System.out.printf("%d: %d~%d~%d\n",pizza,left,mid,right);
        if( pizza<=Oven[mid] && ( mid+1==D || pizza>Oven[mid+1] ) ){
            //System.out.println("stacked");
            EndIndex = mid;
            Oven[mid]=0;
            return mid +1;
        }
        else if( pizza>Oven[mid] ){
            //System.out.println("searchLeft");
            return BS(pizza,left,mid);
        }
        else if( pizza<=Oven[mid+1] ){
            //System.out.println("searchRight");
            return BS(pizza,mid+1,right);
        }
        return 0;
    }
    public static void test_print(){
        System.out.println();
        for(int i=0; i<D; i++){
            for(int j=0; j<Oven[i]; j++)
                System.out.print(".");
            System.out.println("|");
        }
    }
}
