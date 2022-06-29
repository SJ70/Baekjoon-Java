import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _13549 {
    static int end;
    static Integer[] Min_time = new Integer[200000];
    static Queue<Integer> Qp = new ArrayDeque<>();
    static Queue<Integer> Qt = new ArrayDeque<>();
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        end = sc.nextInt();
        Move(start,0);
        while(!Qp.isEmpty()){
            Move(Qp.poll(),Qt.poll());
        }
        System.out.println(Min_time[end]);
    }
    public static void Move(int pos, int time){
        if( pos<0 || pos>=200000 || (Min_time[pos]!=null&&Min_time[pos]<=time) ) return;
        Min_time[pos] = time;
        if(pos==end) return;
        Qp.add(pos-1);
        Qt.add(time+1);
        Qp.add(pos+1);
        Qt.add(time+1);
        Move(pos*2,time);
    }
}
