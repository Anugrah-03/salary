import java.util.Stack;
class node{
    int data;
    node left, right;
    String[] Employee;
    node(int data,String[] Employee,node left,node right){
        this.data=data;
        this.Employee=Employee;
        this.left=left;
        this.right=right;
    }
}
public class binarytree {
     
    public static class pair{
        node n;
        int state;
        pair(node n,int state){
            this.n=n;
            this.state=state;
        }
    }
    public static void main(String[] args) {
     Integer [] arr={1,2,4,null,null,5,null,null,null,3,6,null,null,7,null,null};
     String[] Employee=new String[5];
     /*for(int i=0;i<Employee.length;i++){
         Employee[i]=sc.next();
    }*/
    node root =new node(arr[0],Employee, null, null);
    pair p=new pair(root, 1);
     Stack<pair> st=new Stack<>();
     st.push(p);
    }
    
}