import java.util.*;

public class _16509 {
    static Integer[][] Map = new Integer[10][9];
    static int R1,C1,R2,C2;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R1 = sc.nextInt(); C1 = sc.nextInt();
        R2 = sc.nextInt(); C2 = sc.nextInt();
        QAdd(R1,C1,0);
        while(!Q.isEmpty()){
            Move(Q.poll(),Q.poll(),Q.poll());
        }
        if(!Found) System.out.println(-1);
    }
    static Queue<Integer> Q = new ArrayDeque<>();
    static boolean Found = false;
    public static void Move(int r, int c, int time){
        if( r==R2 && c==C2 ){
            System.out.println(time);
            Q.clear();
            Found=true;
            return;
        }
        if( r<0 || r>9 || c<0 || c>8 ) return;
        if( Map[r][c]!=null && time > Map[r][c] ) return;
        Map[r][c] = time;
        if(!isBlocked(r-1,c)){
            if(!isBlocked(r-2,c-1)){
                QAdd(r-3,c-2,time+1);
            }
            if(!isBlocked(r-2,c+1)){
                QAdd(r-3,c+2,time+1);
            }
        }
        if(!isBlocked(r+1,c)){
            if(!isBlocked(r+2,c-1)){
                QAdd(r+3,c-2,time+1);
            }
            if(!isBlocked(r+2,c+1)){
                QAdd(r+3,c+2,time+1);
            }
        }
        if(!isBlocked(r,c-1)){
            if(!isBlocked(r+1,c-2)){
                QAdd(r+2,c-3,time+1);
            }
            if(!isBlocked(r-1,c-2)){
                QAdd(r-2,c-3,time+1);
            }
        }
        if(!isBlocked(r,c+1)){
            if(!isBlocked(r+1,c+2)){
                QAdd(r+2,c+3,time+1);
            }
            if(!isBlocked(r-1,c+2)){
                QAdd(r-2,c+3,time+1);
            }
        }
    }
    public static void QAdd(int r, int c, int time){
        Q.add(r); Q.add(c); Q.add(time);
    }
    public static boolean isBlocked(int r, int c){
        return ( r>=0 && r<=9 && c>=0 && c<=8 && R2==r && C2==c );
    }
}