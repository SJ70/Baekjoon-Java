import java.io.*;
import java.util.*;

public class _1461 {
    static int BookCnt, CarryCnt, MaxDistance;
    static PriorityQueue<Integer> BookLeft, BookRight;

    public static void main(String[] args) throws IOException{
        input();
        int result = getMinWalk(BookLeft) + getMinWalk(BookRight) - MaxDistance;
        System.out.println(result);
    }
    public static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BookCnt = Integer.parseInt(st.nextToken());
        CarryCnt = Integer.parseInt(st.nextToken());

        BookLeft = new PriorityQueue<>(Collections.reverseOrder());
        BookRight = new PriorityQueue<>(Collections.reverseOrder());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<BookCnt; i++){
            int book = Integer.parseInt(st.nextToken());
            int book_abs = Math.abs(book);
            ( (book>0) ? BookRight : BookLeft ).add( book_abs );
            MaxDistance = Math.max(MaxDistance, book_abs );
        }
    }
    public static int getMinWalk(PriorityQueue<Integer> Book){
        int result = 0;

        while(!Book.isEmpty()){
            int dist = Book.poll();
            for(int carry=1; carry<CarryCnt && !Book.isEmpty(); carry++){
                Book.poll();
            }
            result += dist * 2;
        }
        return result;
    }
}
