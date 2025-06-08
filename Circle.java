import java.awt.geom.Rectangle2D;
import java.awt.geom.Ellipse2D;

public class Circle extends AbstractElement implements CollisionDetector {
    private Point center;
    private float radius;
    private static int numberOfInstances;

    public Circle(){
        this(new Point(), 1);
    }

    public Circle(Point center, float radius){
        super();
        this.center = center;
        this.radius = radius;
        numberOfInstances++;
    }

    public Point getCenter() {
        return center;
    }

    public float getRadius() {
        return radius;
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
        Rectangle2D rect = new Rectangle2D.Float(rectangle.getLeft(), rectangle.getBottom(),
        rectangle.getRight() - rectangle.getLeft(), rectangle.getTop() - rectangle.getBottom());
        Ellipse2D circleShape = new Ellipse2D.Float(center.getX()-radius, center.getY() - radius, radius * 2, radius * 2);
        return circleShape.intersects(rect);
    }

    @Override
    public boolean intersect(Circle circle){
        float dx = this.center.getX() - circle.getCenter().getX();
        float dy = this.center.getY() - circle.getCenter().getY();
        float distSquared = dx * dx + dy * dy;
        float radSum = this.radius + circle.getRadius();
        return distSquared <= radSum * radSum; 
    }

    @Override
    public boolean intersect(CompElement compElement) {
        return compElement.intersect(this);
    }
} 
