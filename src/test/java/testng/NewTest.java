package testng;

import org.testng.annotations.Test;

public class NewTest {
	int addNumbers(int a, int b) {
		return a+b;
	}
  @Test(priority = 5)
  public void tc01() {
	  System.out.println("This is tc 01");
  }
  
  @Test(priority = 4)
  public void tc02() {
	  System.out.println("This is tc 02");
  }
  
  @Test(priority = 3)
  public void tc03() {
	  System.out.println("This is tc 03");
  }
  
  @Test(priority = 2)
  public void tc04() {
	  System.out.println("This is tc 04");
	  assert(2==3):"testcase fail";
  }
  
  @Test(priority = 1)
  public void tc05() {
	  System.out.println("This is tc 05");
  }
}
