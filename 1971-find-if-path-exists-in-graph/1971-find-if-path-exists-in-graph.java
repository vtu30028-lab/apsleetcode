import java.util.*;

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Base case: if source is the destination, a path trivially exists
        if (source == destination) {
            return true;
        }

        // Step 1: Build the adjacency list for the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // Step 2: Initialize BFS queue and visited array
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        // Step 3: Traverse the graph
        while (!queue.isEmpty()) {
            int curr = queue.poll();

            // If we reach the destination, return true
            if (curr == destination) {
                return true;
            }

            // Check all neighboring nodes
            for (int neighbor : graph.get(curr)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        // If the queue empties without reaching the destination
        return false;
    }
}