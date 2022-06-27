import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemNotFoundException;
import java.util.Scanner;

public class Password {
   public String UsernamePassword(){
      Scanner sc=new Scanner(System.in);
      System.out.println("----------------------------------------------------");
      System.out.print("Username:");
      String username=sc.nextLine();
      System.out.print("Password:");
      String password=sc.nextLine();
      String t=username+","+password;
      return t;
   }
    public void passowrdUsername(String d)throws FileNotFoundException{
   File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\passwordUsername.txt");
   boolean x=false;
   Scanner fsc=new Scanner(f);
     if(d.contains("CEO")){
      String[] l=UsernamePassword().split(",");
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=t.split(",");
            if(ceo[1].contains(l[0])){
               System.out.println("true");
               return;
          }
      }
   }
     else if(d.contains("Manager")){
      String[] l=UsernamePassword().split(",");
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=t.split(",");
          if(ceo[0].contains(l[0])){
            System.out.println("true");
            return;

          }
      }
   
     }
     else if(d.contains("Employee")){
      String[] l=UsernamePassword().split(",");
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=t.split(",");
          if(ceo[0].contains(l[0])){
            System.out.println("true");
            return;
          }
      }
     }
     else{
        System.out.println("----------------------------------------------------");
        System.out.println(""+"|" +"                 "+"ERROR "+"                     "+ "      "+"|");
        System.out.println("----------------------------------------------------");
       
     }
     System.out.println("false");
    }
    
    public static void main(String[] args)throws FileNotFoundException{
      Password p=new Password();
      p.passowrdUsername("Manager");
    }
}
