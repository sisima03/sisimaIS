package sisima.com.WassimWebApi;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mockitoSession;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
//import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.jupiter.api.*;

import sisima.com.WassimWebApi.DAO.EmployeRepository;
import sisima.com.WassimWebApi.DTO.EmployeDTO;
import sisima.com.WassimWebApi.Entities.Employe;
import sisima.com.WassimWebApi.Entities.ProjectEmploye;
import sisima.com.WassimWebApi.Mapper.EmployeMapper;
import sisima.com.WassimWebApi.Provider.EmployeProviderImp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WassimWebApiApplication.class)
public class ServiceEmployeTest {

	@Autowired
	private EmployeProviderImp employeProvider;
	
	@Autowired
	private EmployeMapper empMapper;
	
	@MockBean
	private EmployeRepository empRepo;
	
//	@Before
//	public void init() {
//		
//	}
	
	@Test
	public void getEmployesByLastName() {
		
		List<ProjectEmploye> lst = new ArrayList<ProjectEmploye>();
		List<Employe> expectedListEmp = new ArrayList<Employe>();
		List<Employe> resultedListEmp = new ArrayList<Employe>();
		
		LocalDate birthDate_ld = LocalDate.parse("2007-01-01");
		Date birthDate = Date.from(birthDate_ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Employe expectedEmploye = new Employe(
				2L, "wassim", "wassim", birthDate, "wassim@domain.sim", lst
		);
		expectedListEmp.add(expectedEmploye);
		
		Mockito.when(empRepo.getEmployeByLastName("wassim"))
				.thenReturn((expectedListEmp ));
		
		assertEquals(expectedListEmp, employeProvider.getEmployeesByLastName("wassim"));
	}
	
	
	@Test
	public void getAllEmployees() {
		List<ProjectEmploye> lst = new ArrayList<ProjectEmploye>();
		List<Employe> wassimList = new ArrayList<Employe>();
		LocalDate birthDate_ld = LocalDate.parse("2007-01-01");
		Date birthDate = Date.from(birthDate_ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Employe e1 = new Employe(
				2L, "wassim", "wassim", birthDate, "wassim@domain.sim", lst
		);
		Employe e2 = new Employe(
				2L, "mohati", "mohati", birthDate, "mohati@domain.sim", lst
		);
		
		wassimList.add(e1);wassimList.add(e2);
		Mockito.when(empRepo.findAll())
				.thenReturn(wassimList);
		
		System.err.println("list employees for testing : " + empRepo.findAll());
		
		assertTrue(employeProvider.getAllEmployees().size() >=2 );
//		assertEquals(10, empRepo.findAll().size());
		
	}
	
	@Test
	public void saveEmploye() {
		
		EmployeDTO empToSave = new EmployeDTO(17L, "test1", "testing", "2007-01-01", "testing@domain.sim");
		System.err.println(EmployeMapper.mapObjetToData(empToSave));
		Mockito.when(empRepo.save(EmployeMapper.mapObjetToData(empToSave))).thenReturn(EmployeMapper.mapObjetToData(empToSave));
		
		System.err.println(EmployeMapper.mapObjetToData(empToSave));
		empToSave.setId(null);
		System.err.println(employeProvider.createEmploye(empToSave));
		empToSave.setId(17L);
		assertEquals(empToSave, employeProvider.createEmploye(empToSave));
	}
	
	@Test
	public void deleteEmploye() {
		List<ProjectEmploye> lst = new ArrayList<ProjectEmploye>();
		LocalDate birthDate_ld = LocalDate.parse("2007-01-01");
		Date birthDate = Date.from(birthDate_ld.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Employe empToDelete = new Employe(0L, "test1", "testing", birthDate, "testing@domain.sim", lst);
		
		employeProvider.deleteEmploye(10L);
		verify(empRepo, times(1)).delete(empToDelete);
	}
	

}

