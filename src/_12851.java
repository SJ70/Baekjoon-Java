import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class _12851 {
    static int end;
    static Integer[] Min_time = new Integer[200000];
    static Queue<Integer> Qp = new ArrayDeque<>();
    static Queue<Integer> Qt = new ArrayDeque<>();
    static int Case=0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        end = sc.nextInt();
        Move(start,0);
        while(!Qp.isEmpty()){
            Move(Qp.poll(),Qt.poll());
        }
        System.out.println(Min_time[end]);
        System.out.println(Case);
    }
    public static void Move(int pos, int time){
        if( pos<0 || pos>=200000 || (Min_time[pos]!=null&&Min_time[pos]<time) ) return;
        Min_time[pos] = time;
        if(pos==end){
            Case++;
            return;
        }
        Qp.add(pos-1);
        Qt.add(time+1);
        Qp.add(pos+1);
        Qt.add(time+1);
        Qp.add(pos*2);
        Qt.add(time+1);
    }
}
