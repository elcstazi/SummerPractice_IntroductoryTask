import structs.ArrayVertices;
import structs.PriorityQueue;
import structs.Vertex;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] firstLine = in.nextLine().split(" ");
        String[] secondLine = in.nextLine().split(" ");

        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        PriorityQueue priorityQueue = new PriorityQueue(N);
        int[] arrayTimes = Arrays.stream(secondLine).mapToInt(Integer::parseInt).toArray();
        ArrayVertices answer = new ArrayVertices();

        // Solve
        for (int i = 0; i < arrayTimes.length; i++) {
            Vertex minVertex = priorityQueue.extractMin();
            answer.add(minVertex);
            Vertex newVertex = new Vertex(minVertex.getTaskNumber(), minVertex.getProcessingTime() + arrayTimes[i]);
            priorityQueue.insert(newVertex);
        }

        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i).toString());
        }
    }
}