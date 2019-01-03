package telran.ashkelon2018.student.dao;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import telran.ashkelon2018.student.domain.Student;
import telran.ashkelon2018.student.dto.StudentNotFoundException;

// @Component можно и так, и так аннотировать

// @Repository

//если нет аннтонаций в этом классе - нужно содать класс контфигурацию
public class StudentRepositoryMapImpl implements StudentRepository {
	Map<Integer, Student> students = new ConcurrentHashMap<>();
	

	@Override
	public boolean addStudent(Student student) {
		return students.putIfAbsent(student.getId(), student) == null;
	}

	@Override
	public Student removeStudent(int id) {
		return students.remove(id);
	}

	@Override
	public Student findStudentById(int id) {
		Student student = students.get(id);
		if(student == null) {
			throw new StudentNotFoundException("Student not found");
		}
		return student;
	}

	@Override
	public Student editStudent(Student student) {
	 students.replace(student.getId(), student);
	 return findStudentById(student.getId());
	}

	@Override
	public boolean addScore(int id, String examName, int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
