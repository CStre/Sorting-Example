import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FunSkii {

  // define a class to store the maximum funness and path
  private static class MaxFunness {
    int funness;
    List<Integer> path;

    MaxFunness(int funness, List<Integer> path) {
      this.funness = funness;
      this.path = path;
    }
  }

  // define a function to find the maximum funness path in a subtree
  private static MaxFunness findMaxFunnessPath(BinaryNode root) {
    // base case: if the root is null, return 0 funness and an empty path
    if (root == null) {
      return new MaxFunness(0, new ArrayList<>());
    }

    // get the maximum funness paths in the left and right subtrees
    MaxFunness leftMax = findMaxFunnessPath(root.getLeftChild());
    MaxFunness rightMax = findMaxFunnessPath(root.getRightChild());

    // get the maximum funness and path from the left and right subtrees
    int leftFunness = leftMax.funness;
    int leftWeight = root.getLeftWeight();
    List<Integer> leftPath = leftMax.path;

    int rightFunness = rightMax.funness;
    int rightWeight = root.getRightWeight();
    List<Integer> rightPath = rightMax.path;

    // if the left path has more funness than the right path, return the left path with the
    // current node added to the beginning
    if (leftFunness + leftWeight >= rightFunness + rightWeight) {
      List<Integer> path = new ArrayList<>(leftPath);
      path.add(0, root.getLabel());
      return new MaxFunness(leftFunness + leftWeight, path);
    }

    // otherwise, return the right path with the current node added to the beginning
    else {
      List<Integer> path = new ArrayList<>(rightPath);
      path.add(0, root.getLabel());
      return new MaxFunness(rightFunness + rightWeight, path);
    }
  }

  public static void main(String[] args) {
    // create a scanner to read the input
    Scanner scanner = new Scanner(System.in);
    BinaryTree tree = new BinaryTree(scanner);

    // find the maximum funness path in the tree
    MaxFunness max = findMaxFunnessPath(tree.getRoot());

    // print the maximum funness and path
    System.out.println("Largest Funness: " + max.funness);
    System.out.println("Path: ");
    for (Integer node : max.path) {
      System.out.println("Node: " + node);
    }
  }

}
