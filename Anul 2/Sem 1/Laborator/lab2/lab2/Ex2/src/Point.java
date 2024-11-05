public class Point {
    private float x, y;

    //Constructor fara parametrii
    public Point() {
        this.x = 0;
        this.y = 0;
    }

    //Constructor cu parametrii
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void changeCoords(float a, float b){
        this.x = a;
        this.y = b;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
