package ptm.home.reqprocessor;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.context.annotation.RequestScope;
import ptm.home.common.constant.PropertiesConfig;
import ptm.home.common.pojo.SearchParams;
import ptm.home.common.util.AppMethodUtils;
import ptm.home.vo.*;
import ptm.home.converter.hibernate.CurrentUser;
import ptm.home.service.EmployeeService;
import ptm.home.service.LoginService;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static ptm.home.common.constant.JspViewConstants.*;
import static ptm.home.common.constant.ParamConstants.*;
import static ptm.home.common.constant.StringConstants.*;

@Component
@RequestScope
public class EmployeeReqProcessor {
	static int t_count;

	public EmployeeReqProcessor() {
		System.out.println("");
	}

	@Autowired
	private PropertiesConfig AppConfigProp;
	@Autowired
	private SearchParams searchParams;
	@Autowired
	private LoginService loginRoleService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private LoginVO loginVO;

	public String home(ModelMap model, HttpSession session) {
		return HOME;
	}

	public String addEmployee(EmployeeVO employeeVO, String action, ModelMap model, HttpSession session) {
		prepareEmployeeVO(employeeVO, model, session);
		return EMPLOYEE_ADD_UPDATE;
	}

	public String getEmployeeDetailsById(int id, String action, ModelMap model, HttpSession session) {
		searchParams.setIntNum1(id);
		EmployeeVO employeeVO = employeeService.getEmployeeDetailsById(searchParams);
		employeeVO.setAction(action);
		prepareEmployeeVO(employeeVO, model, session);
		return EMPLOYEE_ADD_UPDATE;
	}

	public EmployeeJSonVO getEmployeeDetailsByIdAsJson(int id) {
		searchParams.setIntNum1(id);
		EmployeeVO employeeVO = employeeService.getEmployeeDetailsById(searchParams);
		if (employeeVO == null) {
			return null;
		}
		EmployeeJSonVO employeeJSonVO = BeanUtils.instantiate(EmployeeJSonVO.class);
		BeanUtils.copyProperties(employeeVO, employeeJSonVO);
		employeeJSonVO.setDateOfBirth(employeeVO.getDateOfBirth().toString());
		employeeJSonVO.setDesignation(employeeVO.getDesignation().getDesignationName());
		return employeeJSonVO;
	}

	public ResponseEntity<List<RoleListVO>> getRoleList(int departmentId) {
		searchParams.setIntNum1(departmentId);
		Map<Integer, String> roleMap = loginRoleService.getRoleListByDepartmentId(searchParams);
		List<RoleListVO> roleList = new ArrayList<RoleListVO>();
		RoleListVO roleListVO = null;
		for (Map.Entry<Integer, String> entry : roleMap.entrySet()) {
			roleListVO = new RoleListVO();
			roleListVO.setId(entry.getKey().toString());
			roleListVO.setName(entry.getValue());
			roleList.add(roleListVO);
		}
		return new ResponseEntity<List<RoleListVO>>(roleList, HttpStatus.OK);
	}

	public String saveOrUpdateEmployee(EmployeeVO employeeVO, BindingResult bindingResult, ModelMap modelMap,
			HttpSession session) {
		UserDetailVO userDetailVO = (UserDetailVO) session.getAttribute(USER_DETAIL_VO);
		// Checking request validation
		/*
		 * if (bindingResult.hasErrors()) { modelMap.addAttribute(MSG,
		 * AppConfigProp.getInvalidRequest()); // prepareEmployeePersonalVO(employeeVO,
		 * modelMap, session); // Clearing Deaprtment id and role id
		 * employeeVO.setDepartment(-1); employeeVO.setRole(-1); return
		 * EMPLOYEE_ADD_UPDATE; }
		 */

		searchParams.getRequestMap().put(EMP_ID, userDetailVO.getId());
		CurrentUser.INSTANCE.logIn(userDetailVO.getId());
		employeeService.saveOrUpdateEmployee(employeeVO, searchParams);
		CurrentUser.INSTANCE.logOut();
		setResponseMessage(1, modelMap, employeeVO.getAction());
		return home(modelMap, session);
	}

	public String deleteEmployeeById(EmployeeVO employeeVO, ModelMap modelMap, HttpSession session) {
		UserDetailVO userDetailVO = (UserDetailVO) session.getAttribute(USER_DETAIL_VO);
		int id = userDetailVO.getId();
		searchParams.setIntNum1(employeeVO.getId());
		int result = employeeService.deleteEmployeePersonal(searchParams);
		setResponseMessage(result, modelMap, EMPLOYEE_SUB_MENU_DELETE);
		return home(modelMap, session);
	}

	public String updatePassword(LoginVO loginVO, ModelMap modelMap) {
		if (AppConfigProp.getDefaultPassword().equalsIgnoreCase(loginVO.getPassword())) {
			modelMap.addAttribute(MSG, AppConfigProp.getPasswordRule());
			return CHANGE_PASSWORD;
		}
		updatePassword(loginVO);
		return LOGIN;
	}

