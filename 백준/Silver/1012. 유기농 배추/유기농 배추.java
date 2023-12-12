import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, n, k;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0}; //상 하 좌 우
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int a = 0; a < t; a++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken()); // 심어져 있는 배추의 개수

            map = new int[m][n];
            visited = new boolean[m][n];

            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            cnt = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {

                    if (!visited[i][j] && map[i][j] == 1) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || m <= nx || ny < 0 || n <= ny) continue;

            if (map[nx][ny] == 1 && !visited[nx][ny]) {
                dfs(nx, ny);
            }
        }
    }
}
