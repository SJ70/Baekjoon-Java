import java.util.Scanner;

public class _13717 {
    static Scanner sc = new Scanner(System.in);
    static int ev_all = 0;
    static int ev_max = -1;
    static String ev_max_pkm = "";
    public static void main(String[] args){
        int N = sc.nextInt();
        for(int i=0; i<N; i++)
            Evolution(sc.next(),sc.nextInt(),sc.nextInt());
        System.out.println(ev_all);
        System.out.println(ev_max_pkm);
    }
    public static void Evolution(String pkm, int require, int candy){
        int ev = 0;
        while(candy>=require){
            int n = candy/require;
            candy = candy - require*n + n*2;
            ev += n;
        }
        ev_all += ev;
        if(ev>ev_max){
            ev_max = ev;
            ev_max_pkm = pkm;
        }
    }
}
