import java.io.*;
import java.util.*;
public class Brute {
    private static boolean check(Point A, Point B, Point C, Point D){
        if(A.slopeTo(B) == A.slopeTo(C) & A.slopeTo(B) == A.slopeTo(D) ){
            return true;
        }
        return false;
    
    }
    
    public static void main(String[] args){
        String line;
        int numPoint  = 0;
        Point[] points = null;
        int index = 0;
        try{
            FileInputStream fis = new FileInputStream(args[0]);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            numPoint = Integer.parseInt(br.readLine());
            points = new Point[numPoint];
            int i = 1;
            while ((line = br.readLine()) != null) {
               line = line.trim();
               String[] xAndY = line.split("\\s+");
               Point newPoint = new Point(Integer.parseInt(xAndY[0]), Integer.parseInt(xAndY[1]));
               points[index++] = newPoint;
               i++;
            }        
        }
        catch(IOException e){
            StdOut.println("No input file");
        }

        StdDraw.setXscale(0,32768);
        StdDraw.setYscale(0,32768);

        for (int i = 0; i < points.length; i++ ){

            for (int j = i+1; j < points.length; j++) {
                for (int k = j+1; k < points.length; k++){
                    for (int l = k+1; l < points.length; l++){
                        points[i].draw();
                        
                        if( check(points[i], points[j], points[k], points[l])){
                            StdOut.println(points[i]+" -> "+points[j]+" -> "+points[k]+" -> "+points[l]);
                            Point[] newLine = new Point[4];
                            newLine[0] = points[i];
                            newLine[1] = points[j];
                            newLine[2] = points[k];
                            newLine[3] = points[l];
                            Arrays.sort(newLine);
                            newLine[0].drawTo(newLine[3]);
                        }
                        
                    }
                }
            }
        }
    }
}