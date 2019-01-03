package telran.ashkelon2018.student.service;

import telran.ashkelon2018.student.dto.ScoreDto;
import telran.ashkelon2018.student.dto.StudentDto;
import telran.ashkelon2018.student.dto.StudentEditDto;
import telran.ashkelon2018.student.dto.StudentResposeDto;

public interface StudentService {
	
	boolean addStudent(StudentDto studentDto);
	
	StudentResposeDto deleteStudent(int id, String token);
	
	StudentDto editStudent(int id, StudentEditDto studentEditDto, String token);
	
	StudentResposeDto getStudent(int id);
	
	boolean addScore(int id, ScoreDto scoreDto);
	
	

}
