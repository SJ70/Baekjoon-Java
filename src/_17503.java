import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17503 {

    private static int itemsCntToGet;
    private static int requiredValue;
    private static int itemsCnt;

    private static PriorityQueue<Item> items = new PriorityQueue<>((i1, i2) -> {
        if (i1.cost == i2.cost) {
            return - Long.compare(i1.value, i2.value);
        }
        return Long.compare(i1.cost, i2.cost);
    });

    private static PriorityQueue<Item> itemsGotten = new PriorityQueue<>((i1, i2) -> {
        if (i1.value == i2.value) {
            return - Long.compare(i1.cost, i2.cost);
        }
        return Long.compare(i1.value, i2.value);
    });

    private static class Item {
        long value;
        long cost;

        public Item (long value, long cost) {
            this.value = value;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        getItems();
        System.out.println(getResult());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        itemsCntToGet = Integer.parseInt(st.nextToken());
        requiredValue = Integer.parseInt(st.nextToken());
        itemsCnt = Integer.parseInt(st.nextToken());

        for (int i=0; i<itemsCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int value = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            items.add(new Item(value, cost));
        }
    }

    private static void getItems() {
        int entireValue = 0;
        while (!items.isEmpty()) {
            // 다음 아이템을 넣는다.
            Item item = items.poll();
            itemsGotten.add(item);
            entireValue += item.value;

            // 수량 초과 시 가장 낮은 가치의 아이템 하나를 버린다.
            if (itemsGotten.size() > itemsCntToGet) {
                entireValue -= itemsGotten.poll().value;
            }

            // 조건을 충족했다면 종료
            if (itemsGotten.size() == itemsCntToGet && entireValue >= requiredValue) {
                return;
            }
        }

        // 조건을 충족하지 못했다면 clear
        itemsGotten.clear();
    }

    private static long getResult() {
        if (itemsGotten.isEmpty()) {
            return -1;
        }

        long maxCost = 0;
        while (!itemsGotten.isEmpty()) {
            maxCost = Math.max(itemsGotten.poll().cost, maxCost);
        }
        return maxCost;
    }

}
