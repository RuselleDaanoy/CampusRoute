package com.example;

import java.util.*;

public class Shortest {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] graph = {
            {0, 8, 7, 4, 0, 0, 0, 0, 0, 0},
            {8, 0, 0, 0, 0, 0, 45, 0, 0, 0},
            {7, 0, 0, 0, 0, 0, 0, 0, 0, 50},
            {4, 0, 0, 0, 5, 0, 0, 0, 0, 0},
            {0, 0, 0, 5, 0, 70, 0, 40, 0, 0},
            {0, 0, 0, 0, 70, 0, 32, 0, 0, 0},
            {0, 45, 0, 0, 0, 32, 0, 0, 0, 0},
            {0, 0, 0, 0, 40, 0, 0, 0, 30, 0},
            {0, 0, 0, 0, 0, 0, 0, 30, 0, 35},
            {0, 0, 50, 0, 0, 0, 0, 0, 35, 0}
        };

        String[][] direction1 = {
            {"0", "LEFT", "RIGHT", "STRAIGHT", "0", "0", "0", "0", "0", "0"},
            {"STRAIGHT", "0", "0", "0", "0", "0", "STRAIGHT", "0", "0", "0"},
            {"LEFT", "0", "0", "0", "0", "0", "0", "0", "0", "STRAIGHT"},
            {"STRAIGHT", "0", "0", "0", "LEFT", "0", "0", "0", "0", "0"},
            {"0", "0", "0", "RIGHT", "0", "STRAIGHT", "0", "STRAIGHT", "0", "0"},
            {"0", "0", "0", "0", "RIGHT", "0", "LEFT", "0", "0", "0"},
            {"0", "RIGHT", "0", "0", "0", "RIGHT", "0", "0", "0", "0"},
            {"0", "0", "0", "0", "STRAIGHT", "0", "0", "0", "STRAIGHT", "0"},
            {"0", "0", "0", "0", "0", "0", "0", "RIGHT", "0", "RIGHT"},
            {"0", "0", "LEFT", "0", "0", "0", "0", "0", "LEFT", "0"}
        };

        int destinationNode = 5; // Change this to your desired destination node
        Result result = findShortestPath(graph, direction1, 0, destinationNode);

        System.out.println("Shortest Path from node 0 to node " + destinationNode + ": " + result.path);
        System.out.println("Total Distance: " + result.distance);
        System.out.println("Directions: " + Arrays.toString(result.directions.toArray()));
    }

    private static class Result {
        List<Integer> path;
        List<String> directions;
        int distance;

        Result(List<Integer> path, List<String> directions, int distance) {
            this.path = path;
            this.directions = directions;
            this.distance = distance;
        }
    }

    private static Result findShortestPath(int[][] graph, String[][] directions, int source, int destination) {
        int n = graph.length;
        int[] distances = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(distances, INFINITY);
        distances[source] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distances[i]));
        pq.offer(source);

        while (!pq.isEmpty()) {
            int u = pq.poll();
            if (u == destination) {
                break; // Stop early if destination is reached
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {
                    int alt = distances[u] + graph[u][v];
                    if (alt < distances[v]) {
                        distances[v] = alt;
                        pq.offer(v);
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        List<String> pathDirections = new ArrayList<>();
        path.add(destination);
        pathDirections.add("Destination");
        int current = destination;
        while (current != source) {
            for (int prev = 0; prev < n; prev++) {
                if (distances[current] == distances[prev] + graph[prev][current]) {
                    path.add(prev);
                    pathDirections.add(directions[prev][current]);
                    current = prev;
                    break;
                }
            }
        }
        Collections.reverse(path);
        Collections.reverse(pathDirections);

        return new Result(path, pathDirections, distances[destination]);
    }
}
