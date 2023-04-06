import java.io.*;
import java.util.*;

public class _25325 {

    static HashMap<String, Integer> popularity = new HashMap<>();

    public static class Student implements Comparable<Student> {
        String name;
        int popularity;
        public Student(String name, int popularity){
            this.name = name;
            this.popularity = popularity;
        }
        public String getName(){
            return this.name;
        }
        public int getPopularity(){
            return this.popularity;
        }
        public int compareTo(Student o){
            if(o.getPopularity() != this.popularity){
                return o.getPopularity() - this.popularity;
            }
            return this.name.compareTo(o.getName());
        }
    }

    public static void main(String[] args) throws IOException{
        input();

        PriorityQueue<Student> pq = new PriorityQueue<>();
        for(Map.Entry<String, Integer> e : popularity.entrySet()){
            pq.add(new Student(e.getKey(), e.getValue()));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.peek().getName()).append(' ').append(pq.poll().getPopularity()).append('\n');
        }
        System.out.print(sb);
    }

    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            popularity.put(st.nextToken(),0);
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                String name = st.nextToken();
                popularity.put(name, popularity.get(name)+1);
            }
        }
    }
}
