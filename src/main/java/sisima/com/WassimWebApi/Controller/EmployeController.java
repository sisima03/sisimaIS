package sisima.com.WassimWebApi.Controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import antlr.StringUtils;
import sisima.com.WassimWebApi.Constants.RestErrorConstants;
import sisima.com.WassimWebApi.DTO.EmployeDTO;
import sisima.com.WassimWebApi.Entities.Employe;
import sisima.com.WassimWebApi.Entities.Project;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;
import sisima.com.WassimWebApi.Exception.RestException;
import sisima.com.WassimWebApi.ProviderInterface.IEmployeProvider;
import sisima.com.WassimWebApi.Utils.StringUtility;;

@RestController
@RequestMapping("/api/employe")
public class EmployeController {

	@Autowired
	IEmployeProvider employeProvider;
	
	@RequestMapping(value = "/getAll")
	public String getAllEmployees() {
		return employeProvider.getAllEmployees().toString() ;
	}
	
	@RequestMapping(value = "/getEmployesByLastName", method=RequestMethod.GET)
	public List<Employe> getEmployeesBylastName(@RequestParam(value="lastName", required=true) String lastName) {
		
		return  employeProvider.getEmployeesByLastName(lastName) ;
	}
	
	@RequestMapping(value = "/getProjectsByEmployeId", method=RequestMethod.GET)
	public Map<String, List<Project>> getProjectsByEmployeId(@RequestParam(value = "id") Long id) {
		System.out.println(id);
		return employeProvider.getEmployeProjectsById(id) ;
	}
	
	
	@RequestMapping(value = "/test")
	public String testing() {
		return " employe controller successfull test";
	}

	@RequestMapping(value="/addEmp", method = RequestMethod.GET)
	public EmployeDTO createEmploye (@RequestParam(value="firstName", required=true) String firstName, 
			@RequestParam(value="lastName", required=true) String lastName,
			@RequestParam(value="dateBirth", required=true) String dateBirth,
			@RequestParam(value="email", required=true) String email) {
		
		EmployeDTO employe = new EmployeDTO();
		employe.setFirstName(firstName);
		employe.setLastName(lastName);
		employe.setBirthDate(dateBirth);
		employe.setEmail(email);
		return employe;
	}
	
	@RequestMapping(value="/addEmp", method = RequestMethod.POST)
	public EmployeDTO createEmploye (@RequestBody EmployeDTO newEmploye) {
		
		newEmploye.setId(null);
		System.out.println("first : " + newEmploye.getFirstName());
		System.out.println("last : " + newEmploye.getLastName());
		Date d = new Date("01/01/2020");
		System.out.println(d);
		
		return employeProvider.createEmploye(newEmploye);
	}
	
	@RequestMapping(value="/updateEmp", method = RequestMethod.POST)
	public EmployeDTO updateEmploye (@RequestBody EmployeDTO employe) {
		
		if (employe.getId() == null) 
			return new EmployeDTO();
		System.out.println("update Operation ==> First : " + employe.getFirstName());
		System.out.println("last : " + employe.getLastName());
		
		EmployeDTO empDTO = new EmployeDTO();
		try {
			empDTO = employeProvider.updateEmploye(employe);
		} catch (Exception e) {
			throw new RestException(RestErrorConstants.BAD_IDENTIFIANT);
		}
		return empDTO;
	}
	
	
	@RequestMapping(value="/deleteEmp", method = RequestMethod.POST)
	public EmployeDTO deleteEmploye (@RequestBody (required = true) String employe_id) {
		
		Long emp_id = StringUtility.requestBody_GetLongValue(employe_id);
		//Long i = Long.parseLong());
		EmployeDTO empDTO = new EmployeDTO();
		try {
			empDTO = employeProvider.deleteEmploye(emp_id);
		} catch (Exception e) {
			throw new RestException(RestErrorConstants.BAD_IDENTIFIANT);
		}
		
		return empDTO;
		
	}
}  
