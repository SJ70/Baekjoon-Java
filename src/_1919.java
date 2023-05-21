import java.io.*;

public class _1919 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];

        String str = br.readLine();
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']++;
        }
        str = br.readLine();
        for(int i=0; i<str.length(); i++){
            arr[str.charAt(i)-'a']--;
        }

        int result = 0;
        for(int i=0; i<26; i++){
            result += Math.abs(arr[i]);
        }
        System.out.println(result);
    }
}
