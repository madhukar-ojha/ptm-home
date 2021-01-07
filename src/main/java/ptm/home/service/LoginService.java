package ptm.home.service;

import org.springframework.http.ResponseEntity;
import ptm.common.service.ServiceResponse;
import ptm.home.common.pojo.SearchParams;
import ptm.home.entity.Designation;
import ptm.home.vo.LoginVO;

import java.util.Map;

public interface LoginService {

	ResponseEntity<ServiceResponse> login(LoginVO loginVO);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

}
