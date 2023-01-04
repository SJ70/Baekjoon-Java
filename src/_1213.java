import java.io.*;

public class _1213 {
    public static void main(String[] args) throws IOException{
        init();
        System.out.print(Palindrome());
    }
    static int N;
    static int[] AlphabetCnt = new int[26];
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        N = str.length();
        for(int i=0; i<str.length(); i++)
            AlphabetCnt[str.charAt(i)-'A']++;
    }
    static final String ERROR = "I'm Sorry Hansoo";
    public static String Palindrome(){
        char[] result = new char[N];
        int result_i = 0;
        int i = 0; // 알파벳 인덱스
        int fill = 0;
        while(i<26 && fill<N){
            if(AlphabetCnt[i]==0){
                i++;
            }
            else if(AlphabetCnt[i]==1){
                // 문자열의 길이가 짝수 || 홀수이지만 중간에 이미 문자가 있는 경우 : 에러
                if( N%2==0 || result[N/2]!='\u0000' ) return ERROR;

                result[N/2]=(char)('A'+i);
                AlphabetCnt[i]--;
                fill++;
            }
            else if(AlphabetCnt[i]>=2){
                result[result_i] = result[N-1-result_i] = (char)('A'+i);
                result_i++;
                AlphabetCnt[i]-=2;
                fill+=2;
            }
//            System.out.println(result);
        }
        return String.valueOf(result);
    }
}
