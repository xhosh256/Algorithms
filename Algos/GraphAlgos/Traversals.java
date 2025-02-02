package Algos.GraphAlgos;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Traversals {
    public static void dfs(List<List<Integer>> graph, int v, boolean[] visited) {
        System.out.print(v+" ");
        visited[v] = true;
        for(int next: graph.get(v)) {
            if(!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }

    public static void bfs(List<List<Integer>> graph, int start) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr +" ");

            for(int next: graph.get(curr)) {
                if(dist[next] > dist[curr]+1) {
                    dist[next] = dist[curr]+1;
                    q.add(next);
                }
            }
        }
        System.out.println("\ndistances: "+ Arrays.toString(dist));
    }
}
