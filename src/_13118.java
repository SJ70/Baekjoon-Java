import java.io.*;
import java.util.*;

public class _13118 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer people = new StringTokenizer(br.readLine());
        StringTokenizer circle = new StringTokenizer(br.readLine());

        int pos = Integer.parseInt(circle.nextToken());

        for(int i=0; i<4; i++){
            int person = Integer.parseInt(people.nextToken());
            if(pos==person){
                System.out.println(i+1);
                return;
            }
        }

        System.out.println(0);
    }
}
