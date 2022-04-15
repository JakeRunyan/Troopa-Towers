/** This class creates and draws the path for the enemies.
 * @author Jake Runyan, Nathan Atwood
 * @version April 6th, 2022 */
package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Scanner;

public class Path
{
	// Fields to store the path and its length
	public int[] arrayX, arrayY;
	private int size;
	private double totalLength;
	private double[] segLengthArray;

	/**
	 * This constructor does the following: - It reads a number of coordinates, n,
	 * from the scanner. - It creates new array(s) (or an ArrayList) to hold the
	 * path coordinates, and stores it in the field in 'this' object. - It loops n
	 * times, each time scanning a coordinate x,y pair, creating an object to
	 * represent the coordinate (if needed), and stores the coordinate in the
	 * array(s) or ArrayList.
	 * 
	 * @param s a Scanner set up by the caller to provide a list of coordinates
	 */
	public Path(Scanner reader)
	{
		// Getting the number of coordinates to give the arrays a length.
		size = reader.nextInt();
		arrayX = new int[size];
		arrayY = new int[size];
		segLengthArray = new double[size];

		// A loop to get the coordinates and store it.
		for (int count = 0; count < size; count++)
		{
			arrayX[count] = reader.nextInt();
			arrayY[count] = reader.nextInt();
		}

		// Another loop to calculate and store the segment lengths.
		int result1 = 0, result2 = 0;
		for (int pos = 0; pos < size - 1; pos++)
		{
			// First steps of getting the distance of the current segment.
			result1 = arrayX[pos + 1] - arrayX[pos];
			Math.pow(result1, 2);
			
			result2 = arrayY[pos + 1] - arrayY[pos];
			Math.pow(result2, 2);

			// Last step of getting the distance.
			segLengthArray[pos] = Math.sqrt(Math.abs(result2 + result1));
			totalLength += segLengthArray[pos];
		}

	}

	/**
	 * Draws the current path to the screen (to wherever the graphics object points)
	 * using a highly-visible color.
	 * 
	 * @param g a graphics object
	 */
	public void drawPath(Graphics drawer)
	{
		for (int pos = 0; pos < size - 1; pos++)
		{
			drawer.setColor(Color.BLUE);
			drawer.drawLine(arrayX[pos], arrayY[pos], arrayX[pos + 1], arrayY[pos + 1]);
		}
	}

	/**
	 * Given a percentage between 0% and 100%, this method calculates the location
	 * along the path that is exactly this percentage along the path. The location
	 * is returned in a Point object (integer x and y), and the location is a screen
	 * coordinate.
	 * 
	 * If the percentage is less than 0%, the starting position is returned. If the
	 * percentage is greater than 100%, the final position is returned.
	 * 
	 * If students don't want to use Point objects, they may write or use another
	 * object to represent coordinates.
	 *
	 * Caution: Students should never directly return a Point object from a path
	 * list. It could be changed by the outside caller. Instead, always create and
	 * return a new point objects as the result from this method.
	 * 
	 * @param percentTraveled a distance along the path
	 * @return the screen coordinate of this position along the path
	 */
	public Point locatePosition(double percentTraveled)
	{
		// Total length was calculated in the constructor.
		double lengthTraveled = totalLength * percentTraveled;

		// Loop through the segments and find which one we are in and if you can subtract the length by the travel distance then do it.
		int segTracker = 0;
		double segAddition = 0.0;
		while (segAddition <= lengthTraveled && segTracker != size - 2)
		{
			segAddition += segLengthArray[segTracker]; // Add segments until the sum of the added segments is greater than the length traveled.
			segTracker++;
		}
		
		// Calculate the remaining length of the segment, and then thrown that back into a percent.
		double segLengthLeft = segAddition - lengthTraveled;
		double segPercentLeft = (segLengthLeft / segLengthArray[segTracker - 1]);
		
		// Calculating the positions of the point.
		int resultX = (int) (segPercentLeft * arrayX[segTracker-1] + (1 - segPercentLeft) * arrayX[segTracker]);
		int resultY = (int) (segPercentLeft * arrayY[segTracker-1] + (1 - segPercentLeft) * arrayY[segTracker]);
		return new Point(resultX, resultY);
	}
	

