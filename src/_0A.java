import java.io.*;

public class _0A {
    static String KR = "KOREA";
    static String YS = "YONSEI";
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int KR_i = 0;
        int YS_i = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==KR.charAt(KR_i)) KR_i++;
            if(str.charAt(i)==YS.charAt(YS_i)) YS_i++;
            if(KR_i==KR.length()){
                System.out.println(KR);
                return;
            }
            else if(YS_i==YS.length()){
                System.out.println(YS);
                return;
            }
        }
    }
}
