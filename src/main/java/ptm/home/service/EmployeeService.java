package ptm.home.service;

import ptm.home.common.pojo.SearchParams;
import ptm.home.vo.EmployeeVO;
import ptm.home.vo.LoginVO;

import java.util.Map;

public interface EmployeeService {

	void saveOrUpdateEmployee(EmployeeVO employeeVO, SearchParams searchParams);

	int updatePassword(LoginVO loginVO);

	int deleteEmployeePersonal(SearchParams searchParams);

	EmployeeVO getEmployeeDetailsById(SearchParams searchParams);

	Map<Integer, String> getIndiaStateList();
}
