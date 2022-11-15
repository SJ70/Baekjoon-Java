import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _2143 {
    static int TARGET, ASize, BSize;
    static ArrayList<Long> A = new ArrayList<>();
    static ArrayList<Long> B = new ArrayList<>();
    static HashMap<Long,Long> B_HM = new HashMap<>();
    public static void main(String[] args) throws IOException{
        init();
//        print(A);
//        print(B);
//        print(B_HM);
        System.out.println(getCasesToTarget());
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TARGET = Integer.parseInt(br.readLine());

        ASize = Integer.parseInt(br.readLine());
        inputValues(A, new StringTokenizer(br.readLine()));

        BSize = Integer.parseInt(br.readLine());
        inputValues(B, new StringTokenizer(br.readLine()));
        inputValues(B_HM, B);
    }
    public static void inputValues(ArrayList<Long> AL, StringTokenizer st){
        int previousNumberStartIndex = 0;
        int currentNumberStartIndex;

        while(st.hasMoreTokens()){
            currentNumberStartIndex = AL.size();
            long value = Long.parseLong(st.nextToken());
            AL.add(value);
//            System.out.printf("\n%5d = %d\n",value,value);
            for(int k=previousNumberStartIndex; k<currentNumberStartIndex; k++){
//                System.out.printf("%d + %d = %d\n",AL.get(k), value, AL.get(k) + value);
                AL.add(AL.get(k) + value);
            }
            previousNumberStartIndex = currentNumberStartIndex;
        }
    }
    public static void inputValues(HashMap<Long,Long> HM, ArrayList<Long> AL){
        for(long element : AL){
            if(HM.containsKey(element)){
                HM.replace(element, HM.get(element)+1);
            }
            else HM.put(element,1L);
        }
    }
    public static void print(ArrayList<Long> AL){
        for(long element : AL){
            System.out.printf("%d ",element);
        }
        System.out.println();
    }
    public static void print(HashMap<Long,Long> HM){
        for(Map.Entry<Long,Long> e : HM.entrySet()){
            System.out.printf("%d : %d\n",e.getKey(),e.getValue());
        }
    }
    public static long getCasesToTarget(){
        long result = 0;
        for(long element : A){
            long target = TARGET - element;
            if(B_HM.containsKey(target))
                result += B_HM.get(target);
        }
        return result;
    }
}
