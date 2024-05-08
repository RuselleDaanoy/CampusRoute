import java.util.*;

public class Dijkstra {
    private static final int INFINITY = Integer.MAX_VALUE;
    private String results;
    private String verticalResults;
    int[][] graph;
    String[][] direction1;
    int zoneNumber;

    public String getResults() {
        return results;
    }

    public String getVerticalResults() {
        return verticalResults;
    }

    public Dijkstra(int[][] graph, String[][] direction, int zoneNumber) {
        this.graph = graph;
        this.direction1 = direction;
        this.zoneNumber = zoneNumber;

        int destinationNode = zoneNumber; // Change this to your desired destination node
        Result result = findShortestPath(graph, direction1, 0, destinationNode);

        StringBuilder builder = new StringBuilder();
        builder.append("Shortest Path from Zone 1 to Zone " + (destinationNode + 1) + ": \n > " + formatPath(result.path) + "\n");
        builder.append("Total Distance: \n > " + result.distance + " units \n");
        builder.append("Directions: \n > " + formatDirectionsHorizontal(result.directions) + "\n");
        this.results = builder.toString();

        StringBuilder verticalBuilder = new StringBuilder();
        verticalBuilder.append("Shortest Path from Zone 1 to Zone " + (destinationNode + 1) + ":\n\n");
        verticalBuilder.append(formatVerticalResults(result.path, result.directions, result.distance));
        this.verticalResults = verticalBuilder.toString();
    }

    private String formatPath(List<Integer> path) {
        StringBuilder formattedPath = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            formattedPath.append(path.get(i) + 1); // Increment node name by 1
            if (i < path.size() - 1) {
                formattedPath.append(" -> ");
            }
        }
        return formattedPath.toString();
    }

    private String formatDirectionsHorizontal(List<String> directions) {
        StringBuilder formattedDirections = new StringBuilder();
        for (int i = 0; i < directions.size(); i++) {
            formattedDirections.append(directions.get(i));
            if (i < directions.size() - 1) {
                formattedDirections.append(", ");
            }
        }
        return formattedDirections.toString();
    }

    private String formatVerticalResults(List<Integer> path, List<String> directions, int distance) {
        StringBuilder verticalResults = new StringBuilder();
        for (int i = 0; i < path.size(); i++) {
            verticalResults.append("Zone ").append(path.get(i) + 1).append(" > ");
            if (i < directions.size()) {
                verticalResults.append(directions.get(i)).append("\n");
            }
        }
        verticalResults.append("\nTotal Distance: ").append(distance).append(" units\n");
        return verticalResults.toString();
    }

    // represents the result of the shortest path calculation, including the path (list of nodes), directions (list of strings), and the distance (total distance).
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
        int n = graph.length;                            //calculate the number on node(zone) by getting the length of graph @Floor Directory Class
        int[] distances = new int[n];                    //store the distance from the starting node(kiosk) to another node
        boolean[] visited = new boolean[n];              //keep track the nodes if visited
        Arrays.fill(distances, INFINITY);                //maximum integer value ng distances
        distances[source] = 0;                           //kiosk as starting point

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(i -> distances[i]));   
        pq.offer(source);                                // a prio queue based on distance. kapag mas shorter shorter yung distance mas prio siya

        while (!pq.isEmpty()) {                         //return the node with shortest distance
            int u = pq.poll();
            if (u == destination) {
                break; // Stop early if destination is reached
            }
            visited[u] = true;                            // magmamark as visited para maavoid yung revisiting ng nodes
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != 0 && !visited[v]) {          // check if there is an edge between nodes
                    int alt = distances[u] + graph[u][v];       // add or calculate the distance
                    if (alt < distances[v]) {                   //chcheck kung shorter ba yung current distance
                        distances[v] = alt;                    // then update
                        pq.offer(v);                           // another prio q kung may shorter path pa
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();                          //store nodes na may shortest path      
        List<String> pathDirections = new ArrayList<>();                //store directional instruction
        path.add(destination);                                           //
        pathDirections.add("You're right there!");
        int current = destination;
        while (current != source) {
            for (int prev = 0; prev < n; prev++) {
                if (graph[current][prev] != 0 && distances[current] == distances[prev] + graph[prev][current]) {
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
