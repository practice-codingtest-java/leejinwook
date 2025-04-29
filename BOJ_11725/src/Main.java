import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static int[] answer;
    static boolean[] visited;
    public void DFS(int d, int n) {
        for (int nx : arrayList.get(n)) {
            if(!visited[nx]){
                visited[nx] = true;
                answer[nx] = n;
                DFS(d + 1, nx);
            }
        }
    }
    public void BFS(){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int cur = queue.poll();
                for (Integer nx : arrayList.get(cur)) {
                    if(!visited[nx]){
                        visited[nx] = true;
                        answer[nx] = cur;
                        queue.offer(nx);
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        answer = new int[n+1];
        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            arrayList.get(to).add(from);
            arrayList.get(from).add(to);
        }
        visited[1] = true;
//        T.DFS(0, 1);
        T.BFS();
        for(int i=2;i<=n;i++){
            bw.write(answer[i] + "\n");
        }
        bw.flush();
        bw.close();
    }
}