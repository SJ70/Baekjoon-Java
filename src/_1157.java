import java.util.Scanner;

public class _1157 {
    public static void main(String[] args){
        String S = new Scanner(System.in).next();
        int[] arr = new int[26];
        for(int i=0; i<S.length(); i++){
            int n = S.charAt(i);
            if(n<=90) n-=65;
            else n-=97;
            arr[n]++;
        }
        int max_index = 0;
        for(int i=0; i<26; i++)
            if(arr[max_index] < arr[i])
                max_index = i;

        char result = (char)(max_index+65);
        for(int i=0; i<26; i++)
            if( i!=max_index && arr[max_index]==arr[i] ){
                result = '?';
                break;
            }
        System.out.println(result);
    }
}
