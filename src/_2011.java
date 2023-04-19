import java.io.*;

public class _2011 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        if(str.charAt(0)=='0'){
            // 01, 011, 0111 ...
            System.out.println(0);
            return;
        }
        int[] arr = new int[str.length()];

        arr[0]=1;
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i)=='0' && str.charAt(i-1)!='1' && str.charAt(i-1)!='2'){
                // 100, 1030, 1040 ...
                System.out.println(0);
                return;
            }

            if(str.charAt(i)!='0'){
                arr[i] += arr[i-1];
            }
            if(str.charAt(i-1)=='1' || (str.charAt(i-1)=='2' && str.charAt(i)<='6')){
                // 10 ~ 26
                arr[i] += (i<2) ? 1 : arr[i-2];
            }
            arr[i] %= 1000000;
        }

        System.out.println(arr[str.length()-1]);

//        for(int i : arr) System.out.printf("%d ",i);
    }
}
