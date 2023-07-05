package structs;



public class ArrayVertices{
    private final int CAPACITY = 10;
    private int current_size = 0;
    private Vertex[] array;

    public ArrayVertices() {
        array = new Vertex[CAPACITY];
    }

    public ArrayVertices(int size) {
        array = new Vertex[size];
    }

    public void add(Vertex item) {
        if (current_size == array.length)
            resize(array.length * 2);
        array[current_size++] = item;
    }

    public int size() {
        return current_size;
    }


    public Vertex get(int index) {
        return array[index];
    }

    private void resize(int size) {
        Vertex[] newArray = new Vertex[size];
        System.arraycopy(array, 0, newArray, 0, current_size);
        array = newArray;
    }

    public Vertex set(int index, Vertex item)
    {
        if(index < array.length && index >= 0)
        {
            Vertex tempVertex = array[index];
            array[index] = item;
            return tempVertex;
        }
        return null;
    }

    public void removeLastItem()
    {
        array[current_size--] = null;
        if(current_size < CAPACITY && array.length > 2 * CAPACITY)
            resize(CAPACITY);
    }

}