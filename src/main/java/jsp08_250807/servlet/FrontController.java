package jsp08_250807.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do") // .do로 오는 요청은 여기서 다 받겠다는 뜻
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public FrontController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 폼에서 .do로 액션 보내면 method="get/post"냐에 따라서 doGet,doPost 메서드로 들어옴
		// 하지만 둘 다 doProcess로 보냄. 따라서 폼에서 받은 값(id, pw)이 doProcess(request)에 저장됨
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI(); // uri = /프로젝트이름/폼에서보낸.do
		String con = request.getContextPath(); // con = /프로젝트
		String command = uri.substring(con.length()); // command = /폼에서보낸.do
		// 결론 /login.do 찾음		
		
		HttpSession session = null; // 인터페이스라서 객체 생성 불가
		String viewPage = ""; // 클라이언트에게 전송 될 실제 jsp 파일 이름이 저장되는 변수
		if (command.equals("/loginOk.do")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			if (id.equals("admin") && pw.equals("123456")) {
				session = request.getSession(); // request.get 이용해서 session 가져오기
				session.setAttribute("sid", id);
				request.setAttribute("elid", id); // el 사용할 수 있게
				//request.sendRedirect();는 페이지 이동만 할 뿐 매개변수의 값을 보낼 수 없기 때문에 사용 불가.
				viewPage = "loginwelcome.jsp";
			} else { 
				request.setAttribute("msg", "아이디 또는 비밀번호가 잘못 되었습니다!");
				viewPage = "login.jsp";
			}
		} else if (command.equals("/login.do")) {
			viewPage = "login.jsp";
		} else if (command.equals("/welcome.do")) {
			session = request.getSession();
			request.setAttribute("elid", session.getAttribute("sid")); // 뒤로 가도 [회원 아이디]님 환영합니다가 뜨게 할 때
			//(String) 형변환을 해야하나? *******************************************
			viewPage = "loginwelcome.jsp";
		} else if (command.equals("/logout.do")) { // 로그아웃
			session = request.getSession(); // 세션값 가져오는 거 잊지 말기(로그인한 상태를 가져와야 로그아웃을 하니까)
			session.invalidate();
			request.setAttribute("msg", "로그아웃 되었습니다!");
			viewPage = "login.jsp";
		}
		// 가입한 회원 목록 보기(더미 데이터 이용)
		 else if (command.equals("/member.do")) {
			List<MemberDto> memberList = new ArrayList<MemberDto>();
			memberList.add(new MemberDto("Kim", "김민지", 17, "2025-03-01"));
			memberList.add(new MemberDto("Choi", "최현지", 19, "2025-04-09"));
			memberList.add(new MemberDto("Park", "박지연", 21, "2025-04-11"));
			memberList.add(new MemberDto("Han", "한혜선", 27, "2025-05-05"));
			memberList.add(new MemberDto("Jeong", "정수연", 31, "2025-06-20"));
			request.setAttribute("memberLists", memberList);
			viewPage = "memberList.jsp";
				}
		// 게시판으로 이동하기 (더미 데이터 이용)
		 else if (command.equals("/board.do")) {
			session = request.getSession();
			List<BoardDto> boardList = new ArrayList<BoardDto>();
			boardList.add(new BoardDto("첫글입니다", "김민지", "2024-08-01"));
			boardList.add(new BoardDto("두번째 글이다! 야호!", "박지연", "2024-08-01"));
			boardList.add(new BoardDto("반갑습니다 안녕하세요", "정수연", "2024-08-02"));
			boardList.add(new BoardDto("저는 여름보다 겨울이 좋아요.", "정수연", "2024-08-03"));
			boardList.add(new BoardDto("코딩 공부 화이팅", "최현지", "2024-08-04"));
			request.setAttribute("boardLists", boardList); // request 객체에 게시판 목록 싣기
			viewPage = "boardList.jsp";
		}
		// 로그인 성공 또는 실패 뭘하든 viewPage로 보내야 함. request.sendRedirect(); 쓰고 싶겠지만 매개변수 값 못 보냄(위에 있음)
		// request 객체를 포함해서 이동을 하기 위해서는 RequestDispatcher 인터페이스를 이용하면 된다.  
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
}
}
