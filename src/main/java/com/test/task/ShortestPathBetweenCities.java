package com.test.task;

import java.util.*;

public class ShortestPathBetweenCities {
    public static int shortestPath(Map<Integer, List<int[]>> graph, int source, int dest) {
        // Queue to process nodes with the smallest distance first
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));

        // Stores the shortest distance to each node
        Map<Integer, Integer> distances = new HashMap<>();

        // Keeps track of visited nodes not to process them again
        Set<Integer> visited = new HashSet<>();

        // Set distance to source node as 0
        queue.offer(new int[]{source, 0});
        distances.put(source, 0);

        while (!queue.isEmpty()) {
            // Process the node with the smallest distance
            int[] current = queue.poll();
            int node = current[0];
            int dist = current[1];

            // Stop if the destination is reached
            if (node == dest) return dist;

            // Skip already visited nodes
            if (visited.contains(node)) continue;
            visited.add(node);

            // Check all neighbors of the current node
            for (int[] neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                int newDist = dist + weight;

                // Update the distance to the neighbor if a shorter path is found
                if (newDist < distances.getOrDefault(nextNode, Integer.MAX_VALUE)) {
                    distances.put(nextNode, newDist);
                    queue.offer(new int[]{nextNode, newDist});
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfTests = scanner.nextInt();

        for (int i = 0; i < numberOfTests; i++) {
            // Map city names to their indices
            Map<String, Integer> indexByName = new HashMap<>();

            // Adjacency list representation of the graph
            Map<Integer, List<int[]>> graph = new HashMap<>();

            // Number of cities for this test case
            int numberOfCities = scanner.nextInt();

            for (int index = 1; index <= numberOfCities; index++) {
                String nameOfCity = scanner.next();
                int numberOfNeighbours = scanner.nextInt();

                // List to store neighbors and their respective costs
                List<int[]> neighbours = new ArrayList<>();
                scanner.nextLine();

                for (int j = 0; j < numberOfNeighbours; j++) {
                    // Read and parse the neighbor and cost information
                    String[] nr = scanner.nextLine().split(" ");
                    int[] neighbourCost = Arrays.stream(nr)
                            .mapToInt(Integer::parseInt).toArray();
                    neighbours.add(neighbourCost);
                }

                // Add city neighbors to the graph
                graph.put(index, neighbours);
                indexByName.put(nameOfCity, index);
            }

            int numberOfPaths = scanner.nextInt();

            // List to store source and destination pairs
            List<String[]> pairs = new ArrayList<>();
            scanner.nextLine();

            for (int j = 0; j < numberOfPaths; j++) {
                String[] sourceDestination = scanner.nextLine().split(" ");
                pairs.add(sourceDestination);
            }

            // Compute and print the shortest path for each source and destination pair
            for (String[] path : pairs) {
                int shortestDistance = shortestPath(graph, indexByName.get(path[0]), indexByName.get(path[1]));
                System.out.println(shortestDistance);
            }

            // Print an empty line after each test case
            System.out.println();
        }
    }
}
