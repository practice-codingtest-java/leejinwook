import java.io.*;
import java.util.*;

class Locate{
    int x, y, val;

    public Locate(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}
public class Main {
    static int r, c;
    static char[][] arr;
    static boolean[][] visited, fireVisited;
    static ArrayList<Locate> fire;
    static String answer = "";
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public void BFS(Locate jihoon){
        Queue<Locate> queue = new ArrayDeque<>();
        Queue<Locate> fireLocate = new ArrayDeque<>();
        queue.offer(jihoon);
        visited[jihoon.y][jihoon.x] = true;
        for (Locate f : fire) {
            fireLocate.offer(f);
            fireVisited[f.y][f.x] = true;
        }
        while (!queue.isEmpty()){
            int fireSize = fireLocate.size();
            for(int i=0;i<fireSize;i++){
                Locate cur = fireLocate.poll();
                for(int j=0;j<4;j++){
                    int nx = cur.x + dx[j], ny = cur.y + dy[j];
                    if(nx >= 0 && nx < c && ny >= 0 && ny < r && !fireVisited[ny][nx] && arr[ny][nx] != '#'){
                        fireVisited[ny][nx] = true;
                        fireLocate.offer(new Locate(nx, ny, 0));
                    }
                }
            }

            int len = queue.size();
            for(int i=0;i<len;i++){
                Locate cur = queue.poll();
                if(cur.x == 0 || cur.x == c-1 || cur.y == 0 || cur.y == r-1) {
                    answer = String.valueOf(cur.val + 1);
                    return;
                }
                for(int j=0;j<4;j++){
                    int nx = cur.x + dx[j], ny = cur.y + dy[j];
                    if(nx >= 0 && nx < c && ny >= 0 && ny < r && !visited[ny][nx] && !fireVisited[ny][nx] && arr[ny][nx] == '.'){
                        visited[ny][nx] = true;
                        queue.offer(new Locate(nx, ny, cur.val + 1));
                    }
                }
            }
        }
        answer = "IMPOSSIBLE";
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];
        fire = new ArrayList<>();
        Locate jihoon = null;
        visited = new boolean[r][c];
        fireVisited = new boolean[r][c];

        for(int i=0;i<r;i++){
            String line = br.readLine();
            for(int j=0;j<c;j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'F'){
                    fire.add(new Locate(j, i, 0));
                }
                if(arr[i][j] == 'J'){
                    jihoon = new Locate(j, i, 0);
                }
            }
        }
        T.BFS(jihoon);
        bw.write(answer);
        bw.flush();
        bw.close();
    }
}