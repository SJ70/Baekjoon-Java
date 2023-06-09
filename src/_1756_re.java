import java.io.*;
import java.util.*;

public class _1756_re {

    public static void main(String[] args) throws IOException {
        input();
        resizeOven();
        System.out.println(getResult());
    }

    static int OvenDepth, PizzaCnt;
    static int[] Oven;
    static StringTokenizer Pizza;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void input() throws IOException {
        StringTokenizer st;

        st= new StringTokenizer(br.readLine());
        OvenDepth = Integer.parseInt(st.nextToken());
        PizzaCnt = Integer.parseInt(st.nextToken());

        Oven = new int[OvenDepth];
        st= new StringTokenizer(br.readLine());
        for(int i=0; i<OvenDepth; i++){
            Oven[i] = Integer.parseInt(st.nextToken());
        }

        Pizza = new StringTokenizer(br.readLine());
    }

    public static void resizeOven(){
        for(int i=1; i<OvenDepth; i++){
            Oven[i] = Math.min(Oven[i], Oven[i-1]);
        }
//        for(int i=0; i<OvenDepth; i++)
//            System.out.printf("%3d",Oven[i]);
//        System.out.println();
    }

    public static int getResult(){
        int lastOvenFloor = OvenDepth;

        for(int i=0; i<PizzaCnt; i++){
            int pizza = Integer.parseInt(Pizza.nextToken());
            lastOvenFloor = searchPlaceableDepth( pizza, 0, lastOvenFloor-1 );
//            System.out.println(lastOvenFloor+'\n');
            if(lastOvenFloor == -1) break;
        }

        return lastOvenFloor + 1;
    }

    public static int searchPlaceableDepth(int pizza, int high, int low){
//        System.out.printf("%d -> %d~%d\n",pizza,high,low);
        if( low<0 ) return -1;
        if( pizza>Oven[high] ) return -1;
        if( pizza<=Oven[low] ) return low;

        int mid = (high+low)/2;
        if( Oven[mid]>=pizza && Oven[mid+1]<pizza ) return mid;
        else if( pizza > Oven[mid] ) return searchPlaceableDepth(pizza, high, mid-1);
        else return searchPlaceableDepth(pizza, mid, low);
    }
}
