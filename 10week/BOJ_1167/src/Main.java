import java.io.*;
import java.util.*;

class Node{
    int val, dis;

    public Node(int val, int dis) {
        this.val = val;
        this.dis = dis;
    }
}
public class Main {
    static int v, maxDistance, maxNode = 0;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>();
    static boolean[] visited;
    public void DFS(int n, int distance){
        for (Node node : graph.get(n)) {
            int nx = node.val;
            int dis = node.dis;
            if(!visited[nx]){
                visited[nx] = true;
                if(maxDistance < distance + dis){
                    maxDistance = distance + dis;
                    maxNode = nx;
                }
                DFS(nx, distance + dis);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        v = Integer.parseInt(br.readLine());
        for(int i=0;i<=v;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int nv, dis;
            while ((nv = Integer.parseInt(st.nextToken())) != -1){
                dis = Integer.parseInt(st.nextToken());
                graph.get(n).add(new Node(nv, dis));
            }
        }
        visited = new boolean[v+1];
        visited[1] = true;
        maxDistance = Integer.MIN_VALUE;
        T.DFS(1, 0);
        visited = new boolean[v+1];
        visited[maxNode] = true;
        T.DFS(maxNode, 0);
        bw.write(String.valueOf(maxDistance));
        bw.flush();
        bw.close();
    }
}