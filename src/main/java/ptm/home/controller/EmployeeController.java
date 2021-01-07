package ptm.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ptm.home.vo.LoginVO;
import ptm.home.reqprocessor.EmployeeReqProcessor;
import ptm.home.vo.EmployeeJSonVO;
import ptm.home.vo.EmployeeVO;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	// temprary variable to inspect EmployeePersonalController object count
	private static int t_count;

	public EmployeeController() {
		System.out.println("EmployeeController--- " + ++t_count);
	}

	@Autowired
	private EmployeeReqProcessor employeeReqProcessor;

	@GetMapping
	public String home(ModelMap modelMap, HttpSession session) {
		return employeeReqProcessor.home(modelMap, session);
	}

	@GetMapping(path = "/save")
	public String addEmployee(@RequestParam("action") String action, EmployeeVO employeeVO, ModelMap modelMap,
							  HttpSession session) {
		return employeeReqProcessor.addEmployee(employeeVO, action, modelMap, session);
	}

	@PostMapping(path = { "/save", "/update" })
	public String saveOrUpdateEmployee(EmployeeVO employeeVO, BindingResult bindingResult, ModelMap modelMap,
									   HttpSession session) {
		return employeeReqProcessor.saveOrUpdateEmployee(employeeVO, bindingResult, modelMap, session);
	}

	@GetMapping(path = "/searchpage")
	public String searchPage(@RequestParam("action") String action, ModelMap modelMap, HttpSession session) {
		return employeeReqProcessor.searchPage(action, modelMap, session);
	}

	@GetMapping(path = "/search")
	public String getEmployeeDetailsById(@RequestParam("id") int id, @RequestParam("action") String action,
			ModelMap modelMap, HttpSession session) {
		return employeeReqProcessor.getEmployeeDetailsById(id, action, modelMap, session);
	}

	@GetMapping(path = "/search", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EmployeeJSonVO> getEmployeeDetailsById(@RequestParam("id") int id) {
		EmployeeJSonVO employeeJSonVO = employeeReqProcessor.getEmployeeDetailsByIdAsJson(id);
		return new ResponseEntity<EmployeeJSonVO>(employeeJSonVO, HttpStatus.OK);
	}

	@PostMapping(path = { "/delete" })
	public String deleteEmployeeById(EmployeeVO employeeVO, ModelMap modelMap, HttpSession session) {
		return employeeReqProcessor.deleteEmployeeById(employeeVO, modelMap, session);
	}

	@PostMapping(path = { "/resetpassword" })
	public String resetPassword(LoginVO loginVO, ModelMap modelMap, HttpSession session) {
		return employeeReqProcessor.resetPassword(loginVO, modelMap, session);
	}
}
