/*

      File:  Sphere.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the shpere class. It has methods exculsive to Sphere
      and outputs values exculsive to it.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

/**
 * This class has methods for calculating the values of Sphere. Its
 * parent class is Shape3D.
 *
 * @author Slava
 */
public class Sphere extends Shape3D {

    private int radius; //Stores radius
    private String info, name; //Stores information
    private double area, volume; //Stores area and volume

    /**
     * The constructor of Sphere, initializes all of the value of the center
     * point, as well as the radius of the sphere and the name.
     *
     * @param x value of a point
     * @param y value of a point
     * @param z value of a point
     * @param r radius
     */
    public Sphere(int x, int y, int z, int r) {
        super(x, y, z); //Initializes the center
        radius = r;
        name = "Sphere";
    }

    /**
     * Overwrites the method to output, name, center and radius.
     *
     * @return the string that stores all that info
     */
    @Override
    public String toString() {
        info = name
                + "\nCoordinates of the center: " + super.toString()
                + "\nRadius: " + radius;
        return info;
    }

    /**
     * Overwrites the Area method of Shape3D class to return the area of the
     * shape.
     *
     * @return area of the sphere
     */
    @Override
    public double Area() {
        //Calculates Area
        area = (4 * Math.PI * radius * radius);
        return area;

    }

    /**
     * Overwrites the Volume method of Shape3D to return the volume of the
     * Sphere.
     *
     * @return volume of the sphere
     */
    @Override
    public double Volume() {
        //Calulates the volume
        volume = (4 * Math.PI * radius * radius * radius) / (3);
        return volume;
    }

    /**
     * Overwrites the compareTo method of the Comparable interface so that it
     * can be used to compare the volumes of the shapes.
     *
     * @param otherObject The Object of the shape that is being compared.
     * @return 1, -1 or 0 depending if volume is smaller or bigger.
     */
    @Override
    public int compareTo(Object otherObject) {
        Shape3D other = (Shape3D) otherObject;
        if (this.Volume() > other.Volume()) { //This volume is greater
            return -1;
        } else if (this.Volume() < other.Volume()) { //This volume is less
            return 1;
        } else // they are equal
        {
            return 0;
        }

    }

    /**
     * Overwrites the GetName method of Shape3D class to out put the name of the
     * shape.
     *
     * @return name of the class
     */
    @Override
    public String GetName() {
        return name;
    }
}
