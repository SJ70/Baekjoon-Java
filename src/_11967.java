import java.io.*;
import java.util.*;

public class _11967 {

    static int lightedRoomCnt = 0;

    private static class Room{
        ArrayList<LightSwitch> lightSwitches = new ArrayList<>();
        boolean isLighted = false;
        boolean visited = false;

        public void addSwitch(int r, int c){
            this.lightSwitches.add(new LightSwitch(r,c));
        }
        public void visit(){
            this.visited = true;
        }
        public void lightOnSelf(){
            this.isLighted = true;
        }
        public void lightOnAll(){
            for(LightSwitch lightSwitch : lightSwitches){
                Room room = Rooms[lightSwitch.r][lightSwitch.c];
                if(!room.isLighted()){
                    room.lightOnSelf();
                    lightedRoomCnt++;
                }
            }
        }
        public boolean isLighted(){
            return this.isLighted;
        }
        public boolean isVisited(){
            return this.visited;
        }
    }

    private static class LightSwitch{
        int r, c;
        public LightSwitch(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static Room[][] Rooms;
    static int N;
    public static void main(String[] args) throws IOException {
        init();

        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,1,-1};

        Queue<int[]> canGoNow = new ArrayDeque<>();
        Queue<int[]> canGoLater = new ArrayDeque<>();
        canGoNow.add(new int[]{0,0});
        Rooms[0][0].visit();
        Rooms[0][0].lightOnSelf();
        lightedRoomCnt++;

        while(!canGoNow.isEmpty()) {
            while(!canGoNow.isEmpty()) {
                int[] pos = canGoNow.poll();
                int r = pos[0];
                int c = pos[1];

//                System.out.printf("%d %d \n",r,c);

                Rooms[r][c].lightOnAll();

                for(int d=0; d<4; d++){
                    int nextR = r+dr[d];
                    int nextC = c+dc[d];
                    if(nextR>=0 && nextR<N && nextC>=0 && nextC<N && !Rooms[nextR][nextC].isVisited()){
                        Rooms[nextR][nextC].visit();
                        if(Rooms[nextR][nextC].isLighted()){
                            canGoNow.add(new int[]{nextR, nextC});
                        }
                        else{
                            canGoLater.add(new int[]{nextR, nextC});
                        }
                    }
                }
            }
            int repeat = canGoLater.size();
            for(int i=0; i<repeat; i++){
                int[] pos = canGoLater.poll();
                int r = pos[0];
                int c = pos[1];
                if(Rooms[r][c].isLighted()){
                    canGoNow.add(pos);
                }
                else{
                    canGoLater.add(pos);
                }
            }
        }

        System.out.println(lightedRoomCnt);
    }

    private static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Rooms = new Room[N][N];
        for(int r=0; r<N; r++){
            for(int c=0; c<N; c++){
                Rooms[r][c] = new Room();
            }
        }

        int LS = Integer.parseInt(st.nextToken());
        for(int i=0; i<LS; i++){
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken()) -1;
            int c1 = Integer.parseInt(st.nextToken()) -1;
            int r2 = Integer.parseInt(st.nextToken()) -1;
            int c2 = Integer.parseInt(st.nextToken()) -1;
            Rooms[r1][c1].addSwitch(r2, c2);
        }
    }
}
