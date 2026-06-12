package com.mycompany.progpoe;
import static com.mycompany.progpoe.login.checkCellPhoneNumber;
import static com.mycompany.progpoe.login.checkPasswordComplexity;
import static com.mycompany.progpoe.login.checkUserName;
import static com.mycompany.progpoe.login.loginUser;

import static com.mycompany.progpoe.login.registerUser;
import static com.mycompany.progpoe.login.returnLoginStatus;
import static com.mycompany.progpoe.messageClass.ID;
import static com.mycompany.progpoe.messageClass.checkRecipientCell;
import static com.mycompany.progpoe.messageClass.clearJsonFile;
import static com.mycompany.progpoe.messageClass.count;
import static com.mycompany.progpoe.messageClass.createMessageHash;
import static com.mycompany.progpoe.messageClass.hashmessage;
import static com.mycompany.progpoe.messageClass.readMessages;
import static com.mycompany.progpoe.messageClass.second;
import static com.mycompany.progpoe.messageClass.sentMessages;
import static com.mycompany.progpoe.messageClass.storeMessages;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.List;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


/**
 *
 * @author luvhi
 */
//static declaratins
public class ProgPoe {
static String userName;
static String password ;
static String  name; 
static String surname ;
static String cellPhoneNumber;
static String passwordLogin;
static  String usernameLogin;
public static String recipientCell;
   public static int numberMessages;
  public static String messageID;
  public static String message;
  public static int choice;
    public static String messageHash;
public static int subOption;
public static String longestMessage;
 public static int   longestIndex;
 public static String id;
 public static String content;
 public static String recipientNum;
 public static int count;
 public static String hash2;
static int option;
static  String idCheck;       

    private static String fileName;


