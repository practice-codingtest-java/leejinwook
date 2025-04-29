import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public int gcd(int a, int b){
        while (b != 0){
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
    public int[][] solution(int n, int m, int r, int[][] arr){
        int[][] answer = new int[n][m];
        int row = m, column = n;
        int lcm = row*2 + column*2 - 4;
        while (row > 0 && column > 0){
            int inner = row*2 + column*2 - 4;
            lcm = (lcm * inner) / gcd(lcm, inner);
            row -= 2;
            column -= 2;
        }
        r %= lcm;
        int fx = 0, fy = 0;
        while (fx < m && fy < n){
            int d = 0;
            int x = fx, y = fy;
            int nx = x, ny = y;
            int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
            for(int cnt=0;cnt<r;cnt++){
                nx = x + dx[d];
                ny = y + dy[d];
                if(nx < 0 || ny < 0 || nx >= m || ny >= n){
                    d = (d+1) % 4;
                    nx = x + dx[d];
                    ny = y + dy[d];
                }
                x = nx;
                y = ny;
            }
            answer[ny][nx] = arr[y][x];
            fx++;
            fy++;
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] answer = T.solution(n, m, r, arr);
        for (int[] ints : answer) {
            for (int anInt : ints) {
                bw.write(String.valueOf(anInt) + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}