package jsp08_250807.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

// 방법1. 패키지에 Class로 만들거나
// 방법2. 패키지에 Servlet으로 만들거나 (추천)



@WebServlet
public class ServletClass extends HttpServlet {
	// HttpServlet 상속 받아서 사용
	// 애노테이션 @WebServlet 해주기
}
