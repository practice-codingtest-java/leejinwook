import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

class Favor implements Comparable<Favor>{
    String name;
    int cnt;

    public Favor(String name, int cnt) {
        this.name = name;
        this.cnt = cnt;
    }

    @Override
    public int compareTo(Favor o) {
        if(this.cnt == o.cnt){
            return this.name.compareTo(o.name);
        }
        else return o.cnt - this.cnt;
    }
}
public class Main {
    public HashMap<String, Integer> solution(int n, String[] arr, ArrayList<String> cnt){
        HashMap<String, Integer> answer = new HashMap<>();
        for (String s : arr) {
            answer.put(s, 0);
        }
        for (String str : cnt) {
            answer.put(str, answer.getOrDefault(str, 0) + 1);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<String> cnt = new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i] = st.nextToken();
        }
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                cnt.add(st.nextToken());
            }
        }
        HashMap<String, Integer> hashMap = T.solution(n, arr, cnt);
        ArrayList<Favor> answer = new ArrayList<>();
        for (String s : hashMap.keySet()) {
            answer.add(new Favor(s, hashMap.get(s)));
        }
        Collections.sort(answer);
        for (Favor favor : answer) {
            bw.write(favor.name + " " + favor.cnt + "\n");
        }
        bw.flush();
        bw.close();
    }
}