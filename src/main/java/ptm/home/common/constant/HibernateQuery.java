package ptm.home.common.constant;

public interface HibernateQuery {

	String LOAD_PROXY = "true";

	String USER_LOGIN = "From Employee where id = :id and password = :password";

	// Update password
	String UPDATE_PASSWORD = "UPDATE Employee set password=:password WHERE id=:id";

	// Retrieves role list by department id
	String ROLE_LIST_BY_DEPARTMENT_ID = "SELECT r.id, r.NAME FROM role r INNER JOIN designation d ON r.id = d.role_id "
			+ "AND department_id = :id";

	String ROLE_BY_ID = "From Role where id =:id";

	// Retrieves department list
	String DEPARTMENT_LIST = "FROM Department";

	String DESIGNATION_ID_BY_ROLEnDEPTT_ID = "From Designation WHERE role.id =:roleId AND department.id =:departmentId";

	// Search role id and department id by designation id
	String ROLEnDEPTT_SEARCH_BY_DESIGNATION_ID = "SELECT role_id as role, department_id as department FROM designation "
			+ "WHERE id =:intNum1";

	// Delete employee by id
	String EMPLOYEE_DELETE_BY_ID = "DELETE From Employee WHERE id=:id";

	// Retrieves employee details by id
	String EMPLOYEE_DETAILS_BY_ID = "From Employee WHERE id=:id";
	// Retrieves list of states
	String INDIA_STATE_LIST = "From IndiaState";

}
