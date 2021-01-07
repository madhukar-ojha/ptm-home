package ptm.home.service;

import ptm.home.common.pojo.SearchParams;
import ptm.home.common.pojo.SearchResult;
import ptm.home.entity.Department;
import ptm.home.entity.Designation;
import ptm.home.entity.Role;

import java.util.Map;

public interface PTMAdminService {
	SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams);

	Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams);

	Map<Integer, String> getDepartmentList();

	Designation getDesignationIdByRoleNDepttId(SearchParams searchParams);

	Role getRoleById(SearchParams searchParams);

	Department getDepartmentById(SearchParams searchParams);
}
