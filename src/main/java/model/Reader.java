package model;
import java.io.Serializable;

public class Reader implements Serializable {
	private static final long serialVersionUID = 605716303499853723L;
	String name;
	String surname;
	int id;

	
	public Reader(String name, String surname, int id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String imie) {
		this.name = imie;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public int getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reader other = (Reader) obj;
		if (id != other.getId())
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		if (surname == null) {
			if (other.getSurname() != null)
				return false;
		} else if (!surname.equals(other.getSurname()))
			return false;
		return true;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	@Override
	public String toString() {
		return name + " " + surname + ", id=" + id;
	}
		
}
