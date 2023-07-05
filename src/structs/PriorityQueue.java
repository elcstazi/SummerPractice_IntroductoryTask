package structs;

public class PriorityQueue {

    private ArrayVertices innerArray;


    public PriorityQueue(int numberProcessors){
        innerArray = new ArrayVertices();
        for(int i = 0; i < numberProcessors; i++){
            Vertex newVertex = new Vertex(i, 0);
            insert(newVertex);
        }
    }

    //get the left descendant
    private int getLeftIndex(int index) {
        return index * 2 + 1;
    }

    //get the right descendant
    private int getRightIndex(int index) {
        return index * 2 + 2;
    }

    //ordering the vertices by their priority
    void heapify(int i) {
        int size = innerArray.size();
        // Find the largest among root, left child and right child
        int indexMinimumElement = i;
        int leftIndex = getLeftIndex(i);
        int rightIndex = getRightIndex(i);
        if (leftIndex < size) {
            if (innerArray.get(leftIndex).getProcessingTime() < innerArray.get(indexMinimumElement).getProcessingTime())
                indexMinimumElement = leftIndex;
            else if (innerArray.get(leftIndex).getProcessingTime() == innerArray.get(indexMinimumElement).getProcessingTime() &&
                    innerArray.get(leftIndex).getTaskNumber() < innerArray.get(indexMinimumElement).getTaskNumber())
                indexMinimumElement = leftIndex;
        }
        if (rightIndex < size) {
            if( innerArray.get(rightIndex).getProcessingTime() < innerArray.get(indexMinimumElement).getProcessingTime())
                indexMinimumElement = rightIndex;
            else if (innerArray.get(rightIndex).getProcessingTime() == innerArray.get(indexMinimumElement).getProcessingTime() &&
                    innerArray.get(rightIndex).getTaskNumber() < innerArray.get(indexMinimumElement).getTaskNumber())
                indexMinimumElement = rightIndex;
        }

        // Swap and continue heapifying
        if (indexMinimumElement != i) {
            Vertex tempVertex = innerArray.get(indexMinimumElement);
            innerArray.set(indexMinimumElement, innerArray.get(i));
            innerArray.set(i, tempVertex);
            heapify(indexMinimumElement);
        }

    }

    // insert node
    public void insert(Vertex newVertex) {
        int size = innerArray.size();
        if (size == 0) {
            innerArray.add(newVertex);
        } else {
            innerArray.add(newVertex);
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
        }
    }

    // get the minimum node
    public Vertex extractMin() {
        Vertex lastVertex = innerArray.get(innerArray.size() - 1);
        Vertex tempVertex = (Vertex)innerArray.set(0,lastVertex);
        innerArray.set(innerArray.size() - 1, tempVertex);
        innerArray.removeLastItem();
        return tempVertex;
    }


}
