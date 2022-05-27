package lecture;

import course.Course;
import professor.Professor;
import student.Student;

public class Class {
	private int id;
	private Course course;
	private Professor professor;
	private Student student;
	
	public Class(int id, Course course, Professor professor, Student student) {
		super();
		this.id = id;
		this.course = course;
		this.professor = professor;
		this.student = student;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
