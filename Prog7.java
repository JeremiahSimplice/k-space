/**
 * COSC 310 Assignment #7
 * Prog7.java
 * @author Jeremiah Simplice
 */

import java.io.*;
import java.util.*;

public class Prog7
{
    /**
     * Main method that coordinates user input, file reading, and output.
     * 
     * @param args command line arguments (not used)
     */
    public static void main(String[] args)
    {
        Heap<Astro> heap = new Heap<Astro>(50);
        int x;          // x coordinate of point in space
        int y;          // y coordinate of point in space
        int k;          // number of objects desired
        Scanner scanner = new Scanner(System.in);

       
        // Get x and y coordinates of a point in space from user
        // Get number of entities k to find from user

        System.out.print("Enter x coordinate of point in space: ");
        x = scanner.nextInt();
        
        System.out.print("Enter y coordinate of point in space: ");
        y = scanner.nextInt();
        
        System.out.print("Enter number of nearest objects to find: ");
        k = scanner.nextInt();

        
        // Read astro.txt file, instantiate Astro objects,
        // and enqueue each one in the heap

        try
        {
            File file = new File("astro.txt");
            Scanner fileScanner = new Scanner(file);
            
            while (fileScanner.hasNextLine())
            {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                
                if (parts.length == 3)
                {
                    String name = parts[0].trim();
                    int xCoord = Integer.parseInt(parts[1].trim());
                    int yCoord = Integer.parseInt(parts[2].trim());
                    
                    // Calculate Euclidean distance
                    double distance = Math.sqrt(Math.pow(xCoord - x, 2) + Math.pow(yCoord - y, 2));
                    
                    // Create Astro object and enqueue
                    Astro astro = new Astro(name, xCoord, yCoord, distance);
                    heap.enqueue(astro);
                }
            }
            
            fileScanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Error: astro.txt file not found.");
            scanner.close();
            return;
        }

   
        // Print k nearest objects to (x, y)
   
        System.out.println("\n" + k + " closest objects to (" + x + ", " + y + ")");
        System.out.println();
        System.out.printf("%-15s %3s %3s %8s\n", "Name", "x", "y", "Distance");
        System.out.println("--------------- --- --- --------");
        
        for (int i = 0; i < k; i++)
        {
            Astro nearest = heap.dequeue();
            if (nearest != null)
            {
                System.out.println(nearest);
            }
            else
            {
                break;
            }
        }
        
        scanner.close();
    }
}
