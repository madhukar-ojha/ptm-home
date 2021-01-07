package ptm.home.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
public class MenuVO implements Comparable<MenuVO>, Serializable {
	private static final long serialVersionUID = -4917660946378741179L;
	private int id;
	private String menuKey;
	private String menuName;
	private String menuUrl;
	private int sequenceNo;
	private Set<SubMenuVO> subMenuList = new HashSet<SubMenuVO>();

	@Override
	public int compareTo(MenuVO menuVO) {
		if (this.id < menuVO.id) {
			return -1;
		} else if (this.id == menuVO.id) {
			return 0;
		}
		return 1;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof MenuVO) {
			MenuVO menuVO = (MenuVO) obj;
			if (this.id == menuVO.id) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int hashCode = this.menuName.hashCode();
		return hashCode;
	}
}
