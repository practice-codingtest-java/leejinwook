import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Locate{
    int x, y, count;

    public Locate(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}
public class Main {
    static int n, m;
    static char[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int answer = 0;
    public void BFS(Locate doyeon){
        Queue<Locate> queue = new ArrayDeque<>();
        visited[doyeon.y][doyeon.x] = true;
        queue.offer(doyeon);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Locate cur = queue.poll();
                answer = Math.max(answer, cur.count);
                for(int j=0;j<4;j++){
                    int nx = cur.x + dx[j], ny = cur.y + dy[j];
                    if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[ny][nx] && arr[ny][nx] != 'X'){
                        visited[ny][nx] = true;
                        if(arr[ny][nx] == 'O') queue.offer(new Locate(nx, ny, cur.count));
                        else if(arr[ny][nx] == 'P') queue.offer(new Locate(nx, ny, cur.count + 1));
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

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];
        visited = new boolean[n][m];
        Locate doyeon = null;
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'I'){
                    doyeon = new Locate(j, i, 0);
                }
            }
        }
        T.BFS(doyeon);
        if(answer == 0) bw.write("TT");
        else bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}