package projet.spring3.profile;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class ProfileJavaConfigExample {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.getEnvironment().setActiveProfiles("kindergarten");
        ctx.register(KindergartenConfig.class, HighschoolConfig.class);
        ctx.refresh();

        FoodProviderService foodProviderService =
                ctx.getBean("foodProviderService", FoodProviderService.class);
        List<Food> lunchSet = foodProviderService.provideLunchSet();

        for (Food food: lunchSet) {
            System.out.println("Food: " + food.getName());
        }

    }
}
