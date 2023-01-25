import java.io.*;

public class _1439 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        char tmp = '2';
        int section = 0;
        for(int i=0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c!=tmp){
                section++;
                tmp = c;
            }
        }
        System.out.println(section/2);
    }
}
