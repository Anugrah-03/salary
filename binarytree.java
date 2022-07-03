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
    System.out.println("alol");
    if (data == node.Employee[0]) {
      String[] t=node.Employee;
      String st="";
      for(int i=0;i<4;i++){
        st=st+" "+t[i];
      }
      
      System.out.println(st);
      return;
    }
  
    displaydata(data,node.left);
    displaydata(data,node.right);
  }
  public static Node construct(Integer[] arr) throws FileNotFoundException{
    File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\salary.txt");
    Scanner sc=new Scanner(f);
    String s=sc.nextLine();
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
          String s2=sc.nextLine();
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
          String s2=sc.nextLine();
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
    sc.close();
    return root;
  }

  public static void main(String[] args)throws FileNotFoundException {
    Integer[] arr={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};
    construct(arr);
   Password p=new Password();
    System.out.println("----------------------------------------------------");
    System.out.println(""+"|" +"             "+"Salary" +" "+"MENU"+"                           "+"|"+ " ");
    System.out.println("----------------------------------------------------");
    System.out.println("Enter your designation");
    System.out.println("1.Employee");
    System.out.println("2.Manager");
    System.out.println("3.CEO");
    System.out.println("----------------------------------------------------");
    Scanner sc=new Scanner(System.in);
    System.out.print("Designation:");
    String st=sc.nextLine();
   String[] td= p.passowrdUsername(st);
    if(td[1]=="true"){
      Node t=root;
       if(td[0]=="CEO"){
        System.out.println(td[0]=="CEO");
        displaydata(td[0],t);
       }
    }
  }
}