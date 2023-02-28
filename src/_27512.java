import java.io.*;
import java.util.*;

public class _27512 {
    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int result = Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        if(result%2==1) result--;
        System.out.println(result);
    }
}
