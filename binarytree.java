import java.io.*;
import java.util.*;

public class binarytree{
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
  /*public static void display(Node node) {
    if (node == null) {
      return;
    }

    String str = "";
    str += node.left == null ? "." : node.left.data + "";
    str += " <- " + node.data + " -> ";
    str += node.right == null ? "." : node.right.data + "";
    System.out.println(str);

    display(node.left);
    display(node.right);

  }*/
  public static String displaydataEmployee(Node node) {
    String[] t=node.Employee;
    String st="";
    for(int i=0;i<4;i++){
      st=st+t[i];
      
    }
    return st;
  }
  public static void displaydata(Node node) {
    if (node == null) {
      return;
    }
    String[] t=node.Employee;
    String st="";
    for(int i=0;i<4;i++){
      st=st+t[i];
    }
   
  

    displaydata(node.left);
    displaydata(node.right);
  }
  public static Node construct(Integer[] arr) throws FileNotFoundException{
    File f=new File("C:\\Users\\anugr\\Desktop\\Project DSA\\salary.txt");
    Scanner sc=new Scanner(f);
    String s=sc.nextLine();
    String[] ceo=s.split(",");
    /*for(int i=0;i<4;i++){
      System.out.println(ceo[i]);
    }*/

  Node root = new Node(arr[0],ceo, null, null);
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
          /*System.out.println(arr[idx]);
          for(int i=0;i<4;i++){
            System.out.print(m1[i]);
          }*/
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
          /*System.out.println(arr[idx]);
          for(int i=0;i<4;i++){
            System.out.print(m1[i]);
          }*/
        } else {
          top.node.right = null;
        }
        top.state++;
      } else {
        st.pop();
      }
    }
    return root;
  }
  public static void main(String[] args)throws FileNotFoundException {
    Integer[] arr={1,2,4,null,null,5,null,null,3,6,null,null,7,null,null};

    Node t=construct(arr);
    System.out.println(t.data);
    String[] ts=t.Employee;
    String st="";
    for(int i=0;i<4;i++){
      st=st+ts[i];
    }
    System.out.println(st);
   
  }
}