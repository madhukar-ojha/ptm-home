package ptm.home.dao;

import ptm.home.common.pojo.SearchParams;
import ptm.home.vo.EmployeeVO;
import ptm.home.vo.LoginVO;
import ptm.home.entity.Employee;
import ptm.home.entity.IndiaState;

import java.util.Map;

public interface EmployeeDAO {

	Employee getEmployeeDetailsById(int id);

	void saveOrUpdateEmployee(Employee employee);

	int updatePassword(LoginVO loginVO);

	int deleteEmployee(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();

	IndiaState getIndiaState(SearchParams searchParams);

}
