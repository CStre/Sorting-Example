import java.util.Scanner;
import java.util.ArrayList; // This is a dynamic array (an array the expands when needed)

public class FormingTeams {
	private static int n; // The number of nodes
	private static int m; // The number of edges
	
	public static int [][] Team;
	public static boolean possible = true;


	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		n = kb.nextInt();
		m = kb.nextInt();

		// An adjacency list is an array of arrays (or array of ArrayList objects)
		ArrayList<Integer> [] adjacency_list = new ArrayList[n+1];
		for (int i = 0; i < n+1; ++i)
			adjacency_list[i] = new ArrayList<Integer>();

		// Read the edges and build the adjacency list. adjacency_list[x] contains the neighbor of x.
		for (int i = 0; i < m; ++i) {
			int a = kb.nextInt();
			int b = kb.nextInt();

			adjacency_list[a].add(new Integer(b));
			adjacency_list[b].add(new Integer(a));
		}
		// adjacency_list[x] contains the neighbors of x. You can iterate through them as...
		// for (Integer y: adjacency_list[x]) {
		//   y is a neighbor of x. But it is an Integer object.
		//   int z = y.intValue() is the neighbor, which is of type int.
		//   ...
 		//}

		// TODO: Code to form teams using depth-first search
		
		Team = new int[n + 1][3]; 
		
		for (int i = 0; i < (n + 1); ++i)
		{
			for (int j = 0; j < 3; ++j)
			{
				 Team[i][j] = 0;
			}
		}
		
		int h = 1;
		Team[h][h] = 1;
		int a = 0;
		for (a = 0; a < n + 1; ++a) 
		{
//			if (Team[b][a] == 0)
//			{
//				if ((Team[a][2] != 1) && (Team[b][a] == 0))
//				{
//					Team[a][2] = 0;
//				}
//			}
			for (Integer y: adjacency_list[a])
			{
				int b = y.intValue();
				if (Team[a][1] == 1)
				{
					if ((Team[b][2] != 1) && (Team[b][1] == 0))
					{
						Team[b][2] = 1;
					}
				}
//		Could possibly be doing this right. Come back to look at it later. Needs to check each of the poss
				else if ((Team[a][1] == 0) && (Team[b][2] == 0))
				{ 
					Team[b][1] = 1;
				}
//				else if ((Team[b][1] == 0) && (Team[a][2] == 0))
//				{ 
//					Team[b][1] = 0;
//				}
				else if (Team[a][2] == 1)
				{
					if ((Team[b][1] != 1) && (Team[b][2] == 0))
					{
						Team[b][1] = 1;
					}
				}
			}
//			if ((Team[b][1] != 1) && (Team[b][2] == 0))
//			{
//				Team[b][1] = 1;
//			}
		}
		
//		int [] array = new int[a + 1];
//		for (int j = 1; j < a; ++j)
//		{
//			if (Team[j][1] == 1 || Team[j][2])
//			{
//				array[j] = 1;
//			}
//			else if (Team[j][2] == 1)
//			{
//				array[j] = 2;
//			}
//			else
//			{
//				System.out.println("impossible");
//			}
//		}
		
		int [] array = new int[a + 1];
		for (int j = 1; j < a; ++j)
		{
			if (Team[j][1] == 1 || Team[j][2] == 1)
			{
				if (Team[j][1] == 1)
				{
					array[j] = 1;
				}
				else
					array[j] = 2;
			}
			else
			{
				possible = false;
				System.out.print("impossible");
			}
		}
		
		if (possible == true)
		{
			for (int i = 1; i < a; ++i)
			{
				System.out.print(array[i] + " ");
			}
			System.out.println();
		}
		else
			System.out.println();
	}
}




