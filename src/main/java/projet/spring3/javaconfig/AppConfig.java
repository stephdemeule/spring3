package projet.spring3.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@Import(OtherConfig.class)
// XML: <import resource="classpath:events/events.xml")
@ImportResource(value="classpath:events.xml")
// XML: <context:property-placeholder location="classpath:message.properties"/>
@PropertySource(value="classpath:message.properties")
// XML: <context:component-scan base-package="com.apress.prospring3.ch5.context"/>
@ComponentScan(basePackages={"projet.spring3.context"})
@EnableTransactionManagement
public class AppConfig {

    @Autowired
    Environment env;

    @Bean
    @Lazy(value=true)   //XML <bean …. lazy-init="true"/>
    public MessageProvider messageProvider() {
        // Constructor injection
        return new ConfigurableMessageProvider(env.getProperty("message"));
    }

    @Bean(name="messageRenderer")
    @Scope(value="prototype")  // XML: <bean … scope="prototype"/>
    @DependsOn(value="messageProvider")  // XML: <bean … depends-on="messageProvider"/>
    public MessageRenderer messageRenderer() {
        MessageRenderer renderer = new StandardOutMessageRenderer();

        // Setter injection
        renderer.setMessageProv(messageProvider());

        return renderer;
    }
}