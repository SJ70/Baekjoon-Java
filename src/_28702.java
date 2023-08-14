import java.io.*;

public class _28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 0;
        int numIndex = 0;
        for(int i=0; i<3; i++){
            String str = br.readLine();
            char start = str.charAt(0);
            if(start != 'F' && start != 'B'){
                num = Integer.parseInt(str);
                numIndex = i;
                break;
            }
        }

        int nextNumber = num + 3 - numIndex;
        String result = nextNumber%15==0 ? "FizzBuzz" : nextNumber%3==0 ? "Fizz" : nextNumber%5==0 ? "Buzz" : String.valueOf(nextNumber);

        System.out.print(result);
    }
}
