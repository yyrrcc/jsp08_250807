package jsp08_250807.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/loginOk")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("로그인 호출");
		String id = request.getParameter("id");
		//System.out.println("폼에서 넘겨 받은 아이디: " + id);
		String pw = request.getParameter("pw");
		//System.out.println("폼에서 넘겨 받은 비밀번호: " + pw);
		
		if (id.equals("admin") && pw.equals("123456")) {
			// 여기서는 세션이 내장되어 있지 않기 때문에 생성을 해줘야 함
			HttpSession session = request.getSession(); // session 생성
			session.setAttribute("sid", id); // session에 id값 저장
			response.sendRedirect("loginwelcome.jsp"); // 성공 시 페이지 이동
		} else { // 로그인 실패
			// 1. 실패한 아이디 넘어가고 loginfail 페이지 열어주기
			//request.setAttribute("failedId", id); // 폼에서 넘어온 아이디 가져오기(로그인 실패한 아이디)
			//request.getRequestDispatcher("loginfail.jsp").forward(request, response);
			// jsp파일로 이동. 그때 가지고 있는 request와 response의 값들을 가지고 간다
			
			// 2. 로그인 실패 시 나오는 메시지 출력
			request.setAttribute("errorMsg", "아이디 또는 비밀번호가 잘못 되었습니다. 다시 확인하세요.");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post 방식으로 받음");
		doGet(request, response);
	}

}
