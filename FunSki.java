public class FunSki 
{ 
	private static BinaryNode left_NxtGen;
	private static BinaryNode right_NxtGen;
	
	private static BinaryNode n_Node;
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		BinaryNode relative = tree.getRoot();
		
		int var = 0;
		int space = 0;
		
		int l_Weight = relative.getLeftWeight();
		int r_Weight = relative.getRightWeight();
		
		String[] array = new String[150005000]; //needs to be more efficient but cannot implement for some reason
		BinaryNode parent = relative;
		
		while (relative.getLeftWeight() > 0 || relative.getRightWeight() > 0)
		{
			if ((l_Weight - r_Weight) > 0)
			{
				var += l_Weight;
				n_Node = relative.getLeftChild();
				relative = n_Node;
				
				l_Weight = relative.getLeftWeight();
				r_Weight = relative.getRightWeight();
				
				right_NxtGen = relative.getRightChild();
				left_NxtGen = relative.getLeftChild();
								
				array[space] = "Node: " + relative.getLabel();
				++space;
			}
			
//			if ((l_Weight - r_Weight) >= 1)
//			{
//				var += r_Weight;
//				n_Node = parent.getLeftChild();
//				relative = n_Node;
//				
//				left_NxtGen = relative.getLeftChild();
//				++space;
//				
//				r_Weight = relative.getRightWeight();
//				l_Weight = relative.getLeftWeight();
//				
//				
//				array[space] = "Node: " + relative.getLabel();
//				++space;
//			}
			else //((l_Weight - r_Weight) < 0)
			{
				var += r_Weight;
				n_Node = relative.getRightChild();
				relative = n_Node;
				
				l_Weight = relative.getLeftWeight();
				r_Weight = relative.getRightWeight();
				
				right_NxtGen = relative.getRightChild();
				left_NxtGen = relative.getLeftChild();
					
				array[space] = "Node: " + relative.getLabel();
				++space;
			}
		}
		
		System.out.println("Largest Funness: " + var);
		System.out.println(parent);
		for (int x = 0; x < space; ++x)
		{
			System.out.println(array[x]);
		}
	}
	
//	public static void print()
//	{
//		System.out.println("Largest Funness: " + var);
//		System.out.println(parent);
//		for (int x = 0; x < space; ++x)
//		{
//			System.out.println(arraysLn[x]);
//		}
//	}
}


