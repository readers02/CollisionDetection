import java.util.Iterator;

public class CompElementIterator{
    private Iterator<AbstractElement> iterator;
    private AbstractElement currentElement;

    public CompElementIterator(CompElement compElement){
        this.iterator = compElement.components.iterator();
        first();
    }

    public void first(){
        if(iterator.hasNext()){
            currentElement = iterator.next();
        }else{
            currentElement = null;
        }
    }

    public void next(){
        if(iterator.hasNext()){
            currentElement = iterator.next();
        }else{
            currentElement = null;
        }
    }

    public boolean isDone(){
        return currentElement == null;
    }

    public AbstractElement getCurrentElement(){
        return currentElement;
    }

}
