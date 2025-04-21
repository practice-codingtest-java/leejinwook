import java.io.*;
import java.util.HashMap;

public class Main {
    public int solution(String str1, String str2){
        int answer = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c : str1.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) - 1);
            if(hashMap.get(c) == 0){
                hashMap.remove(c);
            }
        }
        for (Character c : hashMap.keySet()) {
            answer += Math.abs(hashMap.get(c));
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int answer = T.solution(str1, str2);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}