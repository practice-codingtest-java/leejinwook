import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
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
    static int n, m, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static Node[] points;
    static ArrayList<Node> chicken = new ArrayList<>();
    static boolean[] visited;

    public void DFS(int d, int s){
        if(d == m){
            int sum = 0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(arr[i][j] == 1){
                        int dis = Integer.MAX_VALUE;
                        for(int k=0;k<points.length;k++){
                            Node cur = points[k];
                            int curDis = Math.abs(j-cur.x) + Math.abs(i-cur.y);
                            dis = Math.min(dis, curDis);
                        }
                        sum += dis;
                    }
                }
            }
            answer = Math.min(answer, sum);
        } else{
            for(int i=s;i<chicken.size();i++){
                if(!visited[i]){
                    visited[i] = true;
                    points[d] = chicken.get(i);
                    DFS(d+1, i+1);
                    visited[i] = false;
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
        points = new Node[m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 2){
                    chicken.add(new Node(j, i));
                }
            }
        }
        visited = new boolean[chicken.size()];
        T.DFS(0, 0);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}