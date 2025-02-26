package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{
    @BeforeMethod
    public void preCondition(){
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
    }
    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);


        System.out.println(System.currentTimeMillis());
        int z = (int) ((System.currentTimeMillis() / 1000) % 3600);
        System.out.println(z);

        User user = new User()
                .setEmail("snow1"+ "@gmail.com")
                .setPassword("Snow123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }
    @Test
    public void regregisteredUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","Mmira1234$");
        app.getHelperUser().submitReg();
        app.getHelperUser().pause(5000);
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));

    }
    @Test
    public void regWrongEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("miragmail.com","Mmira1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void regWrongPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","Mm1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void regEmptyEmail(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("","Mmira1234$");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void regEmptyPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","");
        app.getHelperUser().submitReg();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format"));

    }
    @Test
    public void registrationSuccess3(){
        int i = new Random().nextInt(1000)+1000;
        User user = new User().withEmail("mira"  +"@gmail.com")
                .withPassword("Mmira1234$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitReg();

        Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
    }
}