    public static void main(String[] args) {
      clearJsonFile("message.json");
      

         
    
   
    
    
        
        Scanner scanner = new Scanner(System.in);
        
       //register
        System.out.println("enter name: ");
       name = scanner.nextLine();
  
        System.out.println("enter surname: ");
        surname = scanner.nextLine();
        
        
       
        System.out.println("create username: ");
        System.out.println("make sure it is less than 5 characters long and contains an underscore");
        userName = scanner.nextLine(); 
        checkUserName(userName);
        while (!checkUserName(userName)){
             registerUser();
            userName = scanner.nextLine();   
             
        } System.out.println("username successfully captured");
        System.out.println("enter password: ");
        System.out.println("password should contain atleast one special character , one uppercase and should be more than eight characters long.");
        password = scanner.nextLine();
        checkPasswordComplexity(password);
     while (!checkPasswordComplexity(password)){
         registerUser();
         password = scanner.nextLine();
     } System.out.println("password successfully captured");
        
        System.out.println("enter cell phone number");
        System.out.println("cellphone number should be a valid South african number and contain the international country code.");
        cellPhoneNumber = scanner.nextLine();
        checkCellPhoneNumber(cellPhoneNumber);
        while (!checkCellPhoneNumber(cellPhoneNumber)){
            registerUser();
       cellPhoneNumber = scanner.nextLine();
        }System.out.println("cell phone number successfully added.");
       //login
         System.out.println("enter username: ");
         usernameLogin = scanner.nextLine();
         
         System.out.println("enter password: ");
         passwordLogin = scanner.nextLine(); 
    
        
        while (!loginUser(usernameLogin , passwordLogin)){
         returnLoginStatus();
         
         System.out.println("enter username: ");
         usernameLogin = scanner.nextLine();
         
         System.out.println("enter password: ");
         passwordLogin = scanner.nextLine(); 
     } System.out.println("welcome " + name +" " + surname + "  it is great to see you.");
      
    
    
System.out.println("welcome to QuickChat.");
choiceDecider();

while (option!=3){
    choiceDecider();
   
}

    }
public static int choiceDecider(){
    
    
    Scanner scanner = new Scanner(System.in);
        System.out.println("1.send messages");
        System.out.println("2.show recently sent messages");
        System.out.println("3.quit");
        System.out.println("4.stored messages");
        option = scanner.nextInt();
              
       
        
        
        switch (option){
            case 1:
                
                 System.out.println("enter recipient cell: ");
                  recipientCell= scanner.nextLine();
                  
                 recipientCell= checkRecipientCell(recipientCell);
               
                 while (recipientCell.equals("invalid")){
                     
                      System.out.println("enter recipient cell: ");
                  recipientCell= scanner.nextLine();
                   recipientCell= checkRecipientCell(recipientCell);
                 }
            
                   
                System.out.println("how many messages do you wish to enter? ");
                
                numberMessages = Integer.parseInt(scanner.nextLine());
               
                    
           
              
                System.out.println("enter message");
                message= scanner.nextLine();
                 
                   
                   
           Random newNum = new Random();
    StringBuilder messageID = new StringBuilder();
      sentMessages(numberMessages);
    
    for (int j = 0; j<10 ;j++){
      messageID.append (newNum.nextInt(10));
    }
   
   
    
     System.out.println("messageID: "+messageID);
       String hash= createMessageHash( messageID, numberMessages, message);
               
                 System.out.println(hash);
                    storeMessages("message.json", ID,second,recipientCell, message,hashmessage);
                  
                
                
              
                
                for ( int i = 0 ; i <numberMessages -1  ; i++){
                    
                  
                   
                 System.out.println("enter message: ");
                message= scanner.nextLine();
               sentMessages(numberMessages);
               
                  newNum = new Random();
     messageID = new StringBuilder();
     
    
    for (int j = 0; j<10 ;j++){
                 
                          
       messageID.append (newNum.nextInt(10));
    }   
    
        System.out.println("messageID: "+messageID);
     
                  hash=  createMessageHash( messageID, numberMessages, message);
                    System.out.println(hash);
                    storeMessages("message.json", ID, second,recipientCell, message, hashmessage);
                    
                }    
               
                
                messageClass messageClass = new messageClass();
              
               
                
                break;
               
            case 2:
                System.out.println("coming soon");
                break;
                
            case 3:
               
                break;
                
                
            case 4:
            {
                
                
                
                
                
                
                
                
                
             
         List<String> message = new ArrayList<>();
        List<String> ID = new ArrayList<>();
         List<String> hashmessage= new ArrayList<>();
     List<String> recipientCell = new ArrayList<>();
     List <Integer> numberMessages = new ArrayList<>();
     
     

   
       
        JSONArray existingMessages = readMessages("message.json");
        
     
        
        if (existingMessages != null) {
            for (Object obj : existingMessages) {
                JSONObject messageObj = (JSONObject) obj;
               
                
                 id = String.valueOf(messageObj.get("messageID"));
                content = String.valueOf(messageObj.get("message"));
                hash2 = String.valueOf(messageObj.get("messageHash"));
                recipientNum= String.valueOf(messageObj.get("recipientCell"));
                
               
                 ID.add(id);
                message.add(content);
               hashmessage.add(hash2);
               recipientCell.add(recipientNum);
               numberMessages.add(count);
            }
        }
               
              
        
    System.out.println("1.Display sender and recipient of all stored messages");
    System.out.println("2. Display the longest stored message");
    System.out.println("3. Search for a message ID");
    System.out.println("4. Search for all messages for a particular recipient");
    System.out.println("5. Delete a message using the message hash");
    System.out.println("6.Display a report of all details");
          subOption= scanner.nextInt();
    
    
    switch(subOption){
        
        case 1:
            for (int i = 0; i < message.size(); i++) {
        System.out.println("sender: " +cellPhoneNumber +" " +" recipient: " + recipientCell.get(i));
    }
    break;
        case 2:
             longestMessage=message.get(0);
             longestIndex =0;
         
         for (int i = 0; i < message.size(); i++) {
            if (message.get(i).length() > longestMessage.length()) {
                longestMessage = message.get(i);
                longestIndex = i;
            }
        }
            System.out.println("longest message: "+longestMessage);
        break;
        
        case 3:
        String searchTarget= idSearch();
                 for (int i = 0; i < ID.size(); i++) {
                    
        if (ID.get(i).trim().equals(searchTarget.trim())) {
            System.out.println("recipient: " + recipientCell.get(i) +" " + " message: " + message.get(i));
        }
    }
    break;
        
        case 4:
        
        String messageTarget =messageSearch();
          for (int i = 0; i < recipientCell.size(); i++) {
          
         if (recipientCell.get(i).trim().equals(messageTarget.trim())) {
         System.out.println( "messages: " + message.get(i));
           
    }
     }
        
        break;
       
        case 5 :
            String searchHash=hashsearch();
        JSONArray updatedMessages = new JSONArray();
    
    for (int i = 0; i < hashmessage.size(); i++) {
        if (!hashmessage.get(i).trim().equals(searchHash.trim())) {
          
            updatedMessages.add(existingMessages.get(i));
        }
    }
    
    
    writeMessages("message.json", updatedMessages);
    System.out.println("Message deleted successfully");
    break;
        
        case 6:
        
      for (int i = 0; i < message.size(); i++) {
           System.out.println("Recipient: " + recipientCell.get(i));
        System.out.println("Message ID: " + ID.get(i));
        System.out.println("Message: " + message.get(i));
        System.out.println("Message Hash: " + hashmessage.get(i));
        
    }
    break;
        
        
        
        
        
        
        
        
    
    }
            }
        return option;}  


return choice;} 

      public static String idSearch(){
            Scanner scanner=new Scanner(System.in);
            System.out.println("enter messageID");
            idCheck=scanner.nextLine();
            
       return idCheck;}
    
        public static String messageSearch(){
        Scanner scanner=new Scanner(System.in);
            System.out.println("enter recipient cell");
            String search=scanner.nextLine();    
        return search;}
    
        public static String hashsearch(){
        Scanner scanner=new Scanner(System.in);
            System.out.println("enter messageHash");
            String searchHash=scanner.nextLine();    
        return searchHash;}
        
        public static void writeMessages(String filename, JSONArray messages) {
    try (FileWriter file = new FileWriter(filename)) {
        file.write(messages.toJSONString());
        System.out.println("message  deleted");
    } catch (IOException e) {
        e.printStackTrace();
    }
}
     }
    
   
  
    
    
    





