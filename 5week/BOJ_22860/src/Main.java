import java.io.*;
import java.util.*;

public class Main {
    static int fileCount;
    static HashMap<String, Integer> hashMap = new HashMap<>();
    static HashMap<Integer, Integer> folderCheck = new HashMap<>();
    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
    static HashSet<Integer> hashSet;
    public void BFS(String str){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(hashMap.get(str));
        while (!queue.isEmpty()){
            int len = queue.size();
            for(int i=0;i<len;i++){
                int cur = queue.poll();
                if(folderCheck.get(cur) == 0) {
                    fileCount++;
                    hashSet.add(cur);
                }
                for (int nx : tree.get(cur)) {
                    queue.offer(nx);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[][] arr = new String[n+m][3];
        hashMap.put("main", 0);
        folderCheck.put(0, 1);
        int number = 1;
        for(int i=0;i<n+m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++){
                arr[i][j] = st.nextToken();
            }
            if (!hashMap.containsKey(arr[i][1])){
                hashMap.put(arr[i][1], number);
                number++;
            }
            folderCheck.put(hashMap.get(arr[i][1]), Integer.parseInt(arr[i][2]));
        }
        for(int i=0;i<hashMap.size();i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<n+m;i++){
            tree.get(hashMap.get(arr[i][0])).add(hashMap.get(arr[i][1]));
        }
        int q = Integer.parseInt(br.readLine());
        String[] str = new String[q];
        for(int i=0;i<q;i++){
            str[i] = br.readLine();
            String[] split = str[i].split("/");
            hashSet = new HashSet<>();
            fileCount = 0;
            T.BFS(split[split.length-1]);
            bw.write(hashSet.size() + " " + fileCount + "\n");
        }
        bw.flush();
        bw.close();
    }
}