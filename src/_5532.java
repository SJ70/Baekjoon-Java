import java.io.*;

public class _5532 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Vacation = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int _A = A/a + ((A%a)>0?1:0);
        int _B = B/b + ((B%b)>0?1:0);
        System.out.println(Vacation - Math.max(_A,_B));
    }
}
