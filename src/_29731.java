import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _29731 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = new ArrayList<>();
        arr.add("Never gonna give you up");
        arr.add("Never gonna let you down");
        arr.add("Never gonna run around and desert you");
        arr.add("Never gonna make you cry");
        arr.add("Never gonna say goodbye");
        arr.add("Never gonna tell a lie and hurt you");
        arr.add("Never gonna stop");

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            if(!arr.contains(str)){
                System.out.println("Yes");
                return;
            }
        }
        System.out.println("No");
    }
}
