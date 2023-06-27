import java.io.*;
import java.util.*;

public class _2115 {
    public static void main(String[] args) throws IOException{
        init();
        fillPictures();
        System.out.println(PictureCnt);
    }

    static final int UP = 0;
    static final int LEFT = 1;

    private static class Space{
        boolean[] isFilled = new boolean[2];
        boolean isWall;

        public Space(boolean space){
            this.isWall = !space;
        }
        public void fill(int dir){
            this.isFilled[dir]=true;
        }
        public boolean isEmpty(int dir){
            return !this.isFilled[dir];
        }
        public boolean isWall(){
            return this.isWall;
        }
    }

    static int R, C, PictureCnt;
    static Space[][] Gallery;

    static void init() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        Gallery = new Space[R][C];

        for(int r=0; r<R; r++){
            String str = br.readLine();
            for(int c=0; c<C; c++){
                Gallery[r][c] = new Space(str.charAt(c)=='.');
            }
        }
    }

    static void fillPictures(){
        for(int r=1; r<R; r++){
            for(int c=1; c<C; c++){
                if(canFillPictureLeft(r,c)){
                    fillPictureLeft(r,c);
                    PictureCnt++;
//                    System.out.printf("%d %d L \n",r,c);
                }
                if(canFillPictureUp(r,c)){
                    fillPictureUp(r,c);
                    PictureCnt++;
//                    System.out.printf("%d %d U \n",r,c);
                }
            }
        }
    }

    static boolean canFillPictureUp(int r, int c){
        if(r>=R || c+1>=C) return false;

        boolean isEmpty = Gallery[r][c].isEmpty(UP) && Gallery[r][c+1].isEmpty(UP);
        boolean isWall = (!Gallery[r][c].isWall() && !Gallery[r][c+1].isWall() && Gallery[r-1][c].isWall() && Gallery[r-1][c+1].isWall())
                || (!Gallery[r-1][c].isWall() && !Gallery[r-1][c+1].isWall() && Gallery[r][c].isWall() && Gallery[r][c+1].isWall());
        return isEmpty && isWall;
    }
    static boolean canFillPictureLeft(int r, int c){
        if(r+1>=R || c>=C) return false;

        boolean isEmpty = Gallery[r][c].isEmpty(LEFT) && Gallery[r+1][c].isEmpty(LEFT);
        boolean isWall = (!Gallery[r][c].isWall() && !Gallery[r+1][c].isWall() && Gallery[r][c-1].isWall() && Gallery[r+1][c-1].isWall())
                || (!Gallery[r][c-1].isWall() && !Gallery[r+1][c-1].isWall() && Gallery[r][c].isWall() && Gallery[r+1][c].isWall());
        return isEmpty && isWall;
    }

    static void fillPictureUp(int r, int c){
        Gallery[r][c].fill(UP);
        Gallery[r][c+1].fill(UP);
    }
    static void fillPictureLeft(int r, int c){
        Gallery[r][c].fill(LEFT);
        Gallery[r+1][c].fill(LEFT);
    }
}
