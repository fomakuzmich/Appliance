package by.fomkin.homework_appliance.bean;

import java.io.Serializable;
import java.util.Objects;

public class Appliance implements Serializable {

	private static final long serialVersionUID = 1L;

	private String groupName;

	public Appliance() {
	}

	public Appliance(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Appliance other = (Appliance) obj;
		return Objects.equals(groupName, other.groupName);
	}

	@Override
	public String toString() {
		return getClass().getName() + " [groupName=" + groupName + "]";
	}

}
