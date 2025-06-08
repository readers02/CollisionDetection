import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class LineSeg extends AbstractElement implements CollisionDetector{
    private Point begin;
    private Point end;
    private static int numberOfInstances;

    public LineSeg(){
        this(new Point(), new Point(1,1));
    }

    public LineSeg(Point begin, Point end){
        super();
        this.begin = begin;
        this.end = end;
        numberOfInstances++;
    }
    
    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
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
        Line2D.Float thisLine = new Line2D.Float(
            this.getBegin().getX(), this.getBegin().getY(),
            this.getEnd().getX(), this.getEnd().getY()
        );
        Line2D.Float otherLine = new Line2D.Float(
            lineSeg.getBegin().getX(), lineSeg.getBegin().getY(),
            lineSeg.getEnd().getX(), lineSeg.getEnd().getY()
        );
        return thisLine.intersectsLine(otherLine);
    }

    @Override
    public boolean intersect(Rectangle rectangle){
        Rectangle2D rect = new Rectangle2D.Float(rectangle.getLeft(), rectangle.getBottom(),
            rectangle.getRight() - rectangle.getLeft(), rectangle.getTop() - rectangle.getBottom());
        Line2D.Float Line = new Line2D.Float(
            this.getBegin().getX(), this.getBegin().getY(),
            this.getEnd().getX(), this.getEnd().getY());
        return rect.intersectsLine(Line);
   }

   @Override
    public boolean intersect(Circle circle){
        Point2D center = new Point2D.Float(circle.getCenter().getX(), circle.getCenter().getY());
        Line2D.Float Line = new Line2D.Float(
            this.getBegin().getX(), this.getBegin().getY(),
            this.getEnd().getX(), this.getEnd().getY());
        return Line.ptSegDist(center) <= circle.getRadius();
    }

    @Override
    public boolean intersect(CompElement compElement) {
        return compElement.intersect(this);
    }
}
