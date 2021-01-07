package ptm.home.dao.impl;

//import ptm.home.common.feign.login.LoginClient;
//import ptm.home.common.service.ServiceResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ptm.common.service.ServiceResponse;
import ptm.home.common.pojo.SearchParams;
import ptm.home.common.pojo.SearchResult;
import ptm.home.dao.LoginDAO;
import ptm.home.entity.Department;
import ptm.home.entity.Designation;
import ptm.home.entity.Role;
import ptm.home.vo.LoginVO;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static ptm.home.common.constant.HibernateQuery.*;

@Component
public class LoginDAOImpl implements LoginDAO {

//	@Autowired private LoginClient loginClient;
	@Autowired private SessionFactory sessionFactory;
	@Autowired ObjectFactory<HttpMessageConverters> messageConverters;
	@Autowired RestTemplate restTemplate;
		
//	@Override
//	public ResponseEntity<ServiceResponse> login(LoginVO loginVo) {
	//	String data = loginClient.go();
	//	ResponseEntity<ServiceResponse> response = loginClient.login(loginVo);
	//	return null;
//	}


	/*
	 * @Override public UserDetailVO isValidLogin(SearchParams searchParams) {
	 * Session session = sessionFactory.openSession(); // create query
	 * Query<Employee> query = session.createQuery(USER_LOGIN, Employee.class); //
	 * setting user id and password query.setParameter("id",
	 * searchParams.getIntNum1()); query.setParameter("password",
	 * searchParams.getStrData1()); // execute query Employee employee =
	 * query.uniqueResult(); // No record found... means user is and password didn't
	 * match if (employee == null) { logger.info("Invalid credentials..."); return
	 * null; } logger.info(new StringBuilder("User id " + searchParams.getIntNum1()
	 * + " logged in.")); // Fetching context path. It will be appended to permitted
	 * URLs. // This URLs are investigated in request interceptor to authorize
	 * request. String contextPath = searchParams.getStrData2();
	 * BeanUtils.copyProperties(employee, userDetailVO);
	 * userDetailVO.setDesignationName(employee.getDesignation().getDesignationName(
	 * ));
	 * 
	 * Set<UserRole> userRole = employee.getDesignation().getUserRoles(); //
	 * Preparing map of user roles Map<Integer, MenuVO> roleMap = new
	 * TreeMap<Integer, MenuVO>(); // Preparing set of permitted urls of user
	 * Set<String> permittedURLs = new HashSet<String>(); for (UserRole role :
	 * userRole) { SubMenu subMenu = role.getSubMenu(); Menu menu =
	 * subMenu.getMenu(); // Putting all url into set. This set will be used in
	 * interceptor // to authorize request. permittedURLs.add(new
	 * StringBuilder(contextPath).append(subMenu.getSubMenuUrl()).toString());
	 * permittedURLs.add(new
	 * StringBuilder(contextPath).append(menu.getMenuUrl()).toString()); int id =
	 * menu.getId(); SubMenuVO subMenuVO = BeanUtils.instantiate(SubMenuVO.class);
	 * BeanUtils.copyProperties(subMenu, subMenuVO); // Checking submenu dependency
	 * Set<SubMenuDependency> dependency =
	 * subMenu.getSubMenuDependenciesForSubMenuId(); for (SubMenuDependency dep :
	 * dependency) { // populating submneu dependency in submenu SubMenuVO smdep =
	 * BeanUtils.instantiate(SubMenuVO.class);
	 * BeanUtils.copyProperties(dep.getSubMenuBySubMenuDependencyId(), smdep);
	 * subMenuVO.getSubMenuDependencySet().add(smdep); permittedURLs.add(new
	 * StringBuilder(contextPath).append(smdep.getSubMenuUrl()).toString()); }
	 * MenuVO menuVO = roleMap.get(id); // Checking if key(Menu id) exists in map if
	 * (menuVO != null) { // Key exists. Fetch MenuVO and put SubMenuVO in MenuVO
	 * menuVO.getSubMenuList().add(subMenuVO); } else { // Key don't exists.
	 * preparing MenuVo and SubMenuVO and // putting in map as menu id as key and
	 * submenuvo asvalue menuVO = BeanUtils.instantiate(MenuVO.class);
	 * BeanUtils.copyProperties(menu, menuVO);
	 * menuVO.getSubMenuList().add(subMenuVO); roleMap.put(menuVO.getId(), menuVO);
	 * } } userDetailVO.setUserRole(roleMap.values());
	 * userDetailVO.setPermittedURLs(permittedURLs); session.close();
	 * 
	 * return userDetailVO; }
	 */
	@Override
	public Map<Integer, String> getRoleListByDepartmentId(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// Create query object.
		@SuppressWarnings("rawtypes")
		Query query = session.createNativeQuery(ROLE_LIST_BY_DEPARTMENT_ID);
		//		Query query = session.createQuery(ROLE_LIST_BY_DEPARTMENT_ID);
		query.setParameter("id", searchParams.getIntNum1());
		List roleList = query.getResultList();

		// preparing Map of role id as key and name as value
		Map<Integer, String> roleMap = new TreeMap<Integer, String>();
		for (Object dto : roleList) {
			Object[] obj = (Object[]) dto;
			int id = (Integer) obj[0];
			roleMap.put(Integer.valueOf(id), (String) obj[1]);
		}
		session.close();
		return roleMap;

	}

	@Override
	public Map<Integer, String> getDepartmentList() {
		Session session = sessionFactory.openSession();

		// Create query object.
		Query<Department> query = session.createQuery(DEPARTMENT_LIST, Department.class);
		List<Department> departmentDTOList = query.getResultList();
		// preparing Map of department id as key and name as value
		Map<Integer, String> departmentMap = new TreeMap<Integer, String>();
		for (Department dto : departmentDTOList) {
			departmentMap.put(dto.getId(), dto.getName());
		}
		session.close();
		return departmentMap;
	}

	@Override
	public Designation getDesignationIdByRoleNDepttId(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// Create query object.
		Query<Designation> query = session.createQuery(DESIGNATION_ID_BY_ROLEnDEPTT_ID, Designation.class);
		query.setParameter("roleId", searchParams.getIntNum1());
		query.setParameter("departmentId", searchParams.getIntNum2());
		Designation designation = query.getSingleResult();
		session.close();
		return designation;
	}

	@Override
	public Role getRoleById(SearchParams searchParams) {
		Session session = sessionFactory.openSession();

		// preparing query and setting parameter
		Query<Role> query = session.createQuery(ROLE_BY_ID, Role.class);
		query.setParameter("id", searchParams.getIntNum1());
		// execute query
		Role role = query.uniqueResult();
		session.close();
		return role;
	}

	@Override
	public Department getDepartmentById(SearchParams searchParams) {
		Session session = sessionFactory.openSession();
		Department department = session.get(Department.class, searchParams.getIntNum1());
		session.close();
		return department;
	}

	@Override
	public ResponseEntity<ServiceResponse> login(LoginVO loginVo) {
		return null;
	}

	@Override
	public SearchResult getRoleNDepartmentByDesignationId(SearchParams searchParams) {
		// TODO Auto-generated method stub
		return null;
	}
}
