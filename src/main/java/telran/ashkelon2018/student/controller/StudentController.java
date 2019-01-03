package telran.ashkelon2018.student.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import telran.ashkelon2018.student.dto.ScoreDto;
import telran.ashkelon2018.student.dto.StudentDto;
import telran.ashkelon2018.student.dto.StudentEditDto;
import telran.ashkelon2018.student.dto.StudentResposeDto;
import telran.ashkelon2018.student.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;
	// поле = интрефейс
	// реализация интерфейса будет в другом классе

	@PostMapping("/student")
	public boolean addStudent(@RequestBody StudentDto studentDto) {
		return studentService.addStudent(studentDto);
	}

	@DeleteMapping("/student/{id}")
	public StudentResposeDto removeStudent(@PathVariable int id, @RequestHeader("Authorization") String token) {

		return studentService.deleteStudent(id, token);
	}

	@PutMapping("/student/{id}")
	public StudentDto updateStudent(@PathVariable int id, @RequestBody StudentEditDto studentEditDto,
			HttpServletRequest request, HttpServletResponse response) {
		String token = request.getHeader("Authorization");
//		StudentEditDto studentEditDto = getBody(request);
		return studentService.editStudent(id, studentEditDto, token);
	}

//	// боди получаем через аннотацию спринга @RequestBody
//	// она заменяет весь метод гетБоди
//	// или метод, или аннотация, тк инпутСтрим вычитывает поток и оставляет курсор в конце
//	// один вычитает, второму ничего не останется
//		private StudentEditDto getBody(HttpServletRequest request) {
//		StringBuilder json = new StringBuilder("");
//		ObjectMapper mapper = new ObjectMapper();
//		try {
//			BufferedReader bReader = new BufferedReader(new InputStreamReader
//					(request.getInputStream()));
//			String str = bReader.readLine();			
//			while (str != null && !str.isEmpty()) {
//				json.append(str);
//				str = bReader.readLine();
//			}			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		try {
//			return mapper.readValue(json.toString(), StudentEditDto.class);
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}
//	}

	@GetMapping("/student/{id}")
	public StudentResposeDto getStudent(@PathVariable int id) {
		return studentService.getStudent(id);
	}

	@PutMapping("/teacher/{id}")
	public boolean putScore(@PathVariable int id, @RequestBody ScoreDto scoreDto) {
		return studentService.addScore(id, scoreDto);
	}

}
