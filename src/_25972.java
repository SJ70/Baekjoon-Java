import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _25972 {
    static int N;
    public static class Domino implements Comparable<Domino>{
        int pos, length;

        public Domino(int pos, int length){
            this.pos = pos;
            this.length = length;
        }
        @Override
        public int compareTo(Domino d) {
            return Integer.compare(this.pos, d.pos);
        }
        public boolean isReachableFrom(Domino d) {
            return (d.pos + d.length >= this.pos);
        }
    }
    static ArrayList<Domino> Dominoes = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        init();
        int cnt = 1;
        for(int i=1; i<N; i++){
            if(Dominoes.get(i).isReachableFrom(Dominoes.get(i-1)));
            else cnt++;
        }
        System.out.println(cnt);
    }
    public static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            Dominoes.add(new Domino(pos,length));
        }
        Collections.sort(Dominoes);
    }
}
