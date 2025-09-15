/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectanery;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class IfStatementLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
   
 Scanner scanner=new Scanner(System.in);
 
//PROLEM 1
 System.out.println("Enter your AGE");
 int age = scanner.nextInt();
 
  if (age <= 0 ){
 System.out.println("Invalid Age" );
  } else if (age < 13) {
 System.out.println("You are a child");
  } else if (age >=13 & age <=19) { 
  System.out.println("You are a teenager");
  } else if (age >=20) {
  System.out.println("You are an adult");
  
         }
 
//PROBLEM 2

System.out.println("Enter your TEMPERATURE IN CELSIUS");
 double temperature = scanner.nextDouble();
 
  if (temperature < 0 ){
 System.out.println("Freezing point" );
  } else if (temperature >=0 & temperature <=25) {
 System.out.println("Normal Weather");
  } else if (temperature > 25) { 
  System.out.println("Hot Weather");
  }
  
  //PROBLEM 3
  System.out.println("Enter your TEST SCORE");
  int score = scanner.nextInt();

  if (score >= 90 ){
 System.out.println("Excellent");
  } else if (score >= 75 && score <=89){
 System.out.println("Good");
  } else if (score <=75) {
  System.out.println("Needs improvement");
  }
 
  //PROBLEM 4
  
  System.out.println("Enter the RADIUS OF YOUR CIRCLE");
 double radius = scanner.nextDouble();
 
  if (radius <=0) {
 System.out.println("Invalid radius");
 } else {  
      
 double area = Math.PI * radius * radius;
 double circumference = 2 * Math.PI * radius;
  
 System.out.println("area:" + area);
 System.out.println("circumference:" + circumference);
  } 
  
  //PROBLEM 5
  System.out.println("Enter an INTEGER");
  int number = scanner.nextInt();

  if (number % 2 == 0) {
 System.out.println(number + "is even.");
  } else {
 System.out.println(number + "is odd.");
  
  }
  

    }}




    
      
      
                 
  

    

