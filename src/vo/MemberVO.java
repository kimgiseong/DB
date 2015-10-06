package vo;

public class MemberVO {
	private String id;
	private String name;
	private String tel;
	private String add;
	
	public MemberVO(){}
	public MemberVO(String id, String name, String tel, String add) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.add = add;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", name=" + name + ", tel=" + tel
				+ ", add=" + add + "]";
	}
}