	// WE ARE GOING TO EXPIRIEMENT WITH THIS FUNCITON FROM THE PROFESSORS CODE LATER TO TRY AND MAKE OUR MARIO TRAVEL SMOOTHER ACROSS THE MAP
	// public Point locate (double percentage)
    // {
    //     // Caution: Do not return any Point object from the path.  A Point
    //     //   object can have its contents changed (such as setting x or y to 0).
    //     //   If the caller got back a reference to one of our Point
    //     //   objects, they could change x or y and screw up the path.
    //     //   Instead, in the code below I either compute new Point objects,
    //     //   or I return new points that are copies of points in our path.
               
    //     // Math is annoying when using doubles.  We need to take
    //     //   extra care.  First, make sure that the percentage
    //     //   is in the range (0.0...1.0), exclusive.  If not,
    //     //   return reasonable values.    
    //     //
    //     // If the percentage is at or before the start of the path,
    //     //   return the first path coordinate.  If the percentage is past
    //     //   the end, return the last path coordinate.
    
    //  // Note:  Most students won't have this in their solution.  I've
    //  // added it to deal with unusual situations.
        
    //  if (percentage <= 0.0) 
    //  return new Point(arrayX[1], arrayY[1]);  // Make a new Point object that copies our first point
    
    //  if (percentage >= 1.0)
    //  return new Point(arrayX[size-1], arrayY[size-1]);  // Make a new Point object that copies our last point
    //  // Convert the percentage to a distance.  This is how far along
    //  //   the path we are.  We need to find the coordinate that is at this
    //  //   distance from the start of the path.
    
    //  double distanceToTravel = totalLength * percentage;
    
    //  // Walk through the segments and keep track of the distance traveled as
    //  //   we go.  If the distance traveled is greater than or equal to
    //  //   the amount we're supposed to travel, we've found the segment that 
    //  //   we're in.
    
    //  // In the code below, I compute values in the loop I need after the loop.
    //  //   I declare my local variables before the loop (so they'll still be there
    //  //   after the loop), but they need initial values.  I give them
    //  //   somewhat arbitrary values, the code in the loop will change them.
    
    //     Point start = new Point(arrayX[1], arrayY[1]);  // Segment points for the current segment.
    //     Point end   = new Point(arrayX[2], arrayY[2]);
    //     double totalDistance = 0;   // Accumulated distance
    //     double segmentLength = 1;   // Length of the current segment.  (Wrong)    
   
    //     for (int i = 1; i < size; i++)
    //     {
    //        // Extract segment start/end points
            
    //         start = new Point(arrayX[i-1], arrayY[i-1]);  
    //         end   = new Point(arrayX[i], arrayY[i]);
    //         // Compute the length of this segment, combine it with the total.
            
    //         segmentLength = start.distance(end);    
    //         totalDistance = totalDistance + segmentLength;  // Better:  
    //         totalDistance += segmentLength;
    
    //         // If we've gone far enough (or too far), exit the loop immediately.
    
    //         if (totalDistance >= distanceToTravel)
    //         	break;        
    //     }
   
    // // Consider the current segment, not the entire path.  The distance we are
    //     //   seeking is in this segment somewhere.  Calculate how much too far
    //     //   the end of the segment is.  Then, see what percentage of this segment
    //     //   the excess distance is.  
    //     //
    //     // Since the distanceToTravel is no greater than totalDistance, the
    //     //   result will be non-negative.
   
	// double excessDistance    = totalDistance - distanceToTravel;
    // double segmentPercentage = excessDistance / segmentLength;   // Will be between [0..1]
    //  // We know that the target coordinate is some segmentPercentage from the segment end,
    //  //   and (1 - segmentPercentage) from the segment start.  Use these to compute a
    //  //   weighted average of the start and end points.  I've broken this
    //  //   code into separate lines for clarity.
    //  //
    //  // Remember, if we're 0% from the end, we're at the end, so include 100% of the end.
    //  //   (Vice versa for the start.)
    
    // double targetX = (segmentPercentage)*start.x + (1-segmentPercentage)*end.x;
    // double targetY = (segmentPercentage)*start.y + (1-segmentPercentage)*end.y;
    
    // Point result = new Point ((int) targetX, (int) targetY);
    
    //  // Done, return the coordinates (as a Point object).
    
    // return result;
    // }
	
	
}