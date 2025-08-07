package jsp08_250807.servlet;

public class MemberDto {
	private String id;
	private String name;
	private int age;
	private String regDate;
	public MemberDto() {
		super();
	}
	public MemberDto(String id, String name, int age, String regDate) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.regDate = regDate;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	
	
	
}
