import java.util.ArrayList;
import java.util.Scanner;

public class _21756 {
    static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args){
        int N = new Scanner(System.in).nextInt();
        for(int i=1; i<=N; i++){
            arr.add(i);
        }
        //PrintArr();
        while(arr.size()>1){
            Thanos();
            //PrintArr();
        }
        PrintArr();
    }
    public static void Thanos(){
        int index=0;
        while(true){
            arr.remove(index);
            index++;
            if(index > arr.size()-1) return;
        }
    }
    public static void PrintArr(){
        for(int i=0; i<arr.size(); i++){
            System.out.print(arr.get(i)+" ");
        }
        System.out.println();
    }
}
