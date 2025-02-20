package tests;

import models.Contact;
import models.User;
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
    public void addNewContactSuccess(){
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina")
                .lastname("Koen")
                .phone("0521234567")
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        app.getHelperContact().openContactForm();
        app.getHelperContact().fillContactForm(contact);
        app.getHelperContact().submitContactForm();
    }
}
