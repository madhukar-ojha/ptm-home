package ptm.home.exception;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {
	public static final String DEFAULT_ERROR_VIEW = "error";

	@ExceptionHandler(value = Exception.class)
	public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		// If the exception is annotated with @ResponseStatus rethrow it and let
		// the framework handle it - like the OrderNotFoundException example
		// at the start of this post.
		// AnnotationUtils is a Spring Framework utility class.
		if (AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null)
			throw e;

		// invalidate user session before sending to error page
//		if (req.getSession() != null) {
//			req.getSession().invalidate();
//		}
		// Otherwise setup and send the user to a default error-view.
		System.err.println(e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.setStatus(HttpStatus.FORBIDDEN);
		// mav.setViewName("redirect:/"+DEFAULT_ERRO00R_VIEW);
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) // 500
	@ExceptionHandler(value = RuntimeException.class)
	public ModelAndView handleConflict(HttpServletRequest req, Exception e) throws Exception {
		System.err.println(e.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", e.getMessage());
		mav.addObject("url", req.getRequestURL());
		mav.addObject("status", HttpStatus.FORBIDDEN);
		mav.setStatus(HttpStatus.FORBIDDEN); //
		// mav.setViewName("redirect:/" + DEFAULT_ERROR_VIEW);
		mav.setViewName(DEFAULT_ERROR_VIEW);
		return mav;
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public String exception(final Throwable throwable, final Model model) {
	//	String errorMessage = (throwable != null ? throwable.getMessage() : "Unknown error");
		System.err.println(throwable.getMessage());
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", throwable.getMessage());
//		mav.addObject("url", req.getRequestURL());
		mav.addObject("status", HttpStatus.FORBIDDEN);
		mav.setStatus(HttpStatus.FORBIDDEN);
		return DEFAULT_ERROR_VIEW;
	}

}