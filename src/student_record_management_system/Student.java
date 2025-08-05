package student_record_management_system;

public class Student {
	private int id;
	private String name;
	private double marks;

	public Student() {
		this.id = 0;
		this.name = "";
		this.marks = 0.0;
	}

	public Student(int id, String name, double marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMarks() {
		return marks;
	}

	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	@Override
	public String toString() {
		return String.format("ID: %-5d | Name: %-20s | Marks: %.2f", id,name,marks);
	}
}
