/**
 * COSC 310 Assignment #7
 * Astro.java
 * 
 * @author Jeremiah Simplice
 */

public class Astro implements Comparable<Astro>
{
    private String name;
    private int xCoord;
    private int yCoord;
    private double distance;

    /**
     * 
     * @param name of astronomical object
     * @param xCoord of the object
     * @param yCoord the of object
     * @param distance the Euclidean distance from point of interest
     */
    public Astro(String name, int xCoord, int yCoord, double distance)
    {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
        this.distance = distance;
    }

    /**
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return the x coordinate
     */
    public int getXCoord()
    {
        return xCoord;
    }

    /**
     * @return the y coordinate
     */
    public int getYCoord()
    {
        return yCoord;
    }

    /**
     * @return the distance
     */
    public double getDistance()
    {
        return distance;
    }

    /**
     * 
     * @param other the astro object to compare
     * @return negative if this distance is less, positive if greater, zero if equal
     */
    
    @Override
    public int compareTo(Astro other)
    {
        return Double.compare(this.distance, other.distance);
    }

    /**
     * @return formatted string with name, xCoord, yCoord, and distance
     */
    @Override
    public String toString()
    {
        return String.format("%-15s %3d %3d %8.2f", name, xCoord, yCoord, distance);
    }
}
