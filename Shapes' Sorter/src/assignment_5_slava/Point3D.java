/*

      File:  Point3D.java

      Programmer:  Viacheslav Burmistrov

      Purpose: This is the Point3D class. It acts as a strage for center points
      of Shapes. Also returns the values of those points.

      I affirm that this program is entirely my own work and none 
      of it is the work of anyone else.

 */
package assignment_5_slava;

/**
 * It acts as a storage for center points of Shapes. Also returns the values of
 * those points, individually and specific points. This class is only used by
 * Shape3D class.
 *
 * @author Slave
 */
public class Point3D {

    private int x, y, z; //Coordinates of the point
    private String xyz;

    /**
     * Constructor initializes the point value taken from Shape3D.
     *
     * @param q x point value
     * @param w y point value
     * @param e z point value
     */
    public Point3D(int q, int w, int e) {
        x = q;
        y = w;
        z = e;

    }

    /**
     * Overwrites the toString method to return value of the point center a
     * shape.
     *
     * @return string with center value
     */
    @Override
    public String toString() {
        xyz = "( " + x + " , " + y + " , " + z + " )";
        return xyz;
    }

    /**
     * Return int value of x point
     *
     * @return x point
     */
    public int Get_X_Value() {
        return x;

    }

    /**
     * Return int value of y point
     *
     * @return y point
     */
    public int Get_Y_Value() {
        return y;

    }

    /**
     * Return int value of z point
     *
     * @return z point
     */
    public int Get_Z_Value() {
        return z;

    }

}
