/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoe;

import static com.mycompany.progpoe.ProgPoe.cellPhoneNumber;

import static com.mycompany.progpoe.ProgPoe.name;
import static com.mycompany.progpoe.ProgPoe.option;
import static com.mycompany.progpoe.ProgPoe.password;
import static com.mycompany.progpoe.ProgPoe.passwordLogin;
import static com.mycompany.progpoe.ProgPoe.surname;
import static com.mycompany.progpoe.ProgPoe.userName;
import static com.mycompany.progpoe.ProgPoe.usernameLogin;
import static com.mycompany.progpoe.messageClass.checkRecipientCell;
import static com.mycompany.progpoe.messageClass.count;
import static com.mycompany.progpoe.messageClass.createMessageHash;
import static com.mycompany.progpoe.messageClass.returnTotalMessages;
import static com.mycompany.progpoe.messageClass.sentMessages;
import static com.mycompany.progpoe.messageClass.valid;
import java.util.Scanner;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 *
 * @author luvhi
 */
public class login {
  
   
       
        Scanner scanner = new Scanner(System.in);
        
      public static boolean checkUserName(String userName){    
      while(!userName.contains("_") || ( userName.length()>5 || userName.length()<2) ){
        return false;
        
        }
        return true;
        }
        
         public static boolean checkPasswordComplexity(String password){

     char ch;
    
    // 
    
        boolean hasUpper = false;
        boolean hasNum = false;
        boolean hasSpecial = false;
         for (int i = 0; i < password.length(); i++){
       ch = password.charAt(i);
         if (Character.isDigit(ch)){
          hasNum = true;}
         if(Character.isUpperCase(password.charAt(i))){
     hasUpper = true;}
        if (!Character.isLetterOrDigit(ch)){
            hasSpecial = true;
            
          
    }     
  } 
            
  while ((password.length() <7) || (!hasNum) || (!hasUpper) || (!hasSpecial)||password==null ) {
     
  
  hasUpper = false;
   hasNum = false;
   hasSpecial = false;
   for (int i = 0; i < password.length(); i++){
       ch = password.charAt(i);
        if (Character.isDigit(ch)){
          hasNum = true;
        }
        else if(Character.isUpperCase(password.charAt(i))){
     hasUpper = true;
    }   if (!Character.isLetterOrDigit(ch)){
            hasSpecial = true;
        }    
     return false;   
  } 
}
        return true;
}
          
        public static boolean checkCellPhoneNumber(String cellPhoneNumber ){
            
        String regex = "^\\+27[0-9]{9}$";
        Pattern pattern = Pattern.compile(regex);
        
     
        Matcher matcher = pattern.matcher(cellPhoneNumber);
        
        while (!matcher.matches()){
            
            return false;
        } 
       return true;
        }    
        
       
        public static String registerUser(){
            
      while(!checkUserName(userName)){
          System.out.println("username is not correctly formatted. please ensure your username contains an underscore and is no more that 5 charecters in length.");
     return  "void";
      } 
                   
            if (!checkPasswordComplexity(password)){
          System.out.println("password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter , a number , and a special character.");
          return null;
      }
            
            if (!checkCellPhoneNumber(cellPhoneNumber)){
                System.out.println("cell phone number incorrectly formatted or does not contain international code."); 
                return null;
            }else 
                

            return "void" ;}
        
        
            
       public static boolean loginUser(String usernameLogin , String passwordLogin){
        
 
        while (!usernameLogin.equals(userName) || (!passwordLogin.equals(password))){
       
      
      return false;
  }
     


   return true;}

       
     public static String returnLoginStatus(){
         
        while (!loginUser( usernameLogin , passwordLogin)){
         
            System.out.println("username or password incorrect , please try again");
         
         return "void";
       }  
    

         
return null; }
     
     
}  
     

    
