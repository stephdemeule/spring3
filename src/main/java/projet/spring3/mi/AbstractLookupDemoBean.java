package projet.spring3.mi;

public abstract class AbstractLookupDemoBean implements DemoBean{

    public abstract MyHelper getMyHelper();

    @Override
    public void someOperation() {
        getMyHelper().doSomethingHelpful();

    }
}
