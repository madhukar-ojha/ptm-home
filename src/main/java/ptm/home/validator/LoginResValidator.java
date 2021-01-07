package ptm.home.validator;

import ptm.home.vo.UserDetailVO;
import ptm.home.common.constant.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import static ptm.home.common.constant.StringConstants.FALSE;

@Component
public class LoginResValidator implements Validator {
	@Autowired
	private PropertiesConfig appConfigProp;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDetailVO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDetailVO userDetailVO = (UserDetailVO) target;
		if (userDetailVO == null) {
			errors.reject("error.login.failed");
		} else if (FALSE.toString().equals(userDetailVO.getEnabled())) {
			errors.reject("error.login.account.locked");
		}
		/*
		 * if (userDetail == null) { throw new
		 * RuntimeException(appConfigProp.getLoginFailed()); } else if
		 * (FALSE.toString().equals(userDetail.getEnabled())) { throw new
		 * RuntimeException(appConfigProp.getLoginAccountLocked()); }
		 */
	}
}
