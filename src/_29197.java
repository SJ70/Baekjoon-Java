import java.io.*;
import java.util.*;

public class _29197 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean up, right, down, left;
        up = right = down = left = false;
        HashSet<Double> angles1 = new HashSet<>();
        HashSet<Double> angles2 = new HashSet<>();
        HashSet<Double> angles3 = new HashSet<>();
        HashSet<Double> angles4 = new HashSet<>();

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(x==0){
                if(y>0) up = true;
                else down = true;
            }
            else if(y==0){
                if(x>0) right = true;
                else left = true;
            }
            else{
                double angle = (double)y/(double)x;
                if(x>0 && y>0) angles1.add(angle);
                else if(x<0 && y>0) angles2.add(angle);
                else if(x>0 && y<0) angles3.add(angle);
                else angles4.add(angle);
            }
        }

        int result = angles1.size() + angles2.size() + angles3.size() + angles4.size();
        result += up ? 1 : 0;
        result += right ? 1 : 0;
        result += down ? 1 : 0;
        result += left ? 1 : 0;

        System.out.println(result);
    }
}
