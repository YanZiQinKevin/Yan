package day02;

import java.io.Serializable;

public class Dep implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int deptno;
	private String dname;
	private String location;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[" + deptno + "" + dname + "" + location + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + deptno;
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
		final Dep other = (Dep) obj;
		if (deptno != other.deptno)
			return false;
		return true;
	}

	public Dep() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDeptno() {
		return deptno;
	}

	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

}
