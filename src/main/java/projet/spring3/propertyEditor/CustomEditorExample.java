package projet.spring3.propertyEditor;

import org.springframework.context.support.GenericXmlApplicationContext;

public class CustomEditorExample {
    private Name name;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:custom.xml");
        ctx.refresh();

        CustomEditorExample bean =
                (CustomEditorExample) ctx.getBean("exampleBean");
        System.out.println(bean.getName());
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}
