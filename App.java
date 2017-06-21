import java.util.ArrayList;
import java.util.Scanner;

class Cat {
	private int id;
	// static int below. class variable. does not change per object. used for id
	// # see constructor
	private static int count = 0;
	private int length;
	private int height;
	private boolean tail;

	public void SetLength(int length) {
		this.length = length;
	}

	public void SetHeight(int height) {
		this.height = height;
	}

	public void SetTail(boolean tail) {
		this.tail = tail;
	}

	// constructor below. giving an ID number to each class object.
	public Cat() {
		this.id = count;
		count++;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("cat stats:  cat # ").append(id + 1).append("\n").append("height = ").append(height)
				.append("\tLength = ").append(length);
		if (tail) {
			sb.append("\n this cat has a tail.\n");
		} else {
			sb.append("\n this cat has no tail.\n");
		}
		return sb.toString();
	}

	public int getId() {
		return id;
	};

}

public class App {
	public static void main(String[] args) {
		// new arraylist with object types Cat in it
		ArrayList<Cat> cats = new ArrayList<Cat>();

		String input1 = new String();
		Scanner scanner1 = new Scanner(System.in);

		input1 = null;
		boolean run = false;
		do {
			System.out.println(
					"Input Options: \nx: Exit  \ta: Add Cat\tl: List Cats\tz: Add 4 Standard Cats\t  c: Count Cats");
			input1 = scanner1.nextLine();
			run = true;
			switch (input1) {
			case "x":
				run = false;
				break;
			case "a":
				Cat cat0 = new Cat();
				String tail = new String();
				int height = 0;
				int length = 0;
				boolean tailbool = false;

				System.out.println("input the following information.");
				System.out.print("height:");
				height = scanner1.nextInt();
				scanner1.nextLine(); // needed to clear 'return' char
				cat0.SetHeight(height);
				System.out.println();
				System.out.print("length:");
				length = scanner1.nextInt();
				scanner1.nextLine(); // needed to clear 'return' char
				cat0.SetLength(length);
				System.out.println();
				System.out.print("Does this cat have a tail?  y/n");
				tail = scanner1.nextLine();
				switch (tail) {
				case "y":
					tailbool = true; // this is initialized to false
					break;
				}
				;
				cat0.SetTail(tailbool);
				cats.add(cat0);
				int number = cat0.getId() + 1;
				System.out.println("you successfully added cat # " + number);
				System.out.println("total cats now = " + cats.size());
				break;
			case "l":
				System.out.println("Listing Cats:\n");

				// display all items in array using FOR loop with size check.
				for (int i = 0; i < cats.size(); i++)

				{
					// creates new cat object from stored array for each loop.
					// assign it to current loop # and
					// output.
					Cat k = new Cat();
					k = cats.get(i);
					System.out.println(k);

				}

				break;
			case "z":
				System.out.println("Adding 4 Standard Cats...");
				Cat cat1 = new Cat();
				Cat cat2 = new Cat();
				Cat cat3 = new Cat();
				cat1.SetHeight(4);
				cat1.SetLength(56);
				cat1.SetTail(true);
				cat2.SetHeight(3);
				cat2.SetLength(45);
				cat2.SetTail(false);
				cat3.SetHeight(5);
				cat3.SetLength(67);
				cat3.SetTail(true);
				Cat cat4 = new Cat();
				cat4.SetHeight(12);
				cat4.SetLength(450);
				cat4.SetTail(true);

				// adding to arraylist
				cats.add(cat1);
				cats.add(cat2);
				cats.add(cat3);
				cats.add(cat4);

				break;
			case "c":
				System.out.println("Currently there are " + cats.size() + " cats in memory.");
				break;

			}

		} while (run);

		scanner1.close();
	}
}
