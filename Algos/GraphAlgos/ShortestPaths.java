package Algos.GraphAlgos;

import java.util.*;
import utils.Edge;

public class ShortestPaths {
    public static int[] dijkstra(List<List<int[]>> graph, int start) {
        int[] dist = new int[graph.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        Queue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.add(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int vertex = curr[0], distance = curr[1];

            if(distance > dist[vertex]) continue;

            for(int[] next: graph.get(vertex)) {
                int to = next[0], weight = next[1];
                if(dist[to] > dist[vertex] + weight) {
                    dist[to] = dist[vertex] + weight;
                    pq.add(new int[]{to, dist[to]});
                }
            }
        }
        return dist;
    }

    public static int[] bellmanFord(List<Edge> graph, int start, int vertexCount) {
        int[] dist = new int[vertexCount];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        for (int i = 0; i < vertexCount - 1; ++i) {
            for (Edge edge : graph) {
                if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                }
                if(dist[edge.to] != Integer.MAX_VALUE && dist[edge.from] > dist[edge.to] + edge.weight) {
                    dist[edge.from] = dist[edge.to] + edge.weight;
                }
            }
        }

        return dist;
    }
}
