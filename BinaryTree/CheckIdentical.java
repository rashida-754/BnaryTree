//Check if two binary trees are identical or not
import java.util.Scanner;
class Node
{
    int data;
    Node left,right;
   Node()
   {
     data = 0;
	 left=null;
	 right=null;
   }
   Node(int n)
   {
     data = n;
	 left = null;
	 right = null;
   }
   public void setLeft(Node n)
   {
      left = n;
   }
   public Node getLeft()
   {
      return left;
   }
   public void setRight(Node n)
   {
      right = n;
   }
   public Node getRight()
   {
      return right;
   }
   public void setData(int n)
   {
      data = n;
   }
   public int getData()
   {
      return data;
   }
}
class BST
{
  Node root;
  public BST()
  {
	  root = null;
  }
  public void insert(int n)
   {
      root = insert(root,n);
   }
   public Node insert(Node node,int n)
   {
      if(node == null)
	    node = new Node(n);
	  else
	   {
	     if(n<=node.getData())
		   node.left = insert(node.left,n);
		 else
		   node.right = insert(node.right,n);
	   }
	  return node;
   }
   public boolean check(Node x,Node y)
   {
	   if(x == null && y==null)
		   return true;
	   return (x != null && y != null) && (x.data == y.data) && check(x.left, y.left) &&
				       check(x.right, y.right);
   }
}
class CheckIdentical
{
 public static void main(String args[])
  {
   Scanner sc = new Scanner(System.in);
   BST c1 = new BST();   
   BST c2 = new BST();
   BST c3 = new BST();
   int n1,n2,i;
   System.out.println("Enter number of elements in tree 1");
   n1 = sc.nextInt();   
   System.out.println("Enter number of elements in tree 2");
   n2 = sc.nextInt();
   if(n1!=n2)
     System.out.println("Trees cannot be equivalent or identical");
   else
   {
     System.out.println("Enter elements in Tree 1");
	 for(i=0;i<n1;i++)
	   c1.insert(sc.nextInt());
	 System.out.println("Enter elements in Tree 2");
	 for(i=0;i<n1;i++)
	   c2.insert(sc.nextInt());
     if(c3.check(c1.root,c2.root))
        System.out.println("Two Trees Are Identical");
     else
        System.out.println("Two trees are not identical"); 
   }
}
}