package procedure02;

import java.util.LinkedList;
import java.util.Queue;

public class RoadToBiodome09 {
    private static int[][] cave;
    private static int[][] distance;
    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        if (args == null || args[0].trim().isEmpty()) {
            System.out.println("입력값이 없습니다. 다시 확인하고 입력해주세요.");
            return;
        }

        int n = args.length;
        int m = args[0].length();

        cave = new int[n][m];
        distance = new int[n][m];
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                cave[i][j] = Character.getNumericValue(args[i].charAt(j));
            }
        }

        bfs(0,0);
        int answer = distance[n-1][m-1];
        System.out.println(answer);
    }
    private static void bfs(int x, int y) {
         Queue<int[]> q = new LinkedList<>();
         q.add(new int[]{x, y});

         while(!q.isEmpty()) {
             int[] cur = q.poll();

             for(int i=0; i<4; i++) {
                 int nx = cur[0] + dx[i];
                 int ny = cur[1] + dy[i];

                 if (isRange(nx, ny) && cave[nx][ny] == 1 && distance[nx][ny] == 0) {
                     distance[nx][ny] = distance[cur[0]][cur[1]] + 1;
                     q.add(new int[]{nx, ny});
                 }
             }
         }
    }
    private static boolean isRange(int x, int y) {
        if ((0 > x || 0 > y) || (cave.length <= x || cave[0].length <= y)) {
            return false;
        }
        return true;
    }
}
