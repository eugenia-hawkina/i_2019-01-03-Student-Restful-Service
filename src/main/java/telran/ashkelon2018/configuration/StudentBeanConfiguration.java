package telran.ashkelon2018.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import telran.ashkelon2018.student.dao.StudentRepository;
import telran.ashkelon2018.student.dao.StudentRepositoryMapImpl;

@Configuration
public class StudentBeanConfiguration {
	
//	@Bean
//	public StudentRepository createStudentRep() {
//		return new StudentRepositoryMapImpl();
//	}

	//var2
//	@Bean
//	public ObjectMapper createObjectMapper() {
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.findAndRegisterModules();
//		return mapper;
//	}
}
