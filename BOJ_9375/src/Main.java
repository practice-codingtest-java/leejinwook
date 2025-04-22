import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public int solution(int n, String[][] arr){
        int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i=0;i<n;i++){
            hashMap.put(arr[i][1], hashMap.getOrDefault(arr[i][1], 0) + 1);
        }
        for (String s : hashMap.keySet()) {
            int kind = hashMap.get(s) + 1;
            answer *= kind;
        }
        answer -= 1;
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            String[][] arr = new String[n][2];
            for(int j=0;j<n;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                arr[j][0] = st.nextToken();
                arr[j][1] = st.nextToken();
            }
            int answer = T.solution(n, arr);
            bw.write(String.valueOf(answer) + "\n");
        }
        bw.flush();
        bw.close();
    }
}