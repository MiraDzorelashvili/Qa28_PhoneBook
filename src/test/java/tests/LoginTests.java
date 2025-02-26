package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition(){
        //if SignOut present --->logout
        if(app.getHelperUser().isLogged())
            app.getHelperUser().logout();
        logger.info("Before method finished logout");
    }


    @Test
    public void loginSuccess() {
        logger.info("Start test with name 'loginSuccess'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","Mmira1234$");
        logger.info("Test data ---> email: 'mira@gmail.com' & password: 'Mmira1234$'");
        app.getHelperUser().sumit();
        //Assert
//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue()
//        Assert.assertFalse();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is element button 'Sigh out' present");
    }

    @Test
    public void loginSuccessModel() {
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","Mmira1234$");
        app.getHelperUser().sumit();
        Assert.assertTrue(app.getHelperUser().isLogged());
    }


    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'miragmail.com' & password: 'Mmira1234$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("miragmail.com","Mmira1234$");
        app.getHelperUser().sumit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'mira@gmail.com' & password: 'Mmira124$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira@gmail.com","Mma1234$");
        app.getHelperUser().sumit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }

    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'miragmail.com' & password: 'Maira1234$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira1@gmail.com","Mmira12345$");
        app.getHelperUser().sumit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }
    @Test
    public void loginEmptyUser(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(" ","Mmira12345$");
        app.getHelperUser().sumit();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }
    @Test
    public void loginEmptyPassword(){
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("mira1@gmail.com"," ");
        app.getHelperUser().sumit();
       Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));

    }




}