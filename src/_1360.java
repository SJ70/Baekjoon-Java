import java.io.*;
import java.util.*;

public class _1360 {
    private static class State{
        String str;
        long time;
        State(String str, long time){
            this.str = str;
            this.time = time;
        }
        String getStr(){
            return this.str;
        }
        long getTime(){
            return this.time;
        }
    }
    static ArrayList<State> States = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        States.add(new State("",0L));
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            switch(st.nextToken().charAt(0)){
                case't': type(st.nextToken().charAt(0), Long.parseLong(st.nextToken())); break;
                case'u': undo(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())); break;
            }
//            System.out.println(States.get(States.size()-1).getTime()+" : "+States.get(States.size()-1).getStr());
        }
        System.out.println(States.get(States.size()-1).getStr());
    }
    public static void type(char c, long time){
        State lastState = States.get(States.size()-1);
        String str = lastState.getStr() + c;
        States.add(new State(str,time));
    }
    public static void undo(long undoTime, long time){
        long targetTime = time - undoTime;
        for(int i=States.size()-1; i>=0; i--){
            if(States.get(i).getTime()<targetTime){
                States.add(new State(States.get(i).getStr(),time));
                return;
            }
        }
        // 되돌리는 시간 값이 클 때,
        States.add(new State("",time));
    }
}
