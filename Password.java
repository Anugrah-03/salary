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
      System.out.println(t);
      return t;
   }
    public boolean ude(String d)throws FileNotFoundException{
   File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\passwordUsername.txt");
   boolean x=false;
   Scanner fsc=new Scanner(f);
     if(d=="CEO"){
      String[] l=UsernamePassword().split(",");
      System.out.println(l[0]);
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=UsernamePassword().split(",");
            if(ceo[1]==l[0]){
               x=true;
               break;

          }
      }
   }
     else if(d=="Manager"){
      String[] l=UsernamePassword().split(",");
      System.out.println(l[0]);
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=t.split(",");
          if(ceo[0].contains("Manager1")){
            x=true;
            break;
            

          }
      }
   
     }
     else if(d.contains("Employee")){
      String[] l=UsernamePassword().split(",");
      while(fsc.hasNextLine()){
         String t=fsc.nextLine();
         String[] ceo=UsernamePassword().split(",");
          if(t=="CEO"){
               x=true;
          }
      }
     }
     else{
        System.out.println("----------------------------------------------------");
        System.out.println(""+"|" +"             "+"ERROR "+"                          ");
        System.out.println("----------------------------------------------------");
        x=false;
     }
     return x;
    }
    
    public static void main(String[] args)throws FileNotFoundException{
      Password p=new Password();
        System.out.println(p.ude("Manager"));
    }
}
