//Spiral order traversal in binary tree
import java.util.Scanner;
class Node
{
   int data;
   Node left,right;
   Node()
   {
     data = 0;
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
     data =n;
   }
   public int getData()
   {
      return data;
   }
   public void setLeft(Node n)
   {
      left =n;
   }
   public Node getLeft()
   {
      return left;
   }
   public void setRight(Node n)
   {
      right =n;
   }
   public Node getRight()
   {
      return right;
   }
}
class BST
{
   Node root;
   boolean left,right;
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
     if(r == null)
	 {
	   r = new Node(n);
	 }
	 else
	 {
	    if(n<=r.getData())
		   r.left = insert(r.left,n);
		else
		   r.right = insert(r.right,n);
	 }
	 return r;
   }
   public void printLevel(Node r , int level,boolean f)
   {
	  
      if(r == null)
	    return ;
	  if(level == 1)
	  {
	    System.out.print(r.data+" , ");
	  }
	  if(!f)
	  {
	   printLevel(r.left,level-1,f);
	   printLevel(r.right,level-1,f);
	  }
     else
      {
	    printLevel(r.right,level-1,f);
	    printLevel(r.left,level-1,f);
	  }	 
   }
   public int height(Node r)
   {
	   if(r==null)
		   return 0;
	   else
	   {
		   return 1+Math.max(height(r.left),height(r.right));		   
	   }
   }
   public void spiralOrderTraversal(Node r)
   {
      int h = height(root);
	  int i;
	  boolean f = false;
	  for(i=1;i<=h;i++)
	  {
		  printLevel(root,i,f);
		  f = !f;
	  }
   }
}
class SpiralOrderTrav
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
	  System.out.println();
	b.spiralOrderTraversal(b.root);
  }
}