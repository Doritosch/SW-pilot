package procedure02;

public class RoadToBiodome10 {
    private static int[][] plants;
    private static boolean[] visited;
    public static void main(String[] args) {
        if (args == null || args.length == 0 || args[0].trim().isEmpty()) {
            System.out.println("입력값이 없습니다. 다시 입력해주세요.");
            return;
        }

        plants = new int[101][101];
        visited = new boolean[101];
        for(int i=0; i<args.length; i++) {
            String[] split = args[i].split(",");
            if (split.length != 2) {
                System.out.println("입력 값에 문자가 포함되어 있습니다. 다시 입력해주세요.");
                return;
            }
            int p1;
            int p2;
            try {
                p1 = Integer.parseInt(split[0]);
                p2 = Integer.parseInt(split[1]);
            } catch (NumberFormatException e) {
                System.out.println("입력 값에 문자가 포함되어 있습니다. 다시 입력해주세요.");
                return;
            }
            if (p1 < 1 || p1 > 100 || p2 < 1 || p2 > 100) {
                System.out.println("식물의 범위를 벗어난 숫자가 포함되어 있습니다. 다시 입력해주세요.");
                return;
            }
            plants[p1][p2] = 1;
            plants[p2][p1] = 1;
        }

        int group = 0;
        for(int i=1; i<101; i++) {
            for(int j=1; j<101; j++) {
                if (plants[i][j] == 1 && !visited[j]) {
                    visited[j] = true;
                    dfs(j);
                    group += 1;
                }
            }
        }
        System.out.println(group);
    }
    private static void dfs(int x) {
        for(int i=1; i<101; i++) {
            if (!visited[i] && plants[x][i] == 1) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}
