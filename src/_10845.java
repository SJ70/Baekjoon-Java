import java.util.*;
import java.io.*;
public class _10845 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        int tmp=-1;

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String fx = st.nextToken();
            switch(fx){
                case "push" :   // 값 추가
                    tmp = Integer.parseInt(st.nextToken());
                    q.add(tmp); // ( = q.offer )
                    break;
                case "pop" :    // 첫번째 값을 반환하고 제거, 비어있다면 null
                    if(q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.poll()+"\n");
                    bw.flush();
                    break;
                case "size" :   // 큐 사이즈
                    bw.write(q.size()+"\n");
                    bw.flush();
                    break;
                case "empty" :  // 비어있는지
                    if(q.isEmpty()) bw.write("1\n");
                    else bw.write("0\n");
                    bw.flush();
                    break;
                case "front" :  // 큐 첫번째 값
                    if(q.isEmpty()) bw.write("-1\n");
                    else bw.write(q.peek()+"\n");
                    bw.flush();
                    break;
                case "back" :   // 큐 마지막 값
                    if(q.isEmpty()) bw.write("-1\n");
                    else bw.write(tmp+"\n");
                    bw.flush();
                    break;
            }
        }
    }
}
