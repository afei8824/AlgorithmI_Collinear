/*************************************************************************
 * Name: Pengfei Zheng
 * Email: afei8824@gmail.com
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SLOPE_ORDER(this);
    
    private static class SLOPE_ORDER implements Comparator<Point>{
        Point invokingPoint;
        SLOPE_ORDER(Point P){
            invokingPoint = P;
        }
        public int compare(Point A, Point B){
            if(invokingPoint.slopeTo(B) > invokingPoint.slopeTo(A)) return 1;
            if(invokingPoint.slopeTo(B) == invokingPoint.slopeTo(A)) return 0;
            return -1;
        }
    }

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if(that.x == this.x){
            if(that.y == this.y)
                return Double.NEGATIVE_INFINITY;
            else
                return Double.POSITIVE_INFINITY;
        }
        else
            return (1.0*(that.y - this.y)) / (1.0* (that.x - this.x));
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y){
            return -1;
        }
        else if (this.y == that.y){
            if( this.x < that. x)
                return -1;
            else if(this.x  == that.x)
                return 0;
        }
        return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        Point A = new Point(0,0);
        Point B = new Point(0,1);
        Point C = new Point(1,0);
        StdOut.println(A.slopeTo(C));
        StdOut.println(A.SLOPE_ORDER.compare(C,B));
    }
}
