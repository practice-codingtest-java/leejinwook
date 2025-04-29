import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
public class Main {
    static int n, m, count = 0;
    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};


    public void DFS(int d, int x, int y){
        if(d == count - m){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){

                }
            }
        } else{
            for(int i=0;i<4;i++){
                int nx = x + dx[i], ny = y + dy[i];
                    if(arr[ny][nx] == 2){
                        arr[ny][nx] = 0;
                        DFS(d+1, nx, ny);
                        arr[ny][nx] = 2;
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
        arr = new int[n][n];
        visited = new boolean[n][n];
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    count++;
                }
            }
        }
    }
}