package com.squirrel.springcloud.squirrel.common.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * druid 配置
 * Created by JoinHan on 2017/4/14.
 */
@Configuration
@MapperScan(basePackages ="com.squirrel.springcloud.squirrel.modules.**.dao", sqlSessionFactoryRef = "sqlSessionFactory")
public class DruidConfig {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * master DataSource
     * @Primary 注解用于标识默认使用的 DataSource Bean，因为有多个 DataSource Bean，该注解可用于 master
     * 或 slave DataSource Bean, 但不能用于 dynamicDataSource Bean, 否则会产生循环调用
     *
     * @ConfigurationProperties 注解用于从 application.properties 文件中读取配置，为 Bean 设置属性
     * @return data source
     */
    @Bean("master")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource master() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


    @Bean(name="MasterServletRegistrationBean")
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
        reg.addUrlMappings("/druid1/*");

        /*reg.addInitParameter("loginUsername", "druid");
        reg.addInitParameter("loginPassword", "jiajian123456");*/
        return reg;
    }

    @Bean(name="MasterFilterRegistrationBean")
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid1/*");
        filterRegistrationBean.addInitParameter("profileEnable", "true");
        filterRegistrationBean.addInitParameter("principalCookieName", "USER_COOKIE");
        filterRegistrationBean.addInitParameter("principalSessionName", "USER_SESSION");
        return filterRegistrationBean;
    }

}