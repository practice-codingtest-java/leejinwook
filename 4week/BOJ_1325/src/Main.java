import java.io.*;
import java.util.*;

public class Main {
    static int n, m, max = Integer.MIN_VALUE;
    static ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
    static boolean[] visited;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        answer = new int[n+1];
        for(int i=0;i<=n;i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());

            arrayList.get(from).add(to);
        }
        for(int t=1;t<=n;t++){
            visited = new boolean[n+1];
            visited[t] = true;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(t);
            while (!queue.isEmpty()){
                int len = queue.size();
                for(int i=0;i<len;i++){
                    int cur = queue.poll();
                    for(int j=0;j<arrayList.get(cur).size();j++){
                        int nx = arrayList.get(cur).get(j);
                        if(!visited[nx]){
                            visited[nx] = true;
                            answer[t]++;
                            queue.offer(nx);
                        }
                    }
                }
            }
            max = Math.max(answer[t], max);
        }
        for(int i=1;i<=n;i++){
            if(answer[i] == max){
                bw.write(i + " ");
            }
        }
        bw.flush();
        bw.close();
    }
}