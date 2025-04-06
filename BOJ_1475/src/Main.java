import java.io.*;
import java.util.HashMap;

public class Main {
    public int solution(String str){
        int answer = 0;
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : arr) {
            if(c == '9') c = '6';
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        if(hashMap.containsKey('6')){
            hashMap.put('6', (hashMap.get('6') / 2) + (hashMap.get('6') % 2));
        }
        for (Integer i : hashMap.values()) {
            answer = Math.max(i, answer);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int answer = T.solution(str);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}