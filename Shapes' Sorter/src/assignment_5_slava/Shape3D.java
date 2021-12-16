/*

      File:  Shape3D.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the Shape3D class. It is an abstract class that is 
      designed to be inherited by other classes, specifically Shapes.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

/**
 * This is an abstract class with mostly abstract methods. It acts as a
 * blueprint for classes of shapes, the only method that is concrete is the
 * distance method that takes values from Point3D.
 *
 * @author Slava
 */
abstract public class Shape3D implements Comparable {

    private Point3D point; //Object of Point3D class
    private double distance; //Value of distance

    /**
     * The constructor initializes the object of Point3D class with the center
     * values taken from shapes.
     *
     * @param x value of a point
     * @param y value of a point
     * @param z value of a point
     */
    public Shape3D(int x, int y, int z) {
        point = new Point3D(x, y, z);

    }

    /**
     * Area method to be overwritten by child classes
     *
     * @return area after calculations
     */
    public abstract double Area();

    /**
     * Volume method to be overwritten by child classes
     *
     * @return volume after calculations
     */
    public abstract double Volume();

    /**
     * Name method to be overwritten by child classes.
     *
     * @return name
     */
    public abstract String GetName();

    /**
     * Method that calculates the distance between the center of the shapes and
     * the origin point. It takes values from Point3D class.
     *
     * @return distance
     */
    public double Distance() {
        //Calculates the distance
     distance = Math.sqrt((point.Get_X_Value() - 0) * (point.Get_X_Value() - 0)
                + (point.Get_Y_Value() - 0) * (point.Get_Y_Value() - 0)
                + (point.Get_Z_Value() - 0) * (point.Get_Z_Value() - 0));
        return distance;
    }

    /**
     * Overwrites the toString method to return the toString method of Point3D
     *
     * @return Point3D's to string method
     */
    @Override
    public String toString() {
        return point.toString();
    }

}
