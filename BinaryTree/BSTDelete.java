//Delete a tree
import java.util.Scanner;
class Node
{
   int data;
   Node left,right;
   Node()
   {
      data=0;
	  left = null;
	  right = null;
   }
   Node(int n)
   {
      data = n;
	  left = null;
	  right = null;
   }
   public void setData(int n)
   {
     data = n;
   }
   public int getData()
   {
      return data;
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
}
class BST
{
   Node root;
   BST()
   {
      root = null;
   }
   public void insert(int n)
   {
      root = insert(root,n);
   }
   public Node insert(Node r,int n)
   {
      if(r==null)
	    r = new Node(n);
	  else
	   {
	      if(n<=r.getData())
		    r.left = insert(r.left,n);
		  else
		    r.right = insert(r.right,n);
	   }
	  return r;
   }
   public void inorder()
   {
      inorder(root);
   }
   public void inorder(Node r)
   {
      if (r != null)
         {
             inorder(r.getLeft());
             System.out.print(r.getData() +" ");
             inorder(r.getRight());
         }
   }
   public void delete(Node r)
   {
      if(r==null)
		  return;
	  delete(r.left);
	  delete(r.right);
	  System.out.println("Deleted element is : " + r.data);
	  r = null;
	 root = null;
   }
}
class BSTDelete
{
  public static void main(String args[])
  {
    Scanner sc =new Scanner(System.in);
	int n,i;
	System.out.println("Enter number of elements:");
	n = sc.nextInt();
	BST b = new BST();
	System.out.println("Enter elements :");
	for(i=0;i<n;i++)
	  b.insert(sc.nextInt());
      b.inorder(); 
	  System.out.println();
	  b.delete(b.root);
	if(b.root==null)
		System.out.println("Tree deleted");
	else
		System.out.println("Error in logic");
	b.inorder();
  }
}