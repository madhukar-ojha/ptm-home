package ptm.home.reqprocessor;

import ptm.home.vo.LoginVO;
import ptm.home.vo.UserDetailVO;
import ptm.home.common.constant.PropertiesConfig;
import ptm.home.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static ptm.home.common.constant.JspViewConstants.*;
import static ptm.home.common.constant.ParamConstants.LOGIN_VO;
import static ptm.home.common.constant.ParamConstants.USER_DETAIL_VO;
import static ptm.home.common.constant.StringConstants.MSG;

@Component
public class LoginReqProcessor {
	static int t_count;

	public LoginReqProcessor() {
	}

	@Autowired
	private PropertiesConfig appConfigProp;
	@Autowired
	private LoginService userRoleService;
	@Autowired
	private LoginVO loginVO;
	
	public String welcome(ModelMap model) {
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		model.addAttribute(LOGIN_VO, loginVO);
		model.addAttribute("name", "Madhukar Ojha");
		return LOGIN;
	}

	public String login(LoginVO loginVO, BindingResult bindingResult, ModelMap modelMap, HttpServletRequest request) {
		HttpSession session;
		// Checking request binding result
		if (bindingResult.hasErrors()) {
			return LOGIN;
		}
	//	UserDetailVO userDetailVO = (UserDetailVO)userRoleService.login(loginVO).getBody().getSuccessResponse().getResponse();
		UserDetailVO userDetailVO = null;
		if (!isValidLoginResponse(userDetailVO, modelMap, bindingResult)) {
		//	return LOGIN;
			return HOME;
		} else if (isDefaultPassword(loginVO, modelMap)) {
			return CHANGE_PASSWORD;
		}
		session = request.getSession();
		session.setAttribute(USER_DETAIL_VO, userDetailVO);
		return HOME;
	}

	public String logout(ModelMap model, HttpServletRequest request) {
		request.getSession(false).invalidate();
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		model.addAttribute(LOGIN_VO, loginVO);
		return REDIRECT_HOME_PAGE;
	}

	public ModelAndView loginException(RuntimeException loginException) {
		ModelAndView modelMap = new ModelAndView();
		loginException.printStackTrace();
		if (loginException instanceof EmptyResultDataAccessException) {
			modelMap.addObject(MSG, appConfigProp.getLoginFailed());
		} else {
			modelMap.addObject(MSG, loginException.getMessage());
		}
		loginVO.setId(101);
		loginVO.setPassword("ptmpwd");
		modelMap.addObject(LOGIN_VO, loginVO);
		modelMap.setViewName(LOGIN);
		return modelMap;
	}

	private boolean isValidLoginResponse(UserDetailVO userDetailVO, ModelMap modelMap, BindingResult bindingResult) {
		if (userDetailVO == null) {
			bindingResult.reject("error.login.failed");
			return false;
		} else if (!userDetailVO.getEnabled()) {
			bindingResult.reject("error.login.account.locked");
			return false;
		}
		return true;
	}

	private boolean isDefaultPassword(LoginVO loginVO, ModelMap modelMap) {
		if (appConfigProp.getDefaultPassword().equals(loginVO.getPassword())) {
			loginVO.setPassword(null);
			modelMap.addAttribute(LOGIN_VO, loginVO);
			return true;
		}
		return false;
	}
}
