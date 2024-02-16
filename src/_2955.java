import java.io.BufferedReader;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class _2955 {

    private static final int NULL = 0;

    private static SudokuBox[] sudokuBoxes = new SudokuBox[9];

    private static boolean[][] usedNum_row = new boolean[9][10]; // 각 행에 i를 사용했는가
    private static boolean[][] usedNum_col = new boolean[9][10]; // 각 열에 i를 사용했는가
    private static boolean[][] usedNum_box = new boolean[9][10]; // 각 박스에 i를 사용했는가

    private static class SudokuBox {
        int boxIdx;
        List<SudokuElement> elements = new ArrayList<>();

        public SudokuBox(int i) {
            boxIdx = i;
        }

        public void add(SudokuElement e) {
            elements.add(e);
        }

        // 각 숫자마다 유일하게 채워지는 칸인지 확인 후 채운다
        public void cross_hatch() {
            for (int value = 1; value <= 9; value++) {
                if (usedNum_box[boxIdx][value]) {
                    continue;
                }
                for (SudokuElement e : elements) {
                    if (canFillOnly(e, value)) {
                        e.fill(value);
                    }
                }
            }
        }

        // 숫자를 채울 수 없는 모순 찾기
        public void checkCanFillNumbers() {
            for (int value = 1; value <= 9; value++) {
                boolean canFill = false;
                for (SudokuElement e : elements) {
                    if (e.value == value || e.canFill(value)) {
                        canFill = true;
                        break;
                    }
                }
                if (!canFill) {
                    throw new IllegalStateException("모순 : 해당 숫자를 절대 채울 수 없음");
                }
            }
        }

        private boolean canFillOnly(SudokuElement target, int value) {
            for (SudokuElement e : elements) {
                if (e == target) {
                    if (!e.canFill(value)) {
                        return false;
                    }
                }
                else if (e.canFill(value)) {
                    return false;
                }
            }
            return true;
        }

    }

    private static class SudokuElement {

        int r;
        int c;
        int boxIdx;
        int value;

        public SudokuElement(int r, int c) {
            init(r, c);
            value = NULL;
        }

        public SudokuElement(int r, int c, int value) {
            init(r, c);
            fill(value);
        }

        private void init(int r, int c) {
            this.r = r;
            this.c = c;
            this.boxIdx = calcBoxIndex(r, c);
        }

        public void fill(int value) {
            if (!canFill(value)) {
                throw new IllegalStateException("모순 : 잘못된 값을 채움");
            }
            this.value = value;
            usedNum_row[r][value] = usedNum_col[c][value] = usedNum_box[boxIdx][value] = true;
        }

        public boolean canFill(int value) {
            return this.value == NULL && !usedNum_row[r][value] && !usedNum_col[c][value] && !usedNum_box[boxIdx][value];
        }

    }

    public static void main(String[] args) throws IOException {
        try {

            input();
            for (int i=0; i<81; i++) {
                for (SudokuBox box : sudokuBoxes) {
                    box.cross_hatch();
                    box.checkCanFillNumbers();
                }
            }
//        logSudoku();
            printSudoku();

        }
        catch (IllegalStateException e) {
            System.out.println("ERROR");
        }

    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<9; i++) {
            sudokuBoxes[i] = new SudokuBox(i);
        }

        for (int r=0; r<9; r++) {
            String str = br.readLine();
            for (int c=0; c<9; c++) {
                char value = str.charAt(c);
                SudokuElement e = value == '.' ? new SudokuElement(r, c) : new SudokuElement(r, c, value - '0');
                sudokuBoxes[calcBoxIndex(r, c)].add(e);
            }
        }
    }

    private static int calcBoxIndex(int r, int c) {
        int box_r = r / 3;
        int box_c = c / 3;
        return box_r * 3 + box_c;
    }

    private static void printSudoku() {

        PriorityQueue<SudokuElement> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.r == e2.r) {
                return e1.c - e2.c;
            }
            return e1.r - e2.r;
        });

        for (SudokuBox box : sudokuBoxes) {
            for (SudokuElement e : box.elements) {
                pq.add(e);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int r=0; r<9; r++) {
            for (int c=0; c<9; c++) {
                int value = pq.poll().value;
                sb.append(value == NULL ? "." : value);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    // 로깅용 함수
//    private static void logSudoku() {
//        PriorityQueue<SudokuElement> pq = new PriorityQueue<>((e1, e2) -> {
//            if (e1.r == e2.r) {
//                return e1.c - e2.c;
//            }
//            return e1.r - e2.r;
//        });
//
//        for (SudokuBox box : sudokuBoxes) {
//            for (SudokuElement e : box.elements) {
//                pq.add(e);
//            }
//        }
//
//        System.out.println("-----row[i] 사용한 숫자-----");
//        for (int i=0; i<9; i++) {
//            System.out.printf("---%d---\n", i);
//            for (int j=1; j<=9; j++) {
//                if (usedNum_row[i][j]) {
//                    System.out.printf("%d ", j);
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.println("-----col[i] 사용한 숫자-----");
//        for (int i=0; i<9; i++) {
//            System.out.printf("---%d---\n", i);
//            for (int j=1; j<=9; j++) {
//                if (usedNum_col[i][j]) {
//                    System.out.printf("%d ", j);
//                }
//            }
//            System.out.println();
//        }
//
//        System.out.println("-----box[i] 사용한 숫자-----");
//        for (int i=0; i<9; i++) {
//            System.out.printf("---%d---\n", i);
//            for (int j=1; j<=9; j++) {
//                if (usedNum_box[i][j]) {
//                    System.out.printf("%d ", j);
//                }
//            }
//            System.out.println();
//        }
//
//        for (int r=0; r<9; r++) {
//            for (int c=0; c<9; c++) {
//                SudokuElement e = pq.poll();
//                System.out.printf("[%d] (%d,%d) : %d   |   ", e.boxIdx, r, c, e.value);
//            }
//            System.out.println();
//        }
//    }

}
