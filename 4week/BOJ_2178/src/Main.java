import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x, y, dist;

    public Point(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}
public class Main {
    static int n, m, answer = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[][] arr, graph;
    public void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        graph[y][x] = 1;
        queue.offer(new Point(x, y, 1));
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            int curX = cur.x;
            int curY = cur.y;
            if(curX == m && curY == n) {
                answer = Math.min(answer, cur.dist);
                return;
            }
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 1 && nx <= m && ny >= 1 && ny <= n && arr[ny][nx] == 1 && graph[ny][nx] == 0){
                    graph[ny][nx] = 1;
                    queue.offer(new Point(nx, ny, cur.dist + 1));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1][m+1];
        graph = new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            String line = br.readLine();
            for(int j=1;j<=m;j++){
                arr[i][j] = line.charAt(j-1) - '0';
            }
        }

        T.BFS(1, 1);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}