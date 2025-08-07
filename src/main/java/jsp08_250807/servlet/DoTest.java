package jsp08_250807.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class DoTest
 */
//@WebServlet("*.do")
public class DoTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTest() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	// 여러개 요청을 .do 요청을 받아서 처리할 수도 있다!
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("*.do 형식으로 받음");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI(); // 클라이언트가 요청한 url 가져오기
		// 가져온 주소 jsp08_250807/login.jsp
		// 여기서 login.jsp만 가져와야 함
		String con = request.getContextPath(); // con이 의미하는 건 요청 URI에서 요청의 컨텍스트를 나타내는 부분을 반환 (login.jsp 앞! 부분!)(/프로젝트이름)
		String command = uri.substring(con.length()); // /login.do
		
		String viewPage = "";
		if (command.equals("/login.do")) {
			viewPage = "login.jsp"; // 실제 실행 할 파일 적어주기

		} else if (command.equals("/loginOk.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			if (id.equals("admin") && pw.equals("123456")) {
				HttpSession session = request.getSession();
				session.setAttribute("sid", id); 
				viewPage = "loginwelcome.jsp";
			} else {
				request.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못 되었습니다. 다시 확인하세요.");
				viewPage = "login.jsp";
			}
		}	
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
