package lk.ijse.dep8.tasks.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@PropertySource("classpath:application.properties")
@PropertySource("classpath:application-prod.properties")
public class HibernateConfig {


    private final Environment env;

    public HibernateConfig(Environment env){
        this.env=env;
    }

    public LocalSessionFactoryBean sessionFactory(DataSource ds){
        LocalSessionFactoryBean lsfb = new LocalSessionFactoryBean();
        lsfb.setDataSource(ds);
        lsfb.setPackagesToScan("lk.ijse.dep8.tasks.entity");
        lsfb.setHibernateProperties(hibernateProperties());
        return lsfb;

    }
    @Bean
    public DataSource dataSource(){
        JndiObjectFactoryBean jndiDataSource = new JndiObjectFactoryBean();
        jndiDataSource.setJndiName("java:comp/env/jdbc/pool");
        return (DataSource) jndiDataSource.getObject();

    }

    private Properties hibernateProperties(){
        Properties props=new Properties();
        props.put("hibernate.dialect",env.getRequiredProperty("hibernate.dialect"));
        props.put("hibernate.allow_refresh_detached_entity",env.getRequiredProperty("hibernate.allow_refresh_detached_entity"));
        return props;
    }
}
