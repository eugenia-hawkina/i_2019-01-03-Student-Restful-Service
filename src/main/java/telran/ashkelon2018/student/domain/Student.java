package telran.ashkelon2018.student.domain;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class Student {
	int id;
	@Setter String name;
	@Setter String password;
	Map<String, Integer> scores;
	
	public Student(int id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
		scores = new ConcurrentHashMap<>();
		// многопоточная мапа
	}
	
	public boolean addScore(String exam, int score) {
		return scores.put(exam, score) != null;
	}

	
}
