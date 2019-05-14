package pojo;

public class Entity {
	
	private int id;
	private String date;
	
	public Entity() {
	}

	public Entity(int id, String date) {
		this.id = id;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return  id + "___" + date.replaceAll("\\s+", "-") + "___";
	}
	

}
