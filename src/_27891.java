import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _27891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for (int i=0; i<26; i++) {
            StringBuilder sb = new StringBuilder();
            for (char c : input.toCharArray()) {
                char changedC = (char)(c + i);
                if (changedC > 'z') {
                    changedC -= 26;
                }
                sb.append(changedC);
            }
            switch (sb.toString()) {
                case "northlondo" :
                    System.out.println("NLCS");
                    return;
                case "branksomeh" :
                    System.out.println("BHA");
                    return;
                case "koreainter" :
                    System.out.println("KIS");
                    return;
                case "stjohnsbur" :
                    System.out.println("SJA");
                    return;
            }
        }

    }

}
