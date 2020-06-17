package sisima.com.WassimWebApi.Mapper;

import sisima.com.WassimWebApi.Entities.Employe;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.stereotype.Component;

import sisima.com.WassimWebApi.DTO.EmployeDTO;

@Component
public class EmployeMapper {
	
	
	public static Employe mapObjetToData (EmployeDTO dto) {
		
		Employe emp = new Employe();
		LocalDate birthDate_ld = LocalDate.parse(dto.getBirthDate());
		Date birthDate = Date.from(birthDate_ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		
		emp.setId(dto.getId());
		emp.setBirthDate(birthDate);
		emp.setFirstName(dto.getFirstName());
		emp.setLastName(dto.getLastName());
		emp.setEmail(dto.getEmail());

		return emp;
		
	}
	
	public static EmployeDTO mapDataToObject (Employe emp) {
		
		EmployeDTO dto = new EmployeDTO();
		LocalDateTime ldt = LocalDateTime.ofInstant(emp.getBirthDate().toInstant(),
                									ZoneId.systemDefault());
		
		// formatter date to string using DateTimeFormatter
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String birthDateString = ldt.format(dateFormatter);
		
		dto.setId(emp.getId());
		dto.setBirthDate(birthDateString);
		dto.setFirstName(emp.getFirstName());
		dto.setLastName(emp.getLastName());
		dto.setEmail(emp.getEmail());
		
		return dto;
		
	}

}
