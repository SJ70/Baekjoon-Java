import java.util.*;

public class _1269 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();
        st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<N; i++){
            set.add(Integer.parseInt(st.nextToken()));
        }

        int result = N+M;
        st = new StringTokenizer(sc.nextLine());
        for(int i=0; i<M; i++){
            if(set.contains(Integer.parseInt(st.nextToken()))){
                result-=2;
            }
        }

        System.out.println(result);
    }
}
