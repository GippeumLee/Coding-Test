import java.util.ArrayList;
import java.util.Collections;

class Solution {
    static String[][] input;
    static boolean[] visited;
    static ArrayList<String> answer;

    public String[] solution(String[][] tickets) {
        input = tickets;
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals("ICN")) {
                visited[i] = true;
                dfs(tickets[i][1], tickets[i][0] + "," + tickets[i][1], 1);
                visited[i] = false;
            }
        }
        Collections.sort(answer);
        return answer.get(0).split(",");
    }

    static void dfs(String before, String route, int ticketCount) {
        if (ticketCount == input.length) {
            answer.add(route);
            return;
        }
        for (int i = 0; i < input.length; i++) {
            if (!visited[i] && input[i][0].equals(before)) {
                visited[i] = true;
                dfs(input[i][1], route + "," + input[i][1], ticketCount + 1);
                visited[i] = false;
            }
        }
    }
}