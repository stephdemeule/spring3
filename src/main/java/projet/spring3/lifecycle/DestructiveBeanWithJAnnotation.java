package projet.spring3.lifecycle;

import org.springframework.context.support.GenericXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DestructiveBeanWithJAnnotation {

    private InputStream inputStream = null;

    public String filePath = null;

    @PostConstruct
    public void afterPropertiesSet() throws Exception {

        System.out.println("Initializing Bean");

        if (filePath == null) {
            throw new IllegalArgumentException(
                    "You must specify the filePath property of " + DestructiveBean.class);
        }

        inputStream = new FileInputStream(filePath);
    }

    @PreDestroy
    public void destroy() {

        System.out.println("Destroying Bean");

        if (inputStream != null) {
            try {
                inputStream.close();
                inputStream = null;
            } catch (IOException ex) {
                System.err.println("WARN: An IOException occured"
                        + " trying to close the InputStream");
            }
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public static void main(String[] args) throws Exception {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:disposeAnnotation.xml");
        ctx.refresh();

        DestructiveBeanWithJAnnotation bean = (DestructiveBeanWithJAnnotation)
                ctx.getBean("destructiveBean");

        System.out.println("Calling destroy()");
        ctx.destroy();
        System.out.println("Called destroy()");
    }
}