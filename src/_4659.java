import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _4659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String str;
    public static void main(String[] args) throws IOException {
        while(!(str=br.readLine()).equals("end")){
            sb.append("<"+str+"> is"+(isAcceptable()?" ":" not ")+"acceptable.\n");
        }
        System.out.println(sb);
    }
    static boolean VowelUsed;
    public static boolean isAcceptable(){
        VowelUsed=false;
        if(str.length()==1) return isVowels(str.charAt(0));

        char recent = str.charAt(0);
        int stack = 1;
        if(isVowels(str.charAt(0))) VowelUsed=true;

        for(int i=1; i<str.length(); i++){
            if(!VowelUsed && isVowels(str.charAt(i))) VowelUsed=true;
            if(isVowels(str.charAt(i))==isVowels(recent)){
                stack++;
                if(stack==3) return false;
                if(str.charAt(i)==recent && recent!='e' && recent!='o') return false;
            }
            else{
                stack=1;
            }
            recent = str.charAt(i);
        }
        return VowelUsed;
    }
    public static boolean isVowels(char c){
        return (c=='a' || c=='e' || c=='i' || c=='o' || c=='u');
    }
}
