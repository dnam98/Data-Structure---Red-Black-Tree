// --== CS400 File Header Information ==--
// Name: Dong Won Nam
// Email: dnam9@wisc.edu
// Team: AD
// TA: Ilay
// Lecturer: Gary Dahl
// Notes to Grader: N/A

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestRedBlackTree {

  /**
   * Tests inserting to a black parent node
   */
  @Test
  public void testInsert1() {
    RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
    testTree.insert(5);
    testTree.insert(3);

    assertEquals(true, testTree.root.isBlack);
    assertEquals(false, testTree.root.leftChild.isBlack);
  }

  /**
   * Tests case 1: Parent's sibling is black, and opposite side
   */
  @Test
  public void testInsert2() {
    RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
    testTree.insert(10);
    testTree.insert(5);
    testTree.insert(15);
    testTree.root.leftChild.isBlack = false;
    testTree.root.rightChild.isBlack = true;
    testTree.insert(2);

    String actual = testTree.toString();
    String expected = "[ 2, 5, 10, 15 ]";

    assertEquals(expected, actual);
    assertEquals(true, testTree.root.isBlack);
    assertEquals(false, testTree.root.leftChild.isBlack);
    assertEquals(false, testTree.root.rightChild.isBlack);
  }

  /**
   * Tests case 2: Parent's sibling is black, and on same side
   */
  @Test
  public void testInsert3() {
    RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
    testTree.insert(10);
    testTree.insert(5);
    testTree.insert(15);
    testTree.insert(7);

    String actual = testTree.toString();
    String expected = "[ 5, 7, 10, 15 ]";

    assertEquals(expected, actual);
    assertEquals(true, testTree.root.isBlack);
    assertEquals(true, testTree.root.leftChild.isBlack);
    assertEquals(true, testTree.root.rightChild.isBlack);
    assertEquals(false, testTree.root.leftChild.rightChild.isBlack);
  }

  /**
   * Tests case 3: Parent's sibling is red
   */
  @Test
  public void testInsert4() {
    RedBlackTree<Integer> testTree = new RedBlackTree<Integer>();
    testTree.insert(10);
    testTree.insert(5);
    testTree.insert(15);
    testTree.insert(2);

    String actual = testTree.toString();
    String expected = "[ 2, 5, 10, 15 ]";

    assertEquals(expected, actual);
    assertEquals(true, testTree.root.isBlack);
    assertEquals(true, testTree.root.leftChild.isBlack);
    assertEquals(true, testTree.root.rightChild.isBlack);
    assertEquals(false, testTree.root.leftChild.leftChild.isBlack);
  }
}