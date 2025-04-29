import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, count = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, -1, 0, 1};
    static int[][] arr, ch;
    static ArrayList<Integer> answer = new ArrayList<>();
    public int BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        ch[y][x] = count;
        int cnt = 1;
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx >= 0 && nx < n && ny >= 0 && ny < n && ch[ny][nx] == 0){
                    ch[ny][nx] = count;
                    cnt++;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        ch = new int[n][n];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<n;j++){
                arr[i][j] = line.charAt(j) - '0';
                if(arr[i][j] == 0) ch[i][j] = -1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(arr[i][j] == 1 && ch[i][j] == 0){
                    count++;
                    answer.add(T.BFS(j, i));
                }
            }
        }
        Collections.sort(answer);
        bw.write(count + "\n");
        for (Integer i : answer) {
            bw.write(i + "\n");
        }
        bw.flush();
        bw.close();
    }
}