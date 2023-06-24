import java.io.*;
import java.util.*;

public class _1062 {

    static int N,K;
    static int[] Words; // bitmask
    static boolean[] SelectedAlphabets;
    static int MaxResult = 0;

    public static void main(String[] args) throws IOException{
        input();

        SelectedAlphabets = EssentialAlphabets();
        SelectAlphabets(0,5);

        System.out.println(MaxResult);
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Words = new int[N];
        for(int i=0; i<N; i++){
            Words[i] = BitMaskValueOf(br.readLine());
        }
    }

    public static boolean[] EssentialAlphabets(){
        boolean[] alphabets = new boolean[26];
        alphabets['a'-'a'] = alphabets['n'-'a'] = alphabets['t'-'a'] = alphabets['i'-'a'] = alphabets['c'-'a'] = true;
        return alphabets;
    }

    public static int BitMaskValueOf(String str){
        boolean[] alphabets = EssentialAlphabets();
        for(int i=4; i<str.length()-4; i++){
            alphabets[str.charAt(i)-'a'] = true;
        }
        return BitMaskValueOf(alphabets);
    }

    public static int BitMaskValueOf(boolean[] alphabets){
        int result = 0;
        for(int i=0; i<26; i++){
            if(alphabets[i]) result++;
            result = result<<1;
        }
//        System.out.println(Integer.toBinaryString(result));

        return result;
    }

    public static void SelectAlphabets(int i, int cnt){
        if(cnt==K){
            CountReadable(BitMaskValueOf(SelectedAlphabets));
            return;
        }
        if(i>=26) return;

        if(SelectedAlphabets[i]){
            SelectAlphabets(i+1, cnt);
        }
        else{
            SelectedAlphabets[i] = true;
            SelectAlphabets(i+1,cnt+1);
            SelectedAlphabets[i] = false;
            SelectAlphabets(i+1,cnt);
        }
    }

    public static void CountReadable(int readableAlphabets){
        int result = 0;
        for(int word : Words){
            if( word == (word & readableAlphabets) ){
                result++;
            }
        }
        MaxResult = Math.max(MaxResult,result);
    }
}
