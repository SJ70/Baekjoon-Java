import java.io.*;
import java.util.*;

public class _2545 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            br.readLine();
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Long> lengths = new ArrayList<>();
            for(int i=0; i<3; i++){
                lengths.add(Long.parseLong(st.nextToken()));
            }
            Collections.sort(lengths);

            long D = Long.parseLong(st.nextToken());
            long[] MaxLengths = new long[3];
            long lengthSum = lengths.get(0) + lengths.get(1) + lengths.get(2) - D;
            MaxLengths[0] = lengthSum/3;
            MaxLengths[1] = lengthSum/3 + ((lengthSum%3>1)?1:0);
            MaxLengths[2] = lengthSum/3 + ((lengthSum%3>0)?1:0);
//            System.out.println(MaxLengths[0]+","+MaxLengths[1]+","+MaxLengths[2]);

            if(lengths.get(0) < MaxLengths[0]){
                long rest = MaxLengths[0] - lengths.get(0);
                MaxLengths[0] = lengths.get(0);
                if(MaxLengths[1]==MaxLengths[2]){
                    MaxLengths[1] += rest/2;
                    MaxLengths[2] += rest/2 + rest%2;
                }
                else{
                    MaxLengths[1] += rest/2 + rest%2;
                    MaxLengths[2] += rest/2;
                }
            }

            if(lengths.get(1) < MaxLengths[1]){
                long rest = MaxLengths[1] - lengths.get(1);
                MaxLengths[1] = lengths.get(1);
                MaxLengths[2] += rest;
            }
            sb.append(MaxLengths[0] * MaxLengths[1] * MaxLengths[2]).append('\n');
//            System.out.println(MaxLengths[0]+","+MaxLengths[1]+","+MaxLengths[2]);
//            System.out.println();
        }
        System.out.print(sb);
    }
}
