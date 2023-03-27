import java.io.*;

public class _1701 {
    public static void main(String[] args) throws IOException{
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        int max_length = 0;

        for(int i=1; i<str.length(); i++){
            int same_length = 0;
//            System.out.println(str.substring(i));
            for(int j=0; j<str.length()-i; j++){
//                System.out.printf("%c %c \n",str.charAt(j),str.charAt(j+i));
                same_length = (str.charAt(j)==str.charAt(j+i)) ? same_length+1 : 0;
                max_length = Math.max(max_length, same_length);
            }
        }

        System.out.println(max_length);
    }
}
