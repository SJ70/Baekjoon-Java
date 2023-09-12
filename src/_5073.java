import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class _5073 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";

        while(!(input=br.readLine()).equals("0 0 0")){

            StringTokenizer st = new StringTokenizer(input);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Set<Integer> set = new HashSet<>();
            set.add(a);
            set.add(b);
            set.add(c);

            List<Integer> list = new ArrayList<>();
            list.add(a);
            list.add(b);
            list.add(c);
            Collections.sort(list);
            if(list.get(0) + list.get(1) <= list.get(2)){
                sb.append("Invalid\n");
                continue;
            }

            switch(set.size()){
                case 1 : sb.append("Equilateral\n"); break;
                case 2 : sb.append("Isosceles\n"); break;
                case 3 : sb.append("Scalene\n"); break;
            }
        }
        System.out.print(sb);
    }
}
