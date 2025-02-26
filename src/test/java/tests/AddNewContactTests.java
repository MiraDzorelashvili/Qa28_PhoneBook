package tests;

import models.Contact;
import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddNewContactTests extends TestBase{
    @BeforeClass
    public void preCondition(){
        if (!app.getHelperUser().isLogged()){
            app.getHelperUser().login(new User().setEmail("mira@gmail.com").setPassword("Mmira1234$"));
        }
    }
    @Test
    public void addNewContactSuccessFull(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        Contact contact = Contact.builder()
                .name("Nina"+ i)
                .lastname("Koen")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("Shalom")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().getScreen("src/test/screenshots/screen-" + i +".png");
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactSuccessRequired(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description(" ")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("")
                .lastname("Koen")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyLastName(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyPhone(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(
                "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test
    public void addNewContactEmptyEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("0521234567")
                .email("")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactEmptyAddress(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
    }
    @Test
    public void addNewContactWrongPhone(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("05231445")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent(
                "Phone not valid: Phone number must contain only digits! And length min 10, max 15!"));
    }
    @Test
    public void addNewContactWrongEmail(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("0521234567")
                .email("gvhhgmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
        Assert.assertTrue(app.getHelperUser().isAdded());
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email not valid:"));
    }
}
