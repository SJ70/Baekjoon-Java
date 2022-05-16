import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class _16434 {
    public static void main(String[] args) throws IOException {
        Input();
        System.out.println(BS(new BigInteger("0"),new BigInteger("250000000000000000")));
    }
    static int N;
    static BigInteger ATK_origin;
    static Room[] Rooms;
    static class Room{
        int t;
        BigInteger a,h;
        public Room(int t, BigInteger a, BigInteger h){
            this.t=t; this.a=a; this.h=h;
        }
    }
    public static void Input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Rooms = new Room[N];
        ATK_origin = new BigInteger(st.nextToken());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            Rooms[i] = new Room(Integer.parseInt(st.nextToken()),new BigInteger(st.nextToken()),new BigInteger(st.nextToken()));
        }
    }
    public static BigInteger GotoDungeon(BigInteger MaxHP){
        BigInteger CurHP = MaxHP;
        BigInteger ATK = ATK_origin;
        for(int i=0; i<N; i++){
            if(Rooms[i].t==1){ // t=1:fight
                // 영웅이 몬스터에게 맞는 횟수 (영웅이 몬스터를 죽이는데 걸리는 턴 수 -1)
                BigInteger time;
                // 공격력이 몬스터체력보다 높은 경우 안 맞음
                if(ATK.compareTo(Rooms[i].h) >= 0)
                    time = new BigInteger("0");
                else if(Rooms[i].h.remainder(ATK).compareTo(new BigInteger("0"))==0 )
                    time = Rooms[i].h.divide(ATK).subtract(new BigInteger("1"));
                else
                    time = Rooms[i].h.divide(ATK);
                CurHP = CurHP.subtract(time.multiply(Rooms[i].a));
                if(CurHP.compareTo(new BigInteger("1")) < 0) return new BigInteger("-1");
            }
            else{ // t=2:heal
                ATK = ATK.add(Rooms[i].a);
                CurHP = CurHP.add(Rooms[i].h);
                if(CurHP.compareTo(MaxHP) > 0) CurHP = MaxHP;
            }
        }
        return CurHP;
    }
    public static BigInteger BS(BigInteger left, BigInteger right){
        BigInteger mid = left.add(right);
        mid = mid.divide(new BigInteger("2"));
        BigInteger result = GotoDungeon(mid);
        //System.out.println(left+"~"+mid+"~"+right+" : "+result);
        if(result.equals(new BigInteger("1"))) // 남는 체력이 1일 경우
            return mid;
        else if(left.equals(right)) // 범위가 좁혀진 경우
            return mid;
        else if(result.compareTo(new BigInteger("1"))<0)
            return BS(mid.add(new BigInteger("1")),right);
        else
            return BS(left,mid);
    }
}
