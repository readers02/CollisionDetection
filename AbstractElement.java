public class AbstractElement {
    private static int numberOfInstances;

    public AbstractElement(){
        numberOfInstances++;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }
}
