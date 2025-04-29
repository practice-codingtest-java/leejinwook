import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean[] visited;
    static int answer = 0;
    public void DFS(int n){
        for(int i=0;i<arrayList.get(n).size();i++){
            int nx = arrayList.get(n).get(i);
            if(!visited[nx]){
                visited[nx] = true;
                answer++;
                DFS(nx);
            }
        }
    }
    public void BFS(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int cur = queue.poll();
                for(int j=0;j<arrayList.get(cur).size();j++){
                    int nx = arrayList.get(cur).get(j);
                    if(!visited[nx]){
                        visited[nx] = true;
                        queue.offer(nx);
                        answer++;
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
        m = Integer.parseInt(br.readLine());
        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            arrayList.get(to).add(from);
            arrayList.get(from).add(to);
        }
        visited[1] = true;
//        T.DFS(1);
        T.BFS();
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}