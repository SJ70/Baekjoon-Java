import java.io.*;
import java.util.*;

public class _16139 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[][] alphabets = new int[26][str.length()];
        for(int c=0; c<str.length(); c++){
            for(int A=0; A<26; A++){
                alphabets[A][c] += c==0 ? 0 : alphabets[A][c-1];
            }
            alphabets[str.charAt(c)-'a'][c]++;
        }
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphabet = st.nextToken().charAt(0)-'a';
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int A = a>0 ? alphabets[alphabet][a-1] : 0;
            int B = alphabets[alphabet][b];
            sb.append((B-A)+"\n");
        }
        System.out.println(sb);
    }
}