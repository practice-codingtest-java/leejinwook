import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x, y, val, brokenWall;
    boolean afternoon;

    public Point(int x, int y, int val, int brokenWall, boolean afternoon) {
        this.x = x;
        this.y = y;
        this.val = val;
        this.brokenWall = brokenWall;
        this.afternoon = afternoon;
    }
}
public class Main {
    static int n, m, k;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][][] visited;
    public int BFS(){
        Queue<Point> queue = new LinkedList<>();
        visited[0][0][0] = true;
        queue.offer(new Point(0, 0, 1, 0, true));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.x == m-1 && cur.y == n-1) return cur.val;
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d], ny = cur.y + dy[d];
                boolean nextDay = !cur.afternoon;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    if (arr[ny][nx] == 0 && !visited[ny][nx][cur.brokenWall]) {
                        visited[ny][nx][cur.brokenWall] = true;
                        queue.offer(new Point(nx, ny, cur.val + 1, cur.brokenWall, nextDay));
                    }
                    if (arr[ny][nx] == 1) {
                        if(cur.brokenWall+1 <= k && !visited[ny][nx][cur.brokenWall+1]){
                            if(cur.afternoon){
                                visited[ny][nx][cur.brokenWall+1] = true;
                                queue.offer(new Point(nx, ny, cur.val+1, cur.brokenWall+1, nextDay));
                            }
                            else{
                                queue.offer(new Point(cur.x, cur.y, cur.val+1, cur.brokenWall, nextDay));
                            }
                        }
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visited = new boolean[n][m][k+1];

        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j] = line.charAt(j) - '0';
            }
        }
        int answer = T.BFS();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}