import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int[] block = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }
        int answer = 0;
        for (int i = 1; i < W - 1; i++) {
            int left = 0, right = 0;
            for (int j = 0; j < i; j++) {
                left = Math.max(left, block[j]);
            }
            for (int j = i + 1; j < W; j++) {
                right = Math.max(right, block[j]);
            }
            int diff = Math.min(left, right) - block[i];
            answer += (diff > 0) ? diff : 0;
        }
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}