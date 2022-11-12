import java.util.Scanner;

public class _3733 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,s;
        while(sc.hasNext()){
            n = sc.nextInt()+1;
            s = sc.nextInt();
            System.out.println(s/n);
        }
    }
}
