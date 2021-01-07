package ptm.home.vo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class SubMenuVO implements Comparable<SubMenuVO>, Serializable {
	private int id;
	private String actionKey;
	private String actionType;
	private String subMenuName;
	private String subMenuUrl;
	private String commandName;
	private int index;
	private Set<SubMenuVO> subMenuDependencySet = new HashSet<SubMenuVO>(0);

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getActionKey() {
		return actionKey;
	}

	public void setActionKey(String actionKey) {
		this.actionKey = actionKey;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getSubMenuUrl() {
		return subMenuUrl;
	}

	public void setSubMenuUrl(String subMenuUrl) {
		this.subMenuUrl = subMenuUrl;
	}

	public String getSubMenuName() {
		return subMenuName;
	}

	public void setSubMenuName(String subMenuName) {
		this.subMenuName = subMenuName;
	}

	public String getCommandName() {
		return commandName;
	}

	public void setCommandName(String commandName) {
		this.commandName = commandName;
	}

	public Set<SubMenuVO> getSubMenuDependencySet() {
		return subMenuDependencySet;
	}

	public void setSubMenuDependencySet(Set<SubMenuVO> subMenuDependencySet) {
		this.subMenuDependencySet = subMenuDependencySet;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof SubMenuVO) {
			SubMenuVO subMenuVO = (SubMenuVO) obj;
			if (this.id == subMenuVO.id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = this.actionKey.hashCode();
		return hashCode;
	}

	@Override
	public int compareTo(SubMenuVO subMenuVO) {
		if (this.getId() < subMenuVO.getId()) {
			return -1;
		} else if (this.getId() == subMenuVO.getId()) {
			return 0;
		}
		return 1;
	}

}
