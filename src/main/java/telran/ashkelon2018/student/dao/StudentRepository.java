package telran.ashkelon2018.student.dao;

import telran.ashkelon2018.student.domain.Student;

public interface StudentRepository {
	
	boolean addStudent(Student student);
	
	Student removeStudent(int id);
	
	Student findStudentById(int id);
	
	Student editStudent(Student student);

	boolean addScore(int id, String examName, int score);

}
