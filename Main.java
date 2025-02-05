import Algos.GraphAlgos.*;
import Algos.ArrayAlgos.*;
import Algos.TreesAlgos.TreeTraversals;
import utils.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private final static String dividingLine = "---------------------------------------------------";

    public static void main(String[] args) {
        System.out.println(dividingLine);
        System.out.println("SEARCHES");
        {
            int[] array = {7, 12, 5, 19, 3, 8, 14, 2, 10, 6, 17, 4, 11, 1, 9};
            int[] sortedArray = {3, 7, 12, 15, 22, 28, 34, 45, 58, 63, 79, 91, 101, 115, 130};

            // linear search example
            System.out.println("\nLinear search");
            System.out.println(Searches.linearSearch(array, 17)); // Output: 10
            System.out.println(Searches.linearSearch(array, 21)); // Output: -1;

            //binary search example (works only in sorted array)
            System.out.println("\nBinary search (works only in sorted array)");
            System.out.println(Searches.binarySearch(sortedArray, 91)); // Output: 11
            System.out.println(Searches.binarySearch(sortedArray, 18)); // Output: -1;
        }
        System.out.println("\n"+dividingLine);

        System.out.println("\nSORTS");
        {
            int[] array = {7, 12, 5, 19, 3, 8, 14, 2, 10, 6, 17, 4, 11, 1, 9};

            // bubble sort
            System.out.println("\nBubble sort");
            System.out.println("Before sorting: " + Arrays.toString(array));
            Sorts.bubbleSort(array);
            System.out.println("After sorting: " + Arrays.toString(array));

            // quick sort
            System.out.println("\nQuick sort");
            Helper.shuffle(array);
            System.out.println("Before sorting: " + Arrays.toString(array));
            Sorts.quickSort(array);
            System.out.println("After sorting: " + Arrays.toString(array));
        }
        System.out.println("\n"+dividingLine);

        System.out.println("\nGRAPHS");
        //unweighted
        {
            //GRAPH READING
            List<List<Integer>> unweightedGraph = new ArrayList<>();
            int vertex, edge;
            try (Scanner sc = new Scanner(new File("utils/unweighted_graph.txt"))) {
                vertex = sc.nextInt();
                edge = sc.nextInt();
                for(int i = 0; i < vertex; ++i) {
                    unweightedGraph.add(new ArrayList<>());
                }
                for(int i = 0; i < edge; ++i) {
                    int a = sc.nextInt(), b = sc.nextInt();
                    unweightedGraph.get(a).add(b);
                    unweightedGraph.get(b).add(a);
                }

            } catch (FileNotFoundException e) {
                throw new RuntimeException("File not found.");
            }

            // TRAVERSALS
            {
                System.out.println("\nDFS");
                System.out.print("vertexes: ");
                boolean[] visited = new boolean[unweightedGraph.size()];
                for (int i = 0; i < unweightedGraph.size(); ++i) {
                    if (!visited[i]) {
                        GraphTraversals.dfs(unweightedGraph, i, visited);
                        System.out.print("| ");
                    }
                }
            }

            {
                System.out.println("\b\b\b\n\nBFS");
                System.out.print("vertexes: ");
                GraphTraversals.bfs(unweightedGraph, 0);
            }
        }

        //weighted
        {
            // GRAPH READING
            List<List<int[]>> adjacencyList = new ArrayList<>();
            List<Edge> edgeList = new ArrayList<>();
            int vertex, edge;
            try (Scanner sc = new Scanner(new File("utils/weighted_graph.txt"))) {
                vertex = sc.nextInt();
                edge = sc.nextInt();

                for(int i = 0; i < vertex; ++i) {
                    adjacencyList.add(new ArrayList<>());
                }

                for(int i = 0; i < edge; ++i) {
                    int a = sc.nextInt(), b = sc.nextInt();
                    int w = sc.nextInt();

                    adjacencyList.get(a).add(new int[]{b, w});
                    edgeList.add(new Edge(a, b, w));
                }
            } catch (FileNotFoundException e) {
                throw new RuntimeException("File not found.");
            }


            // ALGORITHMS
            {
                System.out.println("\nDijkstra from vertex 5");
                System.out.println("Distances from vertex 5 to other:\n" +
                        Arrays.toString(ShortestPaths.dijkstra(adjacencyList, 5)));
            }

            {
                System.out.println("\nBellman-Ford from vertex 5");
                System.out.println("Distances from vertex 5 to other:\n" +
                        Arrays.toString(ShortestPaths.bellmanFord(edgeList, 5, vertex)));
            }

            {
                System.out.println("\nFloyd-Warshall");

            }
        }
        System.out.println("\n"+dividingLine+"\n");

        System.out.println("TREES");
        {
            // BUILD TREES
            BinaryTree bt = new BinaryTree(new int[]{3, 4, 5, 6, 1, 2, 7});
            BinaryTree bst = new BinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
            {

            }
            // TRAVERSALS
            {
                System.out.println("\nDFS(BT)");
                TreeTraversals.DFS(bt);

                System.out.println("\n\nBFS(BT)");
                TreeTraversals.BFS(bt);

                System.out.println("\nInorder(BST)");
                TreeTraversals.inOrder(bst);

                System.out.println("\nPreorder(BST)");
                TreeTraversals.preOrder(bst);

                System.out.println("\nPostorder(BST)");
                TreeTraversals.postOrder(bst);

            }

            // OTHER
            {

            }
        }
        System.out.println("\n"+dividingLine);
    }
}
