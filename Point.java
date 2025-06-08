import java.awt.geom.Line2D;

public class Point extends AbstractElement implements CollisionDetector{
    private float x;
    private float y;
    private static int numberOfInstances;

    public Point(){
        this(0,0);
    }

    public Point(float x, float y){
        super();
        this.x = x;
        this.y = y;
        numberOfInstances++;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public static int getNumOfInstances() {
        return numberOfInstances;
    }

    @Override
    public boolean intersect(Point point){
        return this.x == point.getX() && this.y == point.getY();
    }

    @Override
    public boolean intersect(LineSeg lineSeg){
        Line2D.Float line = new Line2D.Float(
            lineSeg.getBegin().getX(), lineSeg.getBegin().getY(),
            lineSeg.getEnd().getX(), lineSeg.getEnd().getY()
        );
        return line.ptLineDist(this.x, this.y) == 0;       
    }

    @Override
    public boolean intersect(Rectangle rectangle){
        return (x > rectangle.getLeft() && x < rectangle.getRight() && y < rectangle.getTop() && y > rectangle.getBottom());
    }

    @Override
    public boolean intersect(Circle circle){
        float dx = x - circle.getCenter().getX();
        float dy = y - circle.getCenter().getY();
        return (dx * dx + dy * dy) <= circle.getRadius() * circle.getRadius();
    }

    @Override
    public boolean intersect(CompElement compElement) {
        return compElement.intersect(this);
    }
}
