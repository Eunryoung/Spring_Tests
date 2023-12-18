package com.itwillbs.test1;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 컨트롤러 역할을 수행할 스프링의 클래스는 @Controller 어노테이션을 적용하여 정의
 * => 해당 클래스 내의 각각의 메서드를 통해 서블릿 주소(URL) 매핑 수행이 가능하다!
 */


@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	// @RequestMapping -> @WebServlet과 동일하다고 보면 된다
	// value = URL, method = get, post등의 방식
	/*
	 * @RequestMapping 어노테이션을 사용하여 URL 매핑 수행 가능
	 * => @RequestMapping(value = "매핑주소", method = RequestMethod.GET 또는 RequestMethod.POST)
	 * 	  public 리턴타입 메서드명([파라미터...]) {   }
	 * 	  => 이 때, 어노테이션 아래 메서드는 해당 매핑 주소 요청 시 자동으로 호출되는 메서드를 정의 
	 * 	  => 메서드명은 무관(자동으로 톰캣(스프링)에 의해 호출됨)
	 * 	  => 리턴타입은 별다른 사항이 없을 경우 String 타입 지정
	 *       (메서드 내에서 return 문을 통해 포워딩 할 경로 지정 시 String 타입 경로 리턴)
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home"; // webapp/WEB-INF/views/home.jsp 페이지로 포워딩(디스패치)
		// => servlet-context.xml 파일에 기술된 InternalResourceViewResolver에 의해
		//	  prefix 값과 suffix 값을 return 문 뒤의 문자열과 결합하여 포워딩할 페이지 경로 생성함
		// => 즉, return "home"; 지정 시 "/WEB-INF/views/" + "home" + ".jsp" 문자열이 결합되어
		//	  하나의 문자열("WEB-INF/views/home.jsp")로 생성됨
		// => 이 때, 디스패치 방식 포워딩을 처리할 DispatcherServlet 객체에 의해 포워딩이 이루어진다!
		//	  결국, webapp/WEB-INF/views/home.jsp 페이지로 포워딩 됨
		
//		return "index";
	}
		
	// "/main" 서블릿 주소 요청 시(GET)
	// webapp/WEB-INF/views/index.jsp 페이지로 포워딩(디스패치)
	@RequestMapping(value = "/main", method = RequestMethod.GET) // RequestMethod는 열거타입(상수관리)
	public String main() {
		return "index"; // webapp/WEB-INF/views/index.jsp
	}
	
	// "/test" 서블릿 주소 요청 시(GET)
	// webapp/WEB-INF/views/test/test1.jsp 페이지로 포워딩(디스패치)
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() {
		return "test/test1"; // webapp/WEB-INF/views/test/test1.jsp
		// views 디렉터리 아래에 서브디렉터리 존재 시 서브디렉터리부터 기술
	}

	@RequestMapping(value = "/BoardWrite", method = RequestMethod.GET)
	public String boardWrite() {
		// 글쓰기.... 생략
		// "BoardList" 서블릿 주소로 포워딩(리다이렉트)
		// redirect:/ 명시하면 리다이렉트 방식, 명시하지않으면 디스패치 방식
		return "redirect:/BoardList";
	}
	
}
