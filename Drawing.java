public class Drawing {
    private static Drawing instance;
    private AbstractElement element;

    private Drawing() {}

    public static Drawing getInstance(){
        if(instance == null){
            instance = new Drawing();
        }
        return instance;
    }

    public AbstractElement getElement(){
        return element;
    }

    public void setElement(AbstractElement element){
        this.element = element;
    }
}
