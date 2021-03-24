package com.mosheyu.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

//代替上面的代码，配置配置文件
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfiguration {



    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")         //spring会将当前方法的返回值以指定名称储存到Spring容器中
    public DataSource getDataSource() throws PropertyVetoException, SQLException {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();         //创建对象
        dataSource.setDriverClass(driver);                  //设置驱动
        dataSource.setJdbcUrl(url);              //设置地址
        dataSource.setUser(username);                                             //设置用户名
        dataSource.setPassword(password);                                       //设置密码
        Connection connection = dataSource.getConnection();                     //获取资源
        return dataSource;
    }


}
