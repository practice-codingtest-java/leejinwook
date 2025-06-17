import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Bead{
    int redX, redY, blueX, blueY, val;

    public Bead(int redX, int redY, int blueX, int blueY, int val) {
        this.redX = redX;
        this.redY = redY;
        this.blueX = blueX;
        this.blueY = blueY;
        this.val = val;
    }
}
public class Main {
    static int n, m;
    static char[][] arr;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    public int BFS(Bead bead){
        Queue<Bead> queue = new LinkedList<>();
        queue.offer(bead);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                Bead cur = queue.poll();
                if(cur.val == 10) return -1;
                for(int j=0;j<4;j++){
                    int redNx = cur.redX, redNy = cur.redY, blueNx = cur.blueX, blueNy = cur.blueY;
                    boolean isBlueHole = false, isRedHole = false;
                    while (true){
                        int newRedX = redNx + dx[j];
                        int newRedY = redNy + dy[j];
                        if(arr[newRedY][newRedX] == '#'){
                            break;
                        }
                        if(arr[newRedY][newRedX] == 'O'){
                            isRedHole = true;
                            break;
                        }
                        redNx = newRedX;
                        redNy = newRedY;
                    }
                    while (true){
                        int newBlueX = blueNx + dx[j];
                        int newBlueY = blueNy + dy[j];
                        if(arr[newBlueY][newBlueX] == '#'){
                            break;
                        }
                        if(arr[newBlueY][newBlueX] == 'O'){
                            isBlueHole = true;
                            break;
                        }
                        blueNx = newBlueX;
                        blueNy = newBlueY;
                    }
                    if(isBlueHole) continue;
                    else if(isRedHole) return cur.val + 1;

                    if (cur.redX == redNx && cur.redY == redNy && cur.blueX == blueNx && cur.blueY == blueNy) {
                        continue;
                    }

                    if (redNx == blueNx && redNy == blueNy) {
                        // 구슬이 아랫쪽으로 움직인 경우
                        if (j == 0) {
                            if (cur.redX < cur.blueX) {
                                redNx--;
                            } else {
                                blueNx--;
                            }
                        } else if (j == 1) {
                            // 구슬이 윗쪽으로 움직인 경우
                            if (cur.redX < cur.blueX) {
                                blueNx++;
                            } else  {
                                redNx++;
                            }
                        } else if (j == 2) {
                            // 구슬이 오른쪽으로 움직인 경우
                            if (cur.redY < cur.blueY) {
                                redNy--;
                            } else {
                                blueNy--;
                            }
                        } else if (j == 3) {
                            // 구슬이 왼쪽으로 움직인 경우
                            if (cur.redY < cur.blueY) {
                                blueNy++;
                            } else {
                                redNy++;
                            }
                        }
                    }

                    queue.offer(new Bead(redNx, redNy, blueNx, blueNy, cur.val + 1));
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

        arr = new char[n][m];
        int redX = 0, redY = 0, blueX = 0, blueY = 0;
        for(int i=0;i<n;i++){
            String line = br.readLine();
            for(int j=0;j<m;j++){
                arr[i][j] = line.charAt(j);
                if(arr[i][j] == 'R') {
                    redX = j;
                    redY = i;
                }
                else if(arr[i][j] == 'B') {
                    blueX = j;
                    blueY = i;
                }
            }
        }
        Bead bead = new Bead(redX, redY, blueX, blueY, 0);

        int bfs = T.BFS(bead);
        bw.write(String.valueOf(bfs));
        bw.flush();
        bw.close();
    }
}