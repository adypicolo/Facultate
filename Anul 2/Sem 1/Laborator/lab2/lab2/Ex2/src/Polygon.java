public class Polygon {
    private Point[] points;

    public Polygon(int n) {
        points = new Point[n];
    }

    public Polygon(float[] vect, int m) {
        points = new Point[m];

        for (int i = 0; i < m; i++) {
            points[i] = new Point(vect[2*i], vect[2*i + 1]);
        }
    }

    public void showPolygon(){
        for (Point p : points) {
            System.out.println(p);
        }
    }
}
