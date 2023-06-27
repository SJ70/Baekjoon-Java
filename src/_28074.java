import java.io.*;

public class _28074 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        boolean M,O,B,I,S;
        M = O = B = I = S = false;
        for(int i=0; i<str.length(); i++){
            switch(str.charAt(i)){
                case 'M' : M=true; break;
                case 'O' : O=true; break;
                case 'B' : B=true; break;
                case 'I' : I=true; break;
                case 'S' : S=true; break;
            }
        }
        System.out.println( ( M && O && B && I && S ) ? "YES" : "NO" );
    }
}
