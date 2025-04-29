import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int[] dx = {1, 2, -1, -2, 2, 1, -1, -2}, dy = {-2, -1, 2, 1, 1, 2, -2, -1};
    public int BFS(int l, int[][] ch, int[] start, int[] end){
        Queue<Point> queue = new LinkedList<>();
        int count = 0;
        int x = start[0], y = start[1];
        queue.offer(new Point(x, y));
        ch[x][y] = 1;
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Point cur = queue.poll();
                if(cur.x == end[0] && cur.y == end[1]) return count;
                for(int j=0;j<8;j++){
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    if(nx >= 0 && nx < l && ny >= 0 && ny < l && ch[nx][ny] == 0){
                        ch[nx][ny] = 1;
                        queue.offer(new Point(nx, ny));
                    }
                }
            }
            count++;
        }
        return count;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int l = Integer.parseInt(br.readLine());
            int[][] ch = new int[l][l];
            int[] start = new int[2], end = new int[2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            start[0] = Integer.parseInt(st.nextToken());
            start[1] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            end[0] = Integer.parseInt(st.nextToken());
            end[1] = Integer.parseInt(st.nextToken());
            int answer = T.BFS(l, ch, start, end);
            bw.write(String.valueOf(answer) + "\n");
        }
        bw.flush();
        bw.close();
    }
}