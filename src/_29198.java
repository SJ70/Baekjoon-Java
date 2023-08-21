import java.io.*;
import java.util.*;

public class _29198 {

    private static class Word implements Comparable<Word>{
        int[] alphabets = new int[26];

        public Word(String str){
            int length = str.length();
            for(int i=0; i<length; i++){
                char c = str.charAt(i);
                alphabets[c-'A']++;
            }
        }

        public int compareTo(Word w){
            for(int i=0; i<26; i++){
                if(this.alphabets[i] != w.alphabets[i]){
                    return w.alphabets[i] - this.alphabets[i];
                }
            }
            return 0;
        }

        public void addAlphabets(Word W){
            for(int i=0; i<26; i++){
                this.alphabets[i] += W.alphabets[i];
            }
        }

        public String getNewWord(){
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<26; i++){
                int cnt = this.alphabets[i];
                char c = (char)('A'+i);
                for(int j=0; j<cnt; j++){
                    sb.append(c);
                }
            }
            return sb.toString();
        }
    }

    static int N,M,K;
    static PriorityQueue<Word> Words = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            Words.add(new Word(br.readLine()));
        }

        Word result = new Word("");
        for(int i=0; i<K; i++){
            result.addAlphabets(Words.poll());
        }

        System.out.println(result.getNewWord());
    }
}
