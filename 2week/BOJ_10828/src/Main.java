import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public ArrayList<Integer> solution(int n, String[] arr, ArrayList<Integer> push){
        ArrayList<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (String s : arr) {
            switch (s){
                case "push":
                    stack.push(push.get(i));
                    i++;
                    break;
                case "pop":
                    if(stack.isEmpty()) answer.add(-1);
                    else answer.add(stack.pop());
                    break;
                case "size":
                    answer.add(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()) answer.add(1);
                    else answer.add(0);
                    break;
                case "top":
                    if(stack.isEmpty()) answer.add(-1);
                    else answer.add(stack.peek());
                    break;
            }
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        ArrayList<Integer> push = new ArrayList<>();
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i] = st.nextToken();
            if(arr[i].equals("push")) push.add(Integer.parseInt(st.nextToken()));
        }
        for (Integer i : T.solution(n, arr, push)) {
            bw.write(String.valueOf(i));
            bw.write("\n");
        }
        bw.flush();
        bw.close();
    }
}