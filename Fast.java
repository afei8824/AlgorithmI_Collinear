import java.io.*;
import java.util.*;
public class Fast{
    public static void main(String[] args){
        String line;
        int numPoint  = 0;
        Point[] points = null;
        Point[] pointsInvariant = null;
        int index = 0;
        try{
            FileInputStream fis = new FileInputStream(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            numPoint = Integer.parseInt(br.readLine());
            points = new Point[numPoint];
            pointsInvariant = new Point[numPoint];
            int i = 1;
            while ((line = br.readLine()) != null) {
               line = line.trim();
               String[] xAndY = line.split("\\s+");
               Point newPoint = new Point(Integer.parseInt(xAndY[0]), Integer.parseInt(xAndY[1]));
               points[index] = newPoint;
               pointsInvariant[index] = newPoint;
               index++;
               i++;
            }        
        }
        catch(IOException e){
            StdOut.println("No input file");
        }

        StdDraw.setXscale(0,32768);
        StdDraw.setYscale(0,32768);
        int segment = 1;
        for (int i = 0; i < pointsInvariant.length; i++ ){
            Point p = pointsInvariant[i];
            Arrays.sort(points,p.SLOPE_ORDER);
            for (int j = 0; j < points.length - 1; j = j + segment){
                segment = 1;
                double slope = points[j].slopeTo(p);
                for(int k = j+1; k < points.length - 1; k++){
                    if (points[k].slopeTo(p) != slope){
                        break;
                    }
                    segment ++;
                }
                if(segment >= 4){
                    StdOut.println("GOT");
                }
            }        
        }

    }
}