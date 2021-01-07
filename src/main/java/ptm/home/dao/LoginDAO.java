package ptm.home.dao;

import org.springframework.http.ResponseEntity;
import ptm.common.service.ServiceResponse;
import ptm.home.common.pojo.SearchParams;
import ptm.home.common.pojo.SearchResult;
import ptm.home.entity.Department;
import ptm.home.entity.Designation;
import ptm.home.entity.Role;
import ptm.home.vo.LoginVO;

import java.util.Map;

public interface LoginDAO {

	ResponseEntity<ServiceResponse> login(LoginVO loginVo);

	SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

	Role getRoleById(SearchParams searchParams);

	Department getDepartmentById(SearchParams searchParams);

//	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams)
}
