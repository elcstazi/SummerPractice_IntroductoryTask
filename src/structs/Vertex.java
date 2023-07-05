package structs;

public class Vertex{
    private int processingTime;
    private int taskNumber;
   public Vertex(int taskNumber, int processingTime){
        this.processingTime = processingTime;
        this.taskNumber = taskNumber;
    }

    public int getProcessingTime(){
        return processingTime;
    }
    public int getTaskNumber(){
        return taskNumber;
    }

    public void setProcessingTime(int newProcessingTime){
        processingTime = newProcessingTime;
    }

    public String toString() {

        return String.valueOf(taskNumber + " " + processingTime);
    }
}
