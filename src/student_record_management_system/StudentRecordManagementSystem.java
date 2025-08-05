package student_record_management_system;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class StudentRecordManagementSystem {
	private static ArrayList<Student> students = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	private static final String DIVIDER = "=" + "=".repeat(60);

	public static void main(String[] args) {
		System.out.println(DIVIDER);
		System.out.println("	STUDENT RECORD MANAGEMENT SYSTEM");
		System.out.println(DIVIDER);

		while (true) {
			displayMenu();
			int choice = getValidChoice();

			switch (choice) {
			case 1:
				addStudent();
				break;
			case 2:
				viewAllStudents();
				break;
			case 3:
				updateStudent();
				break;
			case 4:
				deleteStudent();
				break;
			case 5:
				searchStudent();
				break;
			case 6:
				sortStudents();
				break;
			case 7:
				System.out.println("\nThank you for using Student Record Management System!");
				System.out.println("Good Bye!");
				return;

			default:
				System.out.println("Invalid choice! Please try again");

			}
			System.out.println("\nPress Enter to continue...");
			scanner.nextLine();

		}
	}

	private static void displayMenu() {
		System.out.println("\n" + DIVIDER);
		System.out.println("    MAIN MENU");
		System.out.println(DIVIDER);
		System.out.println("1. Add Student");
		System.out.println("2. View All Students");
		System.out.println("3. Update Student");
		System.out.println("4. Delete Student");
		System.out.println("5. Search Student");
		System.out.println("6. Sort Students");
		System.out.println("7. Exit");
		System.out.println(DIVIDER);
		System.out.println("Enter your choice(1-7): ");
	}

	private static int getValidChoice() {
		try {
			int choice = Integer.parseInt(scanner.nextLine());
			return choice;
		} catch (NumberFormatException e) {
			return -1; // Invalid choice
		}
	}

	private static void addStudent() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                ADD NEW STUDENT");
		System.out.println(DIVIDER);

		try {
			System.out.print("Enter Student ID: ");
			int id = Integer.parseInt(scanner.nextLine());

			// Check if ID already exists
			if (findStudentById(id) != null) {
				System.out.println("Error: Student with ID " + id + " already exists!");
				return;
			}

			System.out.print("Enter Student Name: ");
			String name = scanner.nextLine().trim();

			if (name.isEmpty()) {
				System.out.println("Error: Name cannot be empty!");
				return;
			}

			System.out.print("Enter Student Marks: ");
			double marks = Double.parseDouble(scanner.nextLine());

			if (marks < 0 || marks > 100) {
				System.out.println("Error: Marks should be between 0 and 100!");
				return;
			}

			Student student = new Student(id, name, marks);
			students.add(student);

			System.out.println("\nStudent added successfully!");
			System.out.println("Student Details: " + student);

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter valid numeric values!");
		}
	}

	private static void viewAllStudents() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                ALL STUDENTS");
		System.out.println(DIVIDER);

		if (students.isEmpty()) {
			System.out.println("No students found in the system.");
			return;
		}

		System.out.println("Total Students: " + students.size());
		System.out.println("-".repeat(60));

		for (Student student : students) {
			System.out.println(student);
		}
	}

	private static void updateStudent() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                UPDATE STUDENT");
		System.out.println(DIVIDER);

		if (students.isEmpty()) {
			System.out.println("No students found in the system.");
			return;
		}

		try {
			System.out.print("Enter Student ID to update: ");
			int id = Integer.parseInt(scanner.nextLine());

			Student student = findStudentById(id);
			if (student == null) {
				System.out.println("Student with ID " + id + " not found!");
				return;
			}

			System.out.println("Current Details: " + student);
			System.out.println("\nEnter new details (press Enter to keep current value):");

			System.out.print("Enter new name [" + student.getName() + "]: ");
			String newName = scanner.nextLine().trim();
			if (!newName.isEmpty()) {
				student.setName(newName);
			}

			System.out.print("Enter new marks [" + student.getMarks() + "]: ");
			String newMarksStr = scanner.nextLine().trim();
			if (!newMarksStr.isEmpty()) {
				double newMarks = Double.parseDouble(newMarksStr);
				if (newMarks >= 0 && newMarks <= 100) {
					student.setMarks(newMarks);
				} else {
					System.out.println("Warning: Marks should be between 0 and 100. Keeping old value.");
				}
			}

			System.out.println("\nStudent updated successfully!");
			System.out.println("Updated Details: " + student);

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter valid numeric values!");
		}
	}

	private static void deleteStudent() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                DELETE STUDENT");
		System.out.println(DIVIDER);

		if (students.isEmpty()) {
			System.out.println("No students found in the system.");
			return;
		}

		try {
			System.out.print("Enter Student ID to delete: ");
			int id = Integer.parseInt(scanner.nextLine());

			Student student = findStudentById(id);
			if (student == null) {
				System.out.println("Student with ID " + id + " not found!");
				return;
			}

			System.out.println("Student Details: " + student);
			System.out.print("Are you sure you want to delete this student? (y/n): ");
			String confirmation = scanner.nextLine().trim().toLowerCase();

			if (confirmation.equals("y") || confirmation.equals("yes")) {
				students.remove(student);
				System.out.println("Student deleted successfully!");
			} else {
				System.out.println("Delete operation cancelled.");
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter a valid ID!");
		}
	}

	private static void searchStudent() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                SEARCH STUDENT");
		System.out.println(DIVIDER);

		if (students.isEmpty()) {
			System.out.println("No students found in the system.");
			return;
		}

		System.out.println("Search by:");
		System.out.println("1. ID");
		System.out.println("2. Name");
		System.out.print("Enter your choice (1-2): ");

		try {
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				System.out.print("Enter Student ID: ");
				int id = Integer.parseInt(scanner.nextLine());
				Student student = findStudentById(id);
				if (student != null) {
					System.out.println("Student found: " + student);
				} else {
					System.out.println("Student with ID " + id + " not found!");
				}
				break;

			case 2:
				System.out.print("Enter Student Name: ");
				String name = scanner.nextLine().trim();
				boolean found = false;
				for (Student s : students) {
					if (s.getName().toLowerCase().contains(name.toLowerCase())) {
						System.out.println("Found: " + s);
						found = true;
					}
				}
				if (!found) {
					System.out.println("No student found with name containing '" + name + "'");
				}
				break;

			default:
				System.out.println("Invalid choice!");
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter valid input!");
		}
	}

	private static void sortStudents() {
		System.out.println("\n" + DIVIDER);
		System.out.println("                SORT STUDENTS");
		System.out.println(DIVIDER);

		if (students.isEmpty()) {
			System.out.println("No students found in the system.");
			return;
		}

		System.out.println("Sort by:");
		System.out.println("1. ID (Ascending)");
		System.out.println("2. Name (Alphabetical)");
		System.out.println("3. Marks (Descending)");
		System.out.print("Enter your choice (1-3): ");

		try {
			int choice = Integer.parseInt(scanner.nextLine());

			switch (choice) {
			case 1:
				Collections.sort(students, Comparator.comparingInt(Student::getId));
				System.out.println("Students sorted by ID (Ascending):");
				break;

			case 2:
				Collections.sort(students, Comparator.comparing(Student::getName));
				System.out.println("Students sorted by Name (Alphabetical):");
				break;

			case 3:
				Collections.sort(students, Comparator.comparingDouble(Student::getMarks).reversed());
				System.out.println("Students sorted by Marks (Descending):");
				break;

			default:
				System.out.println("Invalid choice!");
				return;
			}

			System.out.println("-".repeat(60));
			for (Student student : students) {
				System.out.println(student);
			}

		} catch (NumberFormatException e) {
			System.out.println("Error: Please enter a valid choice!");
		}
	}

	// Helper method to find student by ID
	private static Student findStudentById(int id) {
		for (Student student : students) {
			if (student.getId() == id) {
				return student;
			}
		}
		return null;
	}
}
