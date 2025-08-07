package jsp08_250807.servlet;

public class BoardDto {
	private String title; // 게시글 제목
	private String writer; // 글쓴이
	private String date; // 글쓴 날짜
	
	public BoardDto() {
		super();
	}
	
	public BoardDto(String title, String writer, String date) {
		super();
		this.title = title;
		this.writer = writer;
		this.date = date;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	
}
