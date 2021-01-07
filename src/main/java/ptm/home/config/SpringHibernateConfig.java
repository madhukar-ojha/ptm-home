package ptm.home.config;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static ptm.home.common.constant.StringConstants.HIBERNATE_ENTITY_DIR;
import static ptm.home.common.constant.StringConstants.HIBERNATE_PROPERTIES_FILE;

@Component
public class SpringHibernateConfig {
	
	@Autowired DataSource dataSource;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setPackagesToScan(HIBERNATE_ENTITY_DIR);
		factoryBean.setHibernateProperties(getHibernateProperties());
		factoryBean.setDataSource(dataSource); 
		return factoryBean;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);
		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		try {
			InputStream inputStream = getClass().getClassLoader().getResourceAsStream(HIBERNATE_PROPERTIES_FILE);
			properties.load(inputStream);
		} catch (IOException e) {
			System.out.println("File hibernate.properties not found");
			e.printStackTrace();
		}
		return properties;
	}

}
