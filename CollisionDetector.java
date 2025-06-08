public interface CollisionDetector {
    public boolean intersect(Point point);
    public boolean intersect(LineSeg lineSeg);
    public boolean intersect(Rectangle rectangle);
    public boolean intersect(Circle circle);
    public boolean intersect(CompElement compElement);
}
