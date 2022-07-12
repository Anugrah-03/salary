import java.io.*;
import java.util.*;

public class binarytree{
  static Node root;
  public static class Node {
    int data;
    Node left;
    Node right;
    String[] Employee;
    Node(int data,String[] Employee,Node left,Node right){
        this.data=data;
        this.Employee=Employee;
        this.left=left;
        this.right=right;
    }
  }

  public static class Pair {
    Node node;
    int state;

    Pair(Node node, int state) {
      this.node = node;
      this.state = state;
    }
  }
  public static void displaydata(String data,Node node) {
    if(node==null){
      return;
    }
    if (data.equals(node.Employee[1])) {
      System.out.println(data);
      String[] t=node.Employee;
      String st="|";

      for(int i=0;i<6;i++){
        st=st+" "+t[i]+" "+"|";
      }
      System.out.println("------------------------------------------");
      System.out.println(st);
      System.out.println("-------------------------------------------");
      return;
    }
  
    displaydata(data,node.left);
    displaydata(data,node.right);
  }
  public static Node construct(Integer[] arr) throws FileNotFoundException{
    File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\salary.txt");
    Scanner sc1=new Scanner(f);
    String s=sc1.nextLine();
    String[] ceo=s.split(",");

  root = new Node(arr[0],ceo, null, null);
   Pair rtp = new Pair(root, 1);

    Stack<Pair> st = new Stack<>();
    st.push(rtp);

    int idx = 0;
    while (st.size() > 0) {
      Pair top = st.peek();
      if (top.state == 1) {
        idx++;
        if (arr[idx] != null) {
          String s2=sc1.nextLine();
          String[] m1=s2.split(",");
         top.node.left = new Node(arr[idx],m1, null, null);
          Pair lp = new Pair(top.node.left, 1);
          st.push(lp);
        } else {
          top.node.left = null;
        }
        top.state++;
      } else if (top.state == 2) {
        idx++;
        if (arr[idx] != null) {
          String s2=sc1.nextLine();
          String[] m1=s2.split(",");
          top.node.right = new Node(arr[idx],m1, null, null);
          Pair rp = new Pair(top.node.right, 1);
          st.push(rp);
        } else {
          top.node.right = null;
        }
        top.state++;
      } else {
        st.pop();
      }
    }
    sc1.close();
    return root;
  }

  public static void editSalary(String data,Node node) {

    if(node==null){
      return;
    }
    if (data.equals(node.Employee[1])) {
      System.out.println(node.Employee[1]);
      Scanner sc1=new Scanner("System.in");
      String[] t=node.Employee;
      System.out.println("Bonus%");
      System.out.println("------");
      System.out.println("|"+t[5]+"|");
      System.out.println("------");
      int d=((Integer.parseInt(t[5]))/Integer.parseInt(t[2]))*100;
      boolean tt=false;
      while(tt!=true){
      int salary=sc1.nextInt();
      if(salary<=d){
        d=salary;
        System.out.println("Salary this Month");
      System.out.println("------");
      System.out.println("|"+d+"|");
      System.out.println("------");
      tt=true;
      }
      else{
        System.out.println("Invalid Salary is greater than Bonus");
      }
    }
      return;
    }
  
    editSalary(data,node.left);
    editSalary(data,node.right);

  }
  public static void displaysalarydata(String data,Node node) {
    if(node==null){
      return;
    }
    if (data.equals(node.Employee[1])) {
      System.out.println(data);
      String[] t=node.Employee;
      String st="|";
        st=st+" "+t[2]+" "+"|"+" "+t[4]+" "+"|";
      
      System.out.println("-------------------");
      System.out.println(st);
      System.out.println("-------------------");
      return;
    }
  
    displaysalarydata(data,node.left);
    displaysalarydata(data,node.right);
  }
  
  public static void main(String[] args)throws FileNotFoundException{
    Integer[] arr={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
    construct(arr);
   //Password p=new Password();
    /*System.out.println("----------------------------------------------------");
    System.out.println(""+"|" +"             "+"Salary" +" "+"MENU"+"                           "+"|"+ " ");
    System.out.println("----------------------------------------------------");
    System.out.println("Enter your designation");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.CEO");
    System.out.println("----------------------------------------------------");
    Scanner sc=new Scanner(System.in);
    System.out.print("Designation:");
    String st=sc.nextLine();*/
   //String[] tds= p.passowrdUsername(st);
   // sc.close();
   Scanner sc1=new Scanner(System.in);
   String[] tds={"CEO","Anugrah","true"};
   if(tds[0].contains("CEO")&&tds[2]=="true"){
    System.out.println("----------------------------------");
    System.out.println("              "+"MENU"+"             ");
    System.out.println("Display salary and details --> 1");
    System.out.println("Display salary  of subordinates --> 2");
    System.out.println("Bonus salary for subordinates --> 3");
    System.out.println("Which option you want to acess?");
    String display=sc1.next();
    if(display.contains("1")){
      displaydata( tds[1],root);
    }
    else if(display.contains("2")){
      System.out.println("Enter the name of the employee");
      String name=sc1.next();
      displaysalarydata(name,root);

    }
    else if(display.contains("3")){
      System.out.println("Enter the name of the employee");
      String name=sc1.next();
      editSalary(name,root);
    }

    else{
      System.out.println("Invalid option");
    }
    sc1.close();
   }
  }
}