package ptm.home.listener;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception { //
	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/*
	 * private boolean isAuthorizedRequest(UserDetailVO userDetail,
	 * HttpServletRequest request) { MainMenu mainMenu = getMainMenu(userDetail,
	 * request); if (mainMenu != null) { return true; } return false; }
	 */

	/*
	 * private MainMenu getMainMenu(UserDetailVO userDetail, HttpServletRequest
	 * request) { SubMenuAndCommand subMenuAndCommand = null; String uri =
	 * request.getRequestURI(); for (MainMenu mainMenu :
	 * userDetail.getRole().getMainMenuMap().values()) { if
	 * (uri.endsWith(mainMenu.getMenuUrl())) { setSubMenuAndCommandCSS(request,
	 * mainMenu); return mainMenu; } else { subMenuAndCommand =
	 * getSubMenuAndCommand(mainMenu, request.getRequestURI()); if
	 * (subMenuAndCommand != null) { return mainMenu; } } } return null; }
	 */

	/*
	 * private SubMenuAndCommand getSubMenuAndCommand(MainMenu mainMenu, String uri)
	 * { for (SubMenuAndCommand subMenuAndCommand :
	 * mainMenu.getSubMenuMap().values()) { if
	 * (uri.endsWith(subMenuAndCommand.getSubMenuUrl())) { return subMenuAndCommand;
	 * } } return null; }
	 * 
	 * private void setSubMenuAndCommandCSS(HttpServletRequest request, MainMenu
	 * mainMenu) { String actionType = null; for (SubMenuAndCommand command :
	 * mainMenu.getSubMenuMap().values()) { actionType = command.getActionType();
	 * subMenuAndCommandCSS.setVisibilityStatus(actionType); }
	 * request.setAttribute("subMenuCSS", subMenuAndCommandCSS); }
	 */

}
