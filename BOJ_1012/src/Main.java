import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate{
    int x, y;

    public Locate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m, k;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public void BFS(int x, int y){
        Queue<Locate> queue = new ArrayDeque<>();
        queue.offer(new Locate(x, y));
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Locate cur = queue.poll();
                for(int j=0;j<4;j++){
                    int nx = cur.x + dx[j], ny = cur.y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && arr[ny][nx] == 1){
                        visited[ny][nx] = true;
                        arr[ny][nx] = 0;
                        queue.offer(new Locate(nx, ny));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            visited = new boolean[n][m];
            arr = new int[n][m];
            for(int j=0;j<k;j++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }
            for(int j=0;j<n;j++){
                for(int l=0;l<m;l++){
                    if(arr[j][l] == 1){
                        T.BFS(l, j);
                        count++;
                    }
                }
            }
            bw.write(String.valueOf(count) + "\n");
        }
        bw.flush();
        bw.close();
    }
}