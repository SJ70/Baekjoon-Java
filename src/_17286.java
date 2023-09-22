import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _17286 {

    private static class Coordinate {
        private final double x;
        private final double y;

        public Coordinate(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getDistance(Coordinate anotherCoordinate) {
            double dx = Math.abs(x - anotherCoordinate.x);
            double dy = Math.abs(y - anotherCoordinate.y);
            return Math.sqrt(dx * dx + dy * dy);
        }
    }

    private static final int N = 4;
    private static final List<Coordinate> people = new ArrayList<>();
    private static final double[][] distance = new double[N][N];

    public static void main(String[] args) throws IOException {
        input();
        observeDistance();
        System.out.printf("%d",getResult());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i=0; i<N; i++) {
            Coordinate person = makeCoordinateFromString(br.readLine());
            people.add(person);
        }
    }

    private static Coordinate makeCoordinateFromString(String stringValue) {
        StringTokenizer st = new StringTokenizer(stringValue);
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        return new Coordinate(x, y);
    }

    private static void observeDistance() {
        for (int from=0; from<N; from++) {
            Coordinate personA = people.get(from);
            for (int to=from+1; to<N; to++) {
                Coordinate personB = people.get(to);
                double dist = personA.getDistance(personB);
                distance[from][to] = dist;
                distance[to][from] = dist;
            }
        }
    }

    private static int getResult() {
        PriorityQueue<Double> pq = new PriorityQueue<>();
        pq.add(getDistanceByRoute(1,2,3));
        pq.add(getDistanceByRoute(1,3,2));
        pq.add(getDistanceByRoute(2,1,3));
        pq.add(getDistanceByRoute(2,3,1));
        pq.add(getDistanceByRoute(3,1,2));
        pq.add(getDistanceByRoute(3,2,1));
        double min = pq.peek();
        return (int) min;
    }

    private static double getDistanceByRoute(int a, int b, int c) {
        return distance[0][a] + distance[a][b] + distance[b][c];
    }
}
