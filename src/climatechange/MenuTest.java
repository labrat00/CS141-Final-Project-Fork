package climatechange;
import java.util.Scanner;
public class MenuTest {
//	Menu menu = new Menu();
	public static void mainMenuTest() {
		Scanner testScnr  = new Scanner(System.in);		
		Menu.runMenu(testScnr);
	}
	
	public static void main(String[] args) {
		mainMenuTest();
	}
}
