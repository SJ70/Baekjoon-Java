import java.io.*;
import java.util.*;

public class _16139 {
    public static class Alphabet{
        ArrayList<Integer> arr = new ArrayList<>();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Alphabet[] alphabets = new Alphabet[26];
        for(int i=0; i<26; i++){
            alphabets[i] = new Alphabet();
        }
        for(int i=0; i<str.length(); i++){
            alphabets[str.charAt(i)-'a'].arr.add(i);
        }
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = st.nextToken().charAt(0)-'a';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int result = 0;
            for(int j=0; j<alphabets[index].arr.size(); j++){
                if( alphabets[index].arr.get(j) > b ) break;
                if( alphabets[index].arr.get(j) >= a ) result++;
            }
            sb.append(result+"\n");
        }
        System.out.println(sb);
    }
}
