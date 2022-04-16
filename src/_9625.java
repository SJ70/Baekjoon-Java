import java.util.Scanner;
public class _9625 {
    public static void main(String[] args){
        int K = new Scanner(System.in).nextInt();
        int[] box = new int[K+2];
        box[0] = 1;
        for(int i=0; i<=K-1; i++)
            box[i+2]=box[i]+box[i+1];
        System.out.println(box[K]+" "+box[K+1]);
    }
}