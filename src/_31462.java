import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _31462 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] triangles = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        for (int r=0; r<N; r++) {
            String str = br.readLine();
            for (int c=0; c<=r; c++) {
                triangles[r][c] = str.charAt(c);
            }
        }

        // R
        for (int r=0; r<N-1; r++) {
            for (int c=0; c<=r; c++) {
                if (triangles[r][c] == 'R' && !visited[r][c]) {
                    if (triangles[r+1][c] == 'R' && !visited[r+1][c] && triangles[r+1][c+1] == 'R' && !visited[r+1][c+1]) {
                        visited[r][c] = visited[r+1][c] = visited[r+1][c+1] = true;
                    }
                }
            }
        }

        // B
        for (int r=0; r<N-1; r++) {
            for (int c=0; c<=r; c++) {
                if (triangles[r][c] == 'B' && !visited[r][c]) {
                    if (triangles[r][c+1] == 'B' && !visited[r][c+1] && triangles[r+1][c+1] == 'B' && !visited[r+1][c+1]) {
                        visited[r][c] = visited[r][c+1] = visited[r+1][c+1] = true;
                    }
                }
            }
        }

//        for (int r=0; r<N; r++) {
//            for (int c=0; c<=r; c++) {
//                System.out.print(visited[r][c] ? 1 : 0);
//            }
//            System.out.println();
//        }

        for (int r=0; r<N; r++) {
            for (int c=0; c<=r; c++) {
                if (!visited[r][c]) {
                    System.out.println(0);
                    return;
                }
            }
        }
        System.out.println(1);

    }

}
