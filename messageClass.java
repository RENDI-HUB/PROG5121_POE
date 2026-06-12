/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.progpoe;


import static com.mycompany.progpoe.ProgPoe.cellPhoneNumber;
import static com.mycompany.progpoe.ProgPoe.choice;
import static com.mycompany.progpoe.ProgPoe.message;
import static com.mycompany.progpoe.ProgPoe.messageHash;
import static com.mycompany.progpoe.ProgPoe.messageID;
import static com.mycompany.progpoe.ProgPoe.numberMessages;
import static com.mycompany.progpoe.ProgPoe.recipientCell;
import static com.mycompany.progpoe.login.checkCellPhoneNumber;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;
import org.json.simple.JSONArray;
import  org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.*;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author luvhi
 */
public class messageClass {
    public static boolean valid;

   
  
    
  public void messageClass(){
      login login = new login();
     
        }
  public static boolean checkMessageID(){
  return messageID.length() <= 10;}
  
 

  public static String checkRecipientCell(String recipientCell){
       
     if (recipientCell==null){
         return "invalid";
     }
     if (recipientCell.contains("+27")&& recipientCell.length()==12){
         return recipientCell;
     }else {
         return "invalid";
     }
 }
  
  
  
  
  

  
  public static int count =0;
  static int total;
  public static String sentMessages(int numberMessages){
   Scanner scanner = new Scanner(System.in);
   String status = null;
     
                  
      for (int i =0 ; i<numberMessages;i++){
        System.out.println("1.send message");
        System.out.println("2.disregard message");
        System.out.println("3.store message to send later");
              choice= scanner.nextInt();
                    returnTotalMessages(choice);
              
              
                    switch(choice){
                        
                        
                     
                    
                        case 1: 
                         status="message Successfully sent";
                    
                           
                        
                           if (message.length()>250){
                             System.out.println("please enter a message of less than 250 characters");
                         }
                            System.out.println("message Successfully sent");
                            return "message successfully sent";
                        
                            
                        case 2:
                           status ="press 0 to delete the message";
                            System.out.println("press 0 to delete the message");
                            String delete=scanner.nextLine();
                            return "press 0 to delete the message";
                        
                        
                        case 3:
                            
                            status="message successfully stored";
                            System.out.println("message successfully stored");
                            
                    
                            return "message successfully stored";
                        
                         
                    }
       
      
      return "invalid choice";
      
  }
        return status;
  
}
  
  
  
  public static int returnTotalMessages(int Choice){
     
              if (choice==1){
                  
                        count=count+1;
                    }
         System.out.println("number of messages sent: "+count);
             return count;}
  
public static String ID;
public static String second;
public static String hashmessage;
  public static String createMessageHash(StringBuilder messageID,int numberMessages, String message){
   String beginningWord="";
    String  endWord="";
    
      StringBuilder messageHash=new StringBuilder();
       ID = messageID.toString();
   String first =ID.substring(0,2);
  second =String.valueOf(count);
  
      
      String[] text= message.trim().trim().split("\\s+");
      
if (text.length>0){
   beginningWord = text[0];
   endWord=text[text.length-1];
}
     
   
      
      
     
       
      messageHash.append(first);
      messageHash.append(":");
      messageHash.append(second);
      messageHash.append(":");
      messageHash.append(beginningWord);
      messageHash.append(endWord);
      
        hashmessage=messageHash.toString();
       
  return hashmessage;}
 
  
  public static JSONArray readMessages(String fileName){
      
      JSONParser parser= new JSONParser();
      try(java.io.FileReader reader = new java.io.FileReader(fileName)){
                                    
                             return(JSONArray)parser.parse(reader);   } catch (Exception e) {
           
  }
          
   return new JSONArray();}
  

public static void storeMessages(String fileName,String ID,String second,String recipientCell, String message,String hashmessage) {
  JSONObject newObj = new JSONObject();
    
   newObj.put("messageID",ID); 
     newObj.put("numberMessages",second);
              newObj.put("recipientCell",recipientCell);
                       newObj.put("message",message);
                                newObj.put("messageHash",hashmessage);
                      
                                
        JSONArray existingMessages =readMessages("message.json");
        existingMessages.add(newObj);
                                        
   
   try(java.io.FileWriter fileWriter= new java.io.FileWriter("message.json")){
      fileWriter.write(existingMessages.toJSONString());
      fileWriter.flush();
   }
   catch (java.io.IOException e) {
      System.err.println("error saving message to file: " + e.getMessage());
   }
}public static void clearJsonFile(String fileName) {
    try {
        java.io.File file = new java.io.File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("already Existing " + fileName + " cleared,okay to run again.");
            } else {
                System.err.println("did  not clear" + fileName);
            }
        }
    } catch (Exception e) {
        System.err.println("Error while clearing file: " + e.getMessage());
    }
}
    
   
}
    
    

    
        