	public String searchPage(String action, ModelMap modelMap, HttpSession session) {
		UserDetailVO userDetailVO = (UserDetailVO) session.getAttribute(USER_DETAIL_VO);
		SubMenuVO subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_UPDATE);
		if (subMenuVO != null) {
			modelMap.addAttribute(ACTION_UPDATE, subMenuVO);
			// TODO Seeting css style to make visible element on page
			modelMap.addAttribute(CSS_STYLE, CSS_VISIBILITY_HIDE);
		}
		subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_DELETE);
		if (subMenuVO != null) {
			modelMap.addAttribute(ACTION_DELETE, subMenuVO);
			// TODO Seeting css style to make visible element on page
			modelMap.addAttribute(CSS_STYLE, CSS_VISIBILITY_HIDE);
		}
		subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_RESET_PASSWORD);
		if (subMenuVO != null) {
			modelMap.addAttribute(ACTION_RESET, subMenuVO);
			// TODO Seeting css style to make visible element on page
			modelMap.addAttribute(CSS_STYLE, CSS_VISIBILITY_HIDE);
		}
		subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_SEARCH);

		// Preparing and setting search url
		modelMap.addAttribute(ACTION_SEARCH,
				new StringBuilder(session.getServletContext().getContextPath()).append(subMenuVO.getSubMenuUrl()));

		modelMap.addAttribute(LOGIN_VO, loginVO);
		return EMPLOYEE_SEARCH;

	}

	public String resetPassword(LoginVO loginVO, ModelMap modelMap, HttpSession session) {
		// Set password field to default password
		loginVO.setPassword(AppConfigProp.getDefaultPassword());
		int result = updatePassword(loginVO);
		setResponseMessage(result, modelMap, EMPLOYEE_SUB_MENU_UPDATE);
		return HOME;
	}

	private void prepareEmployeeVO(EmployeeVO employeeVO, ModelMap model, HttpSession session) {
		Map<Integer, String> departmentMap = loginRoleService.getDepartmentList();
		Map<Integer, String> indiaStateMap = employeeService.getIndiaStateList();
		employeeVO.setDepartmentMap(departmentMap);
		employeeVO.setStateMap(indiaStateMap);

		UserDetailVO userDetailVO = (UserDetailVO) session.getAttribute(USER_DETAIL_VO);
		SubMenuVO subMenuVO = null;
		if (EMPLOYEE_SUB_MENU_SAVE.equalsIgnoreCase(employeeVO.getAction())) {
			subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_SAVE);
		} else if (EMPLOYEE_SUB_MENU_UPDATE.equalsIgnoreCase(employeeVO.getAction())) {
			subMenuVO = AppMethodUtils.getSubMenuVO(userDetailVO, EMPLOYEE_MENU, EMPLOYEE_SUB_MENU_UPDATE);
			searchParams.setIntNum1(employeeVO.getDesignation().getDepartment().getId());
			Map<Integer, String> roleMap = loginRoleService.getRoleListByDepartmentId(searchParams);
			employeeVO.setRoleMap(roleMap);
			employeeVO.setRole(employeeVO.getDesignation().getRole().getId());
			employeeVO.setDepartment(employeeVO.getDesignation().getDepartment().getId());
		}
		model.addAttribute(ACTION, subMenuVO);
		model.addAttribute(EMPLOYEE_VO, employeeVO);
		// temporary method to populate employeeVO for testing purpose
		tmpPopulateEmployeeVO(employeeVO);
	}

	// temporary method to populate employeeVO for testing purpose
	private void tmpPopulateEmployeeVO(EmployeeVO employeeVO) {
		employeeVO.setId(110);
		employeeVO.setFirstName("Madhukar");
		employeeVO.setMiddleName("Gopal");
		employeeVO.setLastName("Ojha");
		employeeVO.setNickName("madhu");
	//	employeeVO.setGender(Gender.FEMALE);
		employeeVO.setDepartment(12);
		employeeVO.setRole(14);
		employeeVO.setDateOfBirth("1976-07-20");
		employeeVO.setFatherName("Madan Ojha");
		employeeVO.setMotherName("Bibha Ojha");
		employeeVO.setPhone("+91-123456789");
		employeeVO.setMobile("+91-9999889811");
		employeeVO.setEmail("madhukar.vns@gmail.com");
		employeeVO.setAddress("Faridabad");
		employeeVO.setPincode(121003);
		employeeVO.setState(15);
		employeeVO.setEnabled(false);
	}

	private void setResponseMessage(int result, ModelMap modelMap, String action) {
		if (result == 0) {
			modelMap.addAttribute(MSG, AppConfigProp.getErrorSave());
		} else if (EMPLOYEE_SUB_MENU_DELETE.equalsIgnoreCase(action)) {
			modelMap.addAttribute(MSG, AppConfigProp.getSuccessDelete());
		} else {
			modelMap.addAttribute(MSG, AppConfigProp.getSuccessSave());
		}
	}

	private int updatePassword(LoginVO loginVO) {
		int result = employeeService.updatePassword(loginVO);
		if (result == 0) {
			throw new RuntimeException();
		}
		return result;
	}
}
