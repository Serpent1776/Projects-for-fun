import java.util.ArrayList;
public class Algebra {
    public double solveforX(Equation equation) {
        //solves a given equation for "x" as long it as only one variable.
        double x = 0;
        return x;
    }
    public PointList<Double> otherIntersect (Equation equation1, Equation equation2) {
        //solves for an insection or multiple insertions. For infinite points, it would seek a pattern.
        
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        PointList<Double> xy = new PointList<Double>();
        return xy;
    }
    public PointList<Double> intersect (boolean xydeterminer) {
        //solves for an insection or multiple insertions on an axis. For infinite points, it would seek a pattern.
        
        ArrayList<Double> x = new ArrayList<Double>();
        ArrayList<Double> y = new ArrayList<Double>();
        PointList<Double> xy = new PointList<Double>();
        if(xydeterminer) {
            //x axis intersections

        } else {
            //y axis intersections

        }
        return xy;
    }
    public ArrayList<ArrayList<Double>> maxMin(Equation equation) {
         ArrayList<Double> maxDoubles = new ArrayList<Double>();
         ArrayList<Double> minDoubles = new ArrayList<Double>();
         ArrayList<ArrayList<Double>> MaxMin = new ArrayList<ArrayList<Double>>();
         
         return MaxMin;
    }
    public ArrayList<Double> domain() {
        ArrayList<Double> x = new ArrayList<Double>();
        return x;
    }
    public ArrayList<Double> range() {
        ArrayList<Double> y = new ArrayList<Double>();
        return y;
    }
    public ArrayList<Double> horiAsym() {
        ArrayList<Double> x = new ArrayList<Double>();
        return x;
    }
    public ArrayList<Double> vertAsym() {
        ArrayList<Double> y = new ArrayList<Double>();
        return y;
    }
    
}
