import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class _2141 {

    private static class Town implements Comparable<Town>{
        private final int position;
        private final long peopleCount;

        public Town(int position, int peopleCount) {
            this.position = position;
            this.peopleCount = peopleCount;
        }

        public int compareTo(Town town) {
            return this.position - town.getPosition();
        }

        public int getPosition() {
            return this.position;
        }

        public long getPeopleCount() {
            return this.peopleCount;
        }
    }

    private static int townCount;
    private static List<Town> towns = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        Collections.sort(towns);

        int leftTownPosition = -1000000000;
        int rightTownPosition = -1000000000;
        long leftPeopleCount = 0;
        long rightPeopleCount = towns.stream()
                .map(Town::getPeopleCount)
                .reduce(0L, Long::sum);

        long minPeopleCountDiff = Long.MAX_VALUE;
        int resultLeftTownPosition = leftTownPosition;
        int resultRightTownPosition = rightTownPosition;
        long resultLeftPeopleCount = 0L;
        long resultRightPeopleCount = 0L;

        for (int i=0; i<townCount-1; i++) {
            Town town = towns.get(i);
            Town nextTown = towns.get(i+1);

            leftTownPosition = town.getPosition();
            rightTownPosition = nextTown.getPosition();
//            System.out.println(" : " + leftTownPosition +","+ rightTownPosition);

            long peopleCount = town.getPeopleCount();
            leftPeopleCount += peopleCount;
            rightPeopleCount -= peopleCount;

            long peopleCountDiff = Math.abs(rightPeopleCount - leftPeopleCount);

            if (minPeopleCountDiff > peopleCountDiff) {
                minPeopleCountDiff = peopleCountDiff;
                resultLeftTownPosition = leftTownPosition;
                resultRightTownPosition = rightTownPosition;
                resultLeftPeopleCount = leftPeopleCount;
                resultRightPeopleCount = rightPeopleCount;
//                System.out.println(" :: " + resultLeftTownPosition +","+ resultRightTownPosition +" : "+peopleCountDiff);
            }
            else {
                break;
            }
        }

//        System.out.printf(leftPeopleCount + "," + rightPeopleCount);
        if (resultLeftPeopleCount >= resultRightPeopleCount) {
            System.out.println(resultLeftTownPosition);
        }
        else {
            System.out.println(resultRightTownPosition);
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        townCount = Integer.parseInt(br.readLine());
        for (int i=0; i<townCount; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int townPosition = Integer.parseInt(st.nextToken());
            int peopleCount = Integer.parseInt(st.nextToken());
            Town town = new Town(townPosition, peopleCount);
            towns.add(town);
        }
    }
}
