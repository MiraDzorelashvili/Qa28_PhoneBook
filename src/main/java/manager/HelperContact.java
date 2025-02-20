package manager;

import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HelperContact extends HelperBase{
    public HelperContact(WebDriver wd) {
        super(wd);
    }

    public void openContactForm() {
        pause(500);
        click(By.xpath("//a[text()='ADD']"));
    }

    public void fillContactForm(Contact contact) {
        type(By.name("Name"), contact.getName());
        type(By.name("Lastname"), contact.getLastname());
        type(By.name("Phone"), contact.getPhone());
        type(By.name("Email"), contact.getEmail());
        type(By.name("Address"), contact.getAddress());
        type(By.name("Description"), contact.getDescription());
    }

    public void submitContactForm() {
            click(By.xpath("//button[text()='Save']"));
    }
}
