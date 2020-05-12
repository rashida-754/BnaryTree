//Reverse level order traversal left to right
import java.util.Scanner;
class Node
{
   Node left,right;
   int data;
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
   public int getData()
   {
     return data;
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
    if(r == null)
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
  public int height(Node r)
  {
    if(r==null)
	  return 0;
	return 1+Math.max(height(r.right),height(r.left));
  }
  public void reverseOrderTraversal(Node r)
  {
      int h = height(r);
	  int i;
	  for(i=h;i>0;i--)
	    printLevel(r,i);  
  }
  public void printLevel(Node r, int level)
  {
      if(r==null)
	    return;
	   if(level==1)
	     System.out.print(r.data+" ");
	   else
	      {
		     printLevel(r.left,level-1);
			 printLevel(r.right,level-1);
		  }
  }
}
class SpiralReverseOrderTrav
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
	b.reverseOrderTraversal(b.root);
  }
}