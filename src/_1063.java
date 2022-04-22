import java.io.*;
import java.util.*;

public class _1063 {
    static Pos stone = new Pos();
    static Pos king = new Pos();
    static Pos dir = new Pos();
    static class Pos{
        int x,y;
        public void ReadPos(String str){
            // char -> int
            this.x = str.charAt(0) - 65;
            this.y = str.charAt(1) - 49;
        }
        public void WritePos(){
            char x = (char)(this.x+65);
            char y = (char)(this.y+49);
            System.out.println(x+""+y);
        }
        public void Go(){
            this.x += dir.x;
            this.y += dir.y;
        }
        public boolean isIn(){
            // 토큰이 맵 밖으로 나가지 않는가?
            int destX = this.x + dir.x;
            int destY = this.y + dir.y;
            return destX<=7 && destX>=0 && destY<=7 && destY>=0;
        }
        public boolean isCrashing(){
            // 킹이 가려는 곳에 돌이 있는가?
            return king.x + dir.x == stone.x && king.y + dir.y == stone.y;
        }
        public void ReadDir(String str){
            this.x = this.y = 0;
            if(str.contains("R")) this.x++;
            else if(str.contains("L")) this.x--;
            if(str.contains("T")) this.y++;
            else if(str.contains("B")) this.y--;
        }
    }
    public static void main(String[] args) throws IOException{
        // (0~7,0~7) 형태로 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String tmp = st.nextToken();
        king.ReadPos(tmp);
        tmp = st.nextToken();
        stone.ReadPos(tmp);
        // 반복문
        int N = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++){
            dir.ReadDir(br.readLine());
            if(king.isIn()){
                if(king.isCrashing()){
                    if(stone.isIn()){
                        stone.Go();
                        king.Go();
                    }
                }
                else king.Go();
            }
            //king.WritePos();
            //stone.WritePos();
        }
        king.WritePos();
        stone.WritePos();
    }
}
