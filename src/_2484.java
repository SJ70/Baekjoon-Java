import java.io.*;
import java.util.*;

public class _2484 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max_result = Integer.MIN_VALUE;
        int N = Integer.parseInt(br.readLine());
        for(int n=0; n<N; n++){

            StringTokenizer st = new StringTokenizer(br.readLine());
            HashMap<Integer, Integer> hs = new HashMap<>();
            for(int i=0; i<4; i++){
                int value = Integer.parseInt(st.nextToken());
                hs.put(value, hs.getOrDefault(value,0)+1);
            }

            int result = 0;
            switch(hs.size()){
                case 1 :
                    for(Map.Entry<Integer, Integer> e : hs.entrySet()){
                        result = e.getKey()*5000 + 50000;
                    }
                    break;
                case 2 :
                    for(Map.Entry<Integer, Integer> e : hs.entrySet()){
                        if(e.getValue()==3){
                            result = e.getKey()*1000 + 10000;
                            break;
                        }
                        if(e.getValue()==2){
                            result += e.getKey()*500 + 1000;
                        }
                    }
                    break;
                case 3 :
                    for(Map.Entry<Integer, Integer> e : hs.entrySet()){
                        if(e.getValue()==2){
                            result = e.getKey()*100 + 1000;
                            break;
                        }
                    }
                    break;
                case 4 :
                    int max = -1;
                    for(Map.Entry<Integer, Integer> e : hs.entrySet()){
                        max = Math.max(e.getKey(), max);
                    }
                    result = max*100;
                    break;
            }
//            System.out.println(result);
            max_result = Math.max(max_result, result);
        }
        System.out.println(max_result);
    }
}
