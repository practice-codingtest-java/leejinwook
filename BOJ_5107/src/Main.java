import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int answer;
    public void DFS(int d, int depth, ArrayList<ArrayList<Integer>> arrayList, boolean[] visited, int start){
        if(d == start && depth >= 2){
            answer++;
            return;
        }
        for(int i = 0; i < arrayList.get(d).size(); i++){
            int next = arrayList.get(d).get(i);
            if(!visited[next]){
                visited[next] = true;
                DFS(next, depth+1, arrayList, visited, start);
            }
        }
    }
    public void solution(int n, String[][] arr){
        int count = 0;
        boolean[] visited = new boolean[n];
        HashMap<String, Integer> hashMap = new HashMap<>();
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!hashMap.containsKey(arr[i][0])){
                hashMap.put(arr[i][0], count);
                count++;
            }
            if(!hashMap.containsKey(arr[i][1])){
                hashMap.put(arr[i][1], count);
                count++;
            }
            arrayList.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            arrayList.get(hashMap.get(arr[i][0])).add(hashMap.get(arr[i][1]));
            arrayList.get(hashMap.get(arr[i][1])).add(hashMap.get(arr[i][0]));
        }
        for(int i=0;i<n;i++){
            DFS(i, 0, arrayList, visited, i);
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        int t = 1;
        while (!(line = br.readLine()).equals("0")){
            answer = 0;
            int n = Integer.parseInt(line);
            String[][] arr = new String[n][2];
            ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
            for(int i=0;i<n;i++){
                arrayList.add(new ArrayList<>());
            }
            for(int i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[i][0] = st.nextToken();
                arr[i][1] = st.nextToken();
            }
            T.solution(n, arr);
            bw.write(t + " " + answer + " ");
        }
        bw.flush();
        bw.close();
    }
}