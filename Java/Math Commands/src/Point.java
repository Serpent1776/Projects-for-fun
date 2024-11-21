public class Point implements Comparable<Point> {
    double x;
    double y;
    boolean isMaximum;
    boolean isMinimum;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.isMaximum = false;
        this.isMinimum = false;
    }
    public Point(double x, double y, boolean isMaximum, boolean isMinimum){
        this.x = x;
        this.y = y;
        this.isMaximum = isMaximum;
        this.isMinimum = isMinimum;
    }
    public int compareTo(Point other) {

        return (int)((this.x - other.x) + (this.y - other.y));
    }
    public boolean equals(Point other) {
        return this.x == other.x && this.y == other.y && this.isMaximum == other.isMaximum && this.isMinimum == other.isMinimum;
    }
    }
}

