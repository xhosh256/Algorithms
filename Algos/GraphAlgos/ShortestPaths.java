package Algos.GraphAlgos;

import java.lang.reflect.Array;
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
            boolean canRelax = false;
            for (Edge edge : graph) {
                if (dist[edge.from] != Integer.MAX_VALUE && dist[edge.to] > dist[edge.from] + edge.weight) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    canRelax = true;
                }
            }
            if(!canRelax) break;
        }

        return dist;
    }

    public static void floydWarshall(List<Edge> edges, int n) {
        int[][] dist = new int[n][n];
        for(int i = 0; i < n; ++i) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for(Edge edge: edges) {
            int src = edge.from;
            int dst = edge.to;
            int weight = edge.weight;

            dist[src][dst] = Math.min(dist[src][dst], weight);
        }

        for(int v = 0; v < n; ++v) {
            for(int a = 0; a < n; ++a) {
                for(int b = 0; b < n; ++b) {
                    if(dist[a][v] != Integer.MAX_VALUE && dist[v][b] != Integer.MAX_VALUE
                    && dist[a][b] > dist[a][v] + dist[v][b]) {
                        dist[a][b] = dist[a][v] + dist[v][b];
                    }
                }
            }
        }

        // dist output
        for(int i = 0; i < n; ++i) {
            System.out.println(Arrays.toString(dist[i]));
        }
    }
}
