package ptm.home.common.constant;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application_en_US.properties")
public class PropertiesConfig {

//	@Value("${spring.datasource.jndi-name}")
//	private String dataSource;
	@Value("${error.login.failed}")
	private String loginFailed;
	@Value("${error.login.account.locked}")
	private String loginAccountLocked;
	@Value("${error.login.account.deleted}")
	private String loginAccountDeleted;
	@Value("${employee.search.recordNumber}")
	private String employeeRecordNumber;
	@Value("${global.search.recordNumber}")
	private String globalRecordNumber;
	@Value("${global.user.defaultPassword}")
	private String defaultPassword;
	@Value("${global.login.rule.password}")
	private String passwordRule;
	@Value("${error.record.save}")
	private String errorSave;
	@Value("${error.record.delete}")
	private String errorDelete;
	@Value("${success.record.save}")
	private String successSave;
	@Value("${success.record.delete}")
	private String successDelete;
	@Value("${error.request.invalid}")
	private String invalidRequest;
	@Value("${employee.enabled.default.status}")
	private String empDefaultEnabledStatus;
	@Value("${global.status.true}")
	private String globalStatusTrue;
	@Value("${global.status.false}")
	private String globalStatusFalse;

	/*
	 * public String getDataSource() { return dataSource; }
	 * 
	 * public void setDataSource(String dataSource) { this.dataSource = dataSource;
	 * }
	 */

	public String getLoginFailed() {
		return loginFailed;
	}

	public void setLoginFailed(String loginFailed) {
		this.loginFailed = loginFailed;
	}

	public String getLoginAccountLocked() {
		return loginAccountLocked;
	}

	public void setLoginAccountLocked(String loginAccountLocked) {
		this.loginAccountLocked = loginAccountLocked;
	}

	public String getLoginAccountDeleted() {
		return loginAccountDeleted;
	}

	public void setLoginAccountDeleted(String loginAccountDeleted) {
		this.loginAccountDeleted = loginAccountDeleted;
	}

	public String getEmployeePersonalRecordNumber() {
		return employeeRecordNumber;
	}

	public void setEmployeePersonalRecordNumber(String employeeRecordNumber) {
		this.employeeRecordNumber = employeeRecordNumber;
	}

	public String getGlobalRecordNumber() {
		return globalRecordNumber;
	}

	public void setGlobalRecordNumber(String globalRecordNumber) {
		this.globalRecordNumber = globalRecordNumber;
	}

	public String getDefaultPassword() {
		return defaultPassword;
	}

	public void setDefaultPassword(String defaultPassword) {
		this.defaultPassword = defaultPassword;
	}

	public String getPasswordRule() {
		return passwordRule;
	}

	public void setPasswordRule(String passwordRule) {
		this.passwordRule = passwordRule;
	}

	public String getErrorSave() {
		return errorSave;
	}

	public void setErrorSave(String errorSave) {
		this.errorSave = errorSave;
	}

	public String getSuccessSave() {
		return successSave;
	}

	public void setSuccessSave(String successSave) {
		this.successSave = successSave;
	}

	public String getErrorDelete() {
		return errorDelete;
	}

	public void setErrorDelete(String errorDelete) {
		this.errorDelete = errorDelete;
	}

	public String getSuccessDelete() {
		return successDelete;
	}

	public void setSuccessDelete(String successDelete) {
		this.successDelete = successDelete;
	}

	public String getInvalidRequest() {
		return invalidRequest;
	}

	public void setInvalidRequest(String invalidRequest) {
		this.invalidRequest = invalidRequest;
	}

	public String getEmployeeRecordNumber() {
		return employeeRecordNumber;
	}

	public void setEmployeeRecordNumber(String employeeRecordNumber) {
		this.employeeRecordNumber = employeeRecordNumber;
	}

	public String getEmpDefaultEnabledStatus() {
		return empDefaultEnabledStatus;
	}

	public void setEmpDefaultEnabledStatus(String empDefaultEnabledStatus) {
		this.empDefaultEnabledStatus = empDefaultEnabledStatus;
	}

	public String getGlobalStatusTrue() {
		return globalStatusTrue;
	}

	public void setGlobalStatusTrue(String globalStatusTrue) {
		this.globalStatusTrue = globalStatusTrue;
	}

	public String getGlobalStatusFalse() {
		return globalStatusFalse;
	}

	public void setGlobalStatusFalse(String globalStatusFalse) {
		this.globalStatusFalse = globalStatusFalse;
	}

	/*
	 * public String getHibernateHbm2Ddl() { return hibernateHbm2Ddl; }
	 * 
	 * public void setHibernateHbm2Ddl(String hibernateHbm2Ddl) {
	 * this.hibernateHbm2Ddl = hibernateHbm2Ddl; }
	 * 
	 * public String getHibernateDialect() { return hibernateDialect; }
	 * 
	 * public void setHibernateDialect(String hibernateDialect) {
	 * this.hibernateDialect = hibernateDialect; }
	 * 
	 * public String getHibernateShowSql() { return hibernateShowSql; }
	 * 
	 * public void setHibernateShowSql(String hibernateShowSql) {
	 * this.hibernateShowSql = hibernateShowSql; }
	 * 
	 * public String getHibernateEntityDir() { return hibernateEntityDir; }
	 * 
	 * public void setHibernateEntityDir(String hibernateEntityDir) {
	 * this.hibernateEntityDir = hibernateEntityDir; }
	 * 
	 * public String getHibernateGlobalIdentifiers() { return
	 * hibernateGlobalIdentifiers; }
	 * 
	 * public void setHibernateGlobalIdentifiers(String hibernateGlobalIdentifiers)
	 * { this.hibernateGlobalIdentifiers = hibernateGlobalIdentifiers; }
	 */
}
