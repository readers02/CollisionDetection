public class TestElements {
	public static void main(String[] args) {
		testStaticElements();

		testCollisions();
	}

	static void testStaticElements() {
		Point p1 = new Point(1, 1);
		Point p2 = new Point(4, 3);
		LineSeg l1 = new LineSeg(new Point(2, 2), new Point(5, 3));
		LineSeg l2 = new LineSeg(p1, p2);
		Circle c1 = new Circle(p1, 3);
		Circle c2 = new Circle(p2, 5);
		Rectangle r1 = new Rectangle(3, 5, 3, 0);
		Rectangle r2 = new Rectangle(1, 7, 6, 3);
		Rectangle r3 = new Rectangle();

		if (Point.getNumOfInstances() != 4) {
			System.out.println("Point.NumberOfInstances error");

		}
		if (LineSeg.getNumOfInstances() != 2) {
			System.out.println("LineSeg.NumberOfInstances error");
		}
		if (Circle.getNumOfInstances() != 2) {
			System.out.println("Circle.NumberOfInstances error");
		}
		if (Rectangle.getNumOfInstances() != 3) {
			System.out.println("Rectangle.NumberOfInstances error");
		}
		if (AbstractElement.getNumOfInstances() != 11) {
			System.out.println("AbstractElement.NumberOfInstances error");
		}
	}

	static void testCollisions() {
		Point point1 = new Point(2, 2);
		Point point2 = new Point(5, 7);
		LineSeg line1 = new LineSeg(new Point(1, 1), new Point(3, 3));
		LineSeg line2 = new LineSeg(new Point(4, 4), new Point(7, 8));
		Circle circle1 = new Circle(new Point(3, 2), 2);
		Circle circle2 = new Circle(new Point(10, 10), 3);
		Rectangle rect1 = new Rectangle(0, 4, 5, 1);
		Rectangle rect2 = new Rectangle(6, 8, 10, 7);
		Circle circle3 = new Circle(new Point(3, 3), 2);
		Circle circle4 = new Circle(new Point(5, 3), 2);
		Rectangle rect3 = new Rectangle(1, 4, 4, 2);
		Rectangle rect4 = new Rectangle(3, 6, 5, 1);

		// True cases
		assert point1.intersect(new Point(2, 2))
			: "Test Failed: Point at (2,2) should intersect at (2,2)";
		assert point1.intersect(line1)
			: "Test Failed: Point at (2,2) should intersect from (1,1) to (3,3)";
		assert point1.intersect(circle1)
			: "Test Failed: Point at (2,2) should be inside circle with center (3,2) and radius 2";
		assert point1.intersect(rect1)
			: "Test Failed: Point at (2,2) should be inside rectangle with corners (0,5) and (4,1)";
		assert line1.intersect(circle1)
			: "Test Failed: Line from (1,1) to (3,3) should intersect circle with center (2,2) and radius 1";
		assert line1.intersect(rect1)
			: "Test Failed: Line from (1,1) to (3,3) should intersect rectangle with corners (0,5) and (4,1)";
		assert circle1.intersect(rect1)
			: "Test Failed: Circle with center (2,2) and radius 1 should intersect rectangle with corners (1,6) and (4,2)";
		assert circle3.intersect(circle4)
			: "Test Failed: Circle with center (3,3) and radius 2 should intersect with circle at (5,3) and radius 2";
		assert rect3.intersect(rect4)
			: "Test Failed: Rectangle with corners (1,4) and (4,2) should intersect with rectangle (3,5) and (6,1)";

		// False cases
		assert !point1.intersect(point2) : "Test Failed: Point at (2,2) should not intersect with a point at (5,7)";
		assert !point1.intersect(line2)
			: "Test Failed: Point at (2,2) should not intersect with line segment from (4,4) to (7,8)";
		assert !point1.intersect(circle2)
			: "Test Failed: Point at (2,2) should be outside circle with center (10,10) and radius 3";
		assert !point1.intersect(rect2)
			: "Test Failed: Point at (2,2) should be outside rectangle with corners (6,10) and (8,7)";
		assert !line1.intersect(line2)
			: "Test Failed: Line from (0,0) to (3,3) should not intersect with line from (5,5) to (7,7)";
		assert !line1.intersect(circle2)
			: "Test Failed: Line from (0,0) to (3,3) should not intersect with circle centered at (5,5) with radius 1";
		assert !line1.intersect(rect2)
			: "Test Failed: Line from (0,0) to (3,3) should not intersect with rectangle (5,8) to (7,6)";
		assert !circle3.intersect(circle2)
			: "Test Failed: Circle at (3,3) with radius 2 should not intersect with circle at (10,10) with radius 1";
		assert !circle1.intersect(rect2)
			: "Test Failed: Circle with center (2,2) and radius 1 should not intersect with rectangle corners (6,10) and (8,8)";
		assert !rect3.intersect(rect2)
			: "Test Failed: Rectangle with corners (1,4) and (4,2) should not intersect with rectangle (8,10) and (10,7)";

		System.out.println("All tests passed successfully.");
	}
}
