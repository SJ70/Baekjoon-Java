import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class _5635 {

    private static class Person implements Comparable<Person>{
        String name;
        BirthDay birthDay;

        public Person (String name, int day, int month, int year) {
            this.name = name;
            this.birthDay = new BirthDay(day, month, year);
        }

        public int compareTo(Person p) {
            return birthDay.compareTo(p.birthDay);
        }

        public String toString() {
            return String.format("%s : %s",name, birthDay);
        }
    }

    private static class BirthDay implements Comparable<BirthDay>{
        int day;
        int month;
        int year;

        public BirthDay (int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }

        public int compareTo(BirthDay b) {
            if (year != b.year) {
                return year - b.year;
            }
            if (month != b.month) {
                return month - b.month;
            }
            return day - b.day;
        }

        public String toString() {
            return String.format("%d.%d.%d", day, month, year);
        }
    }

    public static void main(String[] args) throws IOException {

        List<Person> people = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            people.add(new Person(name, day, month, year));
        }

        Collections.sort(people);
//        System.out.println(people);

        Person oldestPerson = people.get(0);
        Person youngestPerson = people.get(people.size() - 1);
        System.out.printf("%s\n%s\n",youngestPerson.name, oldestPerson.name);

    }

}
