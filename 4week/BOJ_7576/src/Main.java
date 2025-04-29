import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point{
    int x,y, val;

    public Point(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

}
public class Main {
    static int n, m, answer = Integer.MIN_VALUE;
    static int[] dx = {0, -1, 0, 1}, dy = {1, 0, -1, 0};
    static int[][] arr, ch;
    public void BFS(){
        Queue<Point> queue = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j] == 1) {
                    ch[i][j] = 1;
                    queue.offer(new Point(j, i ,1));
                }
            }
        }
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int s=0;s<len;s++){
                Point cur = queue.poll();
                for(int i=0;i<4;i++){
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    int nv = cur.val + 1;
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[ny][nx] == 0){
                        if(ch[ny][nx] == 0) {
                            ch[ny][nx] = nv;
                            queue.offer(new Point(nx, ny, nv));
                        }
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][m];
        ch = new int[n][m];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        T.BFS();
        boolean flag = false;
        for(int i=0;i<n;i++){
            if(flag) break;
            for(int j=0;j<m;j++){
                if(ch[i][j] == 0 && arr[i][j] != -1) {
                    flag = true;
                    break;
                }
                answer = Math.max(ch[i][j] , answer);
            }
        }
        if(!flag) bw.write(String.valueOf(answer - 1));
        else bw.write("-1");
        bw.flush();
        bw.close();
    }
}