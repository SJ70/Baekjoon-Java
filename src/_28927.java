import java.io.*;
import java.util.*;

public class _28927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = getVideoTime(br.readLine());
        int mel = getVideoTime(br.readLine());
        switch(Integer.compare(max, mel)){
            case 1 :
                System.out.println("Max");
                break;
            case -1 :
                System.out.println("Mel");
                break;
            case 0 :
                System.out.println("Draw");
                break;
        }
    }

    private static int getVideoTime(String str){
        StringTokenizer st = new StringTokenizer(str);
        int trailer = Integer.parseInt(st.nextToken()) * 3;
        int tvShow = Integer.parseInt(st.nextToken()) * 20;
        int movie = Integer.parseInt(st.nextToken()) * 2 * 60;
        return trailer + tvShow + movie;
    }
}
