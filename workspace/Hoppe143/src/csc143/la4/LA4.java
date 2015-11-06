package csc143.la4;
import csc143.la4.temp.*;
import csc143.la4.string.Double;

/**
 * A simple class that uses classes in named packages.
 */
public class LA4 {

   /**
    * A program that prints out a temperature conversion table
    * @param args The command-line arguments
    */
   public static void main(String[] args) {
   
      // print out header
      System.out.println("Celsius  Fahrenheit");
      
      // Hold on to values with arrays
      double[] celsius = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
      double[] fahrenheit = new double[11];
      double[] secondFahrenheit = {32, 52, 72, 92, 112, 132, 152, 172, 192, 212};
      double[] convertedCelsius = new double[10];
      
      //first output table
      for (int i = 0; i < 11; i++) {
          fahrenheit[i] = Converter.c2f(celsius[i]);
          System.out.println(Double.format1(celsius[i]) + Double.format3(fahrenheit[i]));
      }
      
      //header for next table
      System.out.println();
      System.out.println("Fahrenheit  Celsius");
      
      //second output table
      for (int j = 0; j < 10; j++) {
          convertedCelsius[j] = Converter.f2c(secondFahrenheit[j]);
          System.out.println(Double.format1(secondFahrenheit[j]) + Double.format3(convertedCelsius[j]));
      }
   }
   
}