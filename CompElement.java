import java.util.ArrayList;

public class CompElement extends AbstractElement implements CollisionDetector{
    protected ArrayList<AbstractElement> components = new ArrayList<>();

    public void addElement(AbstractElement element){
        components.add(element);
    }

    public void removeElement(AbstractElement element){
        components.remove(element);
    }

    @Override
    public boolean intersect(Point point) {
        for (AbstractElement element : components) {
            if (((CollisionDetector) element).intersect(point)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(LineSeg lineSeg) {
        for (AbstractElement element : components) {
            if (((CollisionDetector) element).intersect(lineSeg)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(Rectangle rectangle) {
        for (AbstractElement element : components) {
            if (((CollisionDetector) element).intersect(rectangle)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean intersect(Circle circle) {
        for (AbstractElement element : components) {
            if (((CollisionDetector) element).intersect(circle)) {
                return true;
            }
        }
        return false;
    }

    public boolean intersect(CompElement compElement) {
        for (AbstractElement element : components) {
            for (AbstractElement otherElement : compElement.components) {
                CollisionDetector detector = (CollisionDetector) element;
            if (otherElement instanceof Point) {
                if (detector.intersect((Point) otherElement)) {
                    return true;
                }
                } else if (otherElement instanceof LineSeg) {
                    if (detector.intersect((LineSeg) otherElement)) {
                        return true;
                    }
                } else if (otherElement instanceof Rectangle) {
                    if (detector.intersect((Rectangle) otherElement)) {
                        return true;
                    }
                } else if (otherElement instanceof Circle) {
                    if (detector.intersect((Circle) otherElement)) {
                        return true;
                    }
                } else if (otherElement instanceof CompElement) {
                    if (((CompElement) element).intersect((CompElement) otherElement)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public CompElementIterator getIterator() {
        return new CompElementIterator(this);
    }
}
