import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _30701 {

    private static int ROOM_COUNT;
    private static long atk;
    private static PriorityQueue<Long> monsters = new PriorityQueue<>();
    private static PriorityQueue<Long> weapons = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        explore();
        System.out.println(getResult());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        ROOM_COUNT = Integer.parseInt(st.nextToken());
        atk = Long.parseLong(st.nextToken());

        for (int i=0; i<ROOM_COUNT; i++) {
            st = new StringTokenizer(br.readLine());
            int roomType = Integer.parseInt(st.nextToken());
            long value = Long.parseLong(st.nextToken());

            PriorityQueue<Long> queue = roomType == 1 ? monsters : weapons;
            queue.add(value);
        }
    }

    private static void explore() {
        while (!monsters.isEmpty() || !weapons.isEmpty()) {
            while (!monsters.isEmpty()) {
                long value = monsters.peek();
                if (atk <= value) {
                    break;
                }
                atk += value;
                monsters.poll();
            }
            if (!weapons.isEmpty()) {
                atk *= weapons.poll();
            }

            if (monsters.isEmpty()) {
                weapons.clear();
                return;
            }

            if (weapons.isEmpty() && atk <= monsters.peek()) {
                return;
            }
        }
    }

    private static int getResult() {
        return ROOM_COUNT - monsters.size() - weapons.size();
    }

}
