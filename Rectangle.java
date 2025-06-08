import java.awt.geom.Rectangle2D;

public class Rectangle extends AbstractElement implements CollisionDetector{
    private float left;
    private float right;
    private float top;
    private float bottom;
    private static int numberOfInstances;

    public Rectangle(){
        this(0,1,0,1);
    }

    public Rectangle(float left, float right, float top, float bottom){
        super();
        this.left = left;
        this.right = right;
        this.top = top;
        this.bottom = bottom;
        numberOfInstances++;
    }

    public float getLeft() {
        return left;
    }

    public float getRight() {
        return right;
    }

    public float getTop() {
        return top;
    }

    public float getBottom() {
        return bottom;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point point){
        return point.intersect(this);
    }

    @Override
    public boolean intersect(LineSeg lineSeg){
        return lineSeg.intersect(this);
    }

    @Override
    public boolean intersect(Rectangle rectangle){
        Rectangle2D rect1 = new Rectangle2D.Float(this.getLeft(), this.getBottom(),
            this.getRight() - this.getLeft(), this.getTop() - this.getBottom());
        Rectangle2D rect2 = new Rectangle2D.Float(rectangle.getLeft(), rectangle.getBottom(),
            rectangle.getRight() - rectangle.getLeft(), rectangle.getTop() - rectangle.getBottom());
        return rect1.intersects(rect2);
    }

    @Override
    public boolean intersect(Circle circle){
        return circle.intersect(this);
    }

    @Override
    public boolean intersect(CompElement compElement) {
        return compElement.intersect(this);
    }
}
