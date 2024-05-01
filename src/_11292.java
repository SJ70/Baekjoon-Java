import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class _11292 {

    private static class Student {
        String name;
        double height;

        public Student(String name, double height) {
            this.name = name;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            List<Student> students = new ArrayList<>();
            for (int i=0; i<N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                double height = Double.parseDouble(st.nextToken());
                students.add(new Student(name, height));
            }

            double tallestValue = students.stream().map(s -> s.height).max(Double::compareTo).get();
            String tallestStudents = students.stream().filter(s -> s.height == tallestValue).map(s -> s.name).collect(Collectors.joining(" "));
            sb.append(tallestStudents).append('\n');
        }

        System.out.print(sb);

    }

}
