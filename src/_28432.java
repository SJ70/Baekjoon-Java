import java.io.*;
import java.util.ArrayList;

public class _28432 {
    static int N, M, QuestionIndex;
    static String[] Strings;
    static ArrayList<String> Answers = new ArrayList<>();
    static char startChar, endChar;

    public static void main(String[] args) throws IOException{
        init();
        startChar = (QuestionIndex-1 == -1) ? '.' : Strings[QuestionIndex-1].charAt(Strings[QuestionIndex-1].length()-1);
        endChar = (QuestionIndex+1 == N) ? '.' : Strings[QuestionIndex+1].charAt(0);

        for(String Answer : Answers){
            boolean start = startChar=='.' || startChar==Answer.charAt(0);
            boolean end = endChar=='.' || endChar==Answer.charAt(Answer.length()-1);
            if(start && end){
                System.out.println(Answer);
                return;
            }
        }
    }
    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Strings = new String[N];
        for(int i=0; i<N; i++){
            Strings[i] = br.readLine();
            if(Strings[i].charAt(0)=='?'){
                QuestionIndex = i;
            }
        }
        M = Integer.parseInt(br.readLine());
        loop1: for(int i=0; i<M; i++){
            String Answer = br.readLine();
            for(String str : Strings){
                if(Answer.equals(str)){
                    continue loop1;
                }
            }
            Answers.add(Answer);
        }
    }
}
