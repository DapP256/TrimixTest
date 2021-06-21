package trimix.test.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(
		value= {
				@ComponentScan("trimix.test.dao"),
				@ComponentScan("trimix.test.service")
		}
		)
public class AppConfig {
	
	@Autowired
	private Environment enviroment;
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		properties.put(DRIVER, enviroment.getProperty("mysql.driver"));
		properties.put(URL, enviroment.getProperty("mysql.url"));
		properties.put(USER, enviroment.getProperty("mysql.user"));
		properties.put(PASS, enviroment.getProperty("mysql.password"));
		properties.put(SHOW_SQL, enviroment.getProperty("hibernate.show_sql"));
		properties.put(HBM2DDL_AUTO, enviroment.getProperty("hibernate.hbm2ddl.auto"));
		properties.put(C3P0_MIN_SIZE, enviroment.getProperty("hibernate.c3p0.min_size"));
		properties.put(C3P0_MAX_SIZE, enviroment.getProperty("hibernate.c3p0.max_size"));
		properties.put(C3P0_ACQUIRE_INCREMENT, enviroment.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put(C3P0_TIMEOUT, enviroment.getProperty("hibernate.c3p0.timeout"));
		properties.put(C3P0_MAX_STATEMENTS, enviroment.getProperty("hibernate.c3p0.max_statements"));
		factoryBean.setHibernateProperties(properties);
		factoryBean.setPackagesToScan("trimix.test.model");
		
		return factoryBean;
		
	}
	
	@Bean
	public HibernateTransactionManager getTransactionManager() {
		
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		
		return transactionManager;
		
	}
}
