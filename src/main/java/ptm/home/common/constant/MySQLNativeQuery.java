package ptm.home.common.constant;

public class MySQLNativeQuery {
	String USER_LOGIN = "SELECT e.id, e.displayName, e.designation_id, CONCAT(d.role_name, ' ', d.department_name) AS designation, e.enabled, e.deleted "
			+ "from employee e INNER JOIN designation d ON e.designation_id = d.id "
			+ "AND e.id=:id and e.password=:password";

	String USER_ROLE = "SELECT m.menuKey, m.menuName, m.menuUrl, mc.actionKey, mc.actionType, mc.subMenuKey, mc.subMenuName, mc.subMenuUrl, "
			+ "mc.commandKey, mc.commandName FROM submenu_command mc INNER JOIN designation_submenu_command dmc "
			+ "ON mc.id = dmc.submenu_command_id INNER JOIN menu m ON m.id = mc.menu_id "
			+ "WHERE dmc.designation_id=:designationId ORDER BY m.serialNo";

	// Add new employee
	String EMPLOYEE_SAVE = "INSERT INTO `ptm`.`employee` (`firstName`, `middleName`, `lastName`, `nickName`, `gender`, `password`, `designation_id`, `dateOfBirth`, `fatherName`, `motherName`, `phone`, `mobile`, `email`, `address`, `pincode`, india_state_list_id, `createdBy`) "
			+ "VALUES (:firstName, :middleName, :lastName, :nickName, :gender, :password, :designationId, :dateOfBirth, :fatherName, :motherName, :phone, :mobile, :email, :address, :pincode, :state, :createdBy);";

	// Update employee details
	String EMPLOYEE_UPDATE = "UPDATE `ptm`.`employee` SET firstName=:firstName, middleName=:middleName, lastName=:lastName, nickName=:nickName, designation_id=:designationId, "
			+ "gender=:gender, dateOfBirth=:dateOfBirth, fatherName=:fatherName, motherName=:motherName, phone=:phone, mobile=:mobile, "
			+ "email=:email, address=:address, pincode=:pincode, india_state_list_id=:state, enabled=:enabled WHERE id=:id;";

}
