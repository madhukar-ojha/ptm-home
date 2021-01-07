package ptm.home.common.constant;

public interface StringConstants {
	String MSG = "msg";
	String TRUE = "true";
	String FALSE = "false";
	String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

	// Hibernate config key
	String HIBERNATE_PROPERTIES_FILE = "hibernate/hibernate.properties";
	String HIBERNATE_ENTITY_DIR = "ptm.home.common.entity";
//	String DATA_SOURCE = "server.tomcat.jndi.datasource";

	// It carries role n privileges value from table 'menu' column 'menuKey'
	// These values will be used in various jsp pages to find MainMenu map objects.
	// These values will be used as key in mainmenumap object.
	String EMPLOYEE_MENU = "menu.employee";
	String CLIENT_MENU = "menu.client";
	String PROJECT_MENU = "menu.project";

	// It carries role n privileges value from table 'submenu_command' column
	// 'actionKey'
	// These values will be used in various jsp pages to find SubMenu map objects.
	// These values will be used as key in submenumap object.
	String EMPLOYEE_SUB_MENU_SAVE = "empSave";
	String EMPLOYEE_SUB_MENU_UPDATE = "empUpdate";
	String EMPLOYEE_SUB_MENU_DELETE = "empDelete";
	String EMPLOYEE_SUB_MENU_SEARCH = "empSearch";
	String EMPLOYEE_SUB_MENU_RESET_PASSWORD = "empResetPassword";
	
	// Environment constants
	String APP_ENV_DEV = "dev";
	String APP_ENV_TEST = "test";
	String APP_ENV_PROD = "prod";
	
	// JNDI name is defined in environment specific application-{env name}.properties file.
	// env name is set in spring.profiles.active parameter. e.g. 
	// java -Dspring.profiles.active=dev
	String APP_JNDI_KEY_NAME = "spring.datasource.jndi-name";

}
