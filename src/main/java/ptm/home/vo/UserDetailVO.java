package ptm.home.vo;

import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.*;

/**
 * This class stores user personal and roles and privileges details.
 * 
 * @author asus
 *
 */
@Component
public class UserDetailVO implements Serializable{
	private int id;
	private String displayName;
	private String designationName;
	private boolean enabled;

	// This variable contains user role details
	private Collection<MenuVO> userRole = new ArrayList<MenuVO>();

	// This utility map is derived from userRole, used to display menu and submenu
	// on home page header. Key is PtmMainApplication menu name and value is list of its sub
	// menus.
	private Map<String, TreeSet<SubMenuVO>> homeMap = new HashMap<String, TreeSet<SubMenuVO>>();

	// This utility set, derived from userRole, is collection of permitted urls. It
	// will be used in RequestInterceptor to check user authorizations.
	private Set<String> permittedURLs = new HashSet<String>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Map<String, TreeSet<SubMenuVO>> getHomeMap() {
		return homeMap;
	}

	public void setHomeMap(Map<String, TreeSet<SubMenuVO>> homeMap) {
		this.homeMap = homeMap;
	}

	public Collection<MenuVO> getUserRole() {
		return userRole;
	}

	public void setUserRole(Collection<MenuVO> userRole) {
		this.userRole = userRole;
	}

	public Set<String> getPermittedURLs() {
		return permittedURLs;
	}

	public void setPermittedURLs(Set<String> permittedURLs) {
		this.permittedURLs = permittedURLs;
	}

}
