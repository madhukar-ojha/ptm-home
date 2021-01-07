package ptm.home.service.impl;

import ptm.common.service.ServiceResponse;
import ptm.home.vo.LoginVO;
import ptm.home.vo.SubMenuVO;
import ptm.home.common.pojo.SearchParams;
import ptm.home.dao.LoginDAO;
import ptm.home.entity.Designation;
import ptm.home.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginRoleDAO;

	@Override
	public ResponseEntity<ptm.common.service.ServiceResponse> login(LoginVO loginVO) {
		ResponseEntity<ServiceResponse> responseEntity = loginRoleDAO.login(loginVO);

		// preparing home map to display menu on home.jsp
		Map<String, TreeSet<SubMenuVO>> homeMap = new HashMap<String, TreeSet<SubMenuVO>>();
		List<SubMenuVO> redundantList = new ArrayList<SubMenuVO>();
		TreeSet<SubMenuVO> list = new TreeSet<SubMenuVO>();
		/*
		 * for (MenuVO menuVO : userDetailVO.getUserRole()) { for (SubMenuVO subMenuVO :
		 * menuVO.getSubMenuList()) { list.add(subMenuVO); // This loop is for SubMenu
		 * dependency. eg Employee update has implicit employee // search right. So it
		 * is looked and put on list. for (SubMenuVO subMenuVO2 :
		 * subMenuVO.getSubMenuDependencySet()) { if (subMenuVO2.getIndex() == 0) {
		 * list.add(subMenuVO2); list.remove(subMenuVO); redundantList.add(subMenuVO);
		 * break; } } } list.removeAll(redundantList); homeMap.put(menuVO.getMenuName(),
		 * list); }
		 */
	//	userDetailVO.setHomeMap(homeMap);

		return responseEntity;
	}

	@Override
	public Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams) {
		Map<Integer, String> roleMap = loginRoleDAO.getRoleListByDepartmentId(searchParams);
		return roleMap;
	}

	@Override
	public Map<Integer, String> getDepartmentList() {
		Map<Integer, String> departmentMap = loginRoleDAO.getDepartmentList();
		return departmentMap;
	}

	@Override
	public Designation getDesignationIdByRoleNDepttId(SearchParams searchParams) {
		Designation designation = loginRoleDAO.getDesignationIdByRoleNDepttId(searchParams);
		return designation;
	}
}
