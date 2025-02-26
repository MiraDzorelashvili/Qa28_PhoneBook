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
        type(By.cssSelector(" input[placeholder='Name']"), contact.getName());
        type(By.cssSelector(" input[placeholder='Last Name']"), contact.getLastname());
        type(By.cssSelector(" input[placeholder='Phone']"), contact.getPhone());
        type(By.cssSelector(" input[placeholder='email']"), contact.getEmail());
        type(By.cssSelector(" input[placeholder='Address']"), contact.getAddress());
        type(By.cssSelector(" input[placeholder='description']"), contact.getDescription());
    }

    public void submitContactForm() {
            click(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }
    public boolean isAdded() {
        return  isElementPresent(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }

    public int removeOneContact() {
        int before = countOfContacts();
        logger.info("Number of Contacts before remove --->"+ before);
        removeContact();

        int after = countOfContacts();
        logger.info("Number of Contacts before remove --->"+ after);


        return before - after;
    }

    private void removeContact() {
        click(By.cssSelector(".contact-item_card__2SOIM"));
        click(By.xpath("//button[text()='Remove']"));
        pause(1000);
    }

    private int countOfContacts() {
        return wd.findElements(By.cssSelector(".contact-item_card__2SOIM")).size();
    }

    public void removeAllContacts() {
        while (countOfContacts() != 0)
            removeContact();
    }

    public void provideContacts() {
        if (countOfContacts() <3){
            for(int i = 0; i < 3; i++){
                addOneContact();
            }
        }
    }

    private void addOneContact() {
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        Contact contact = Contact.builder()
                .name("Nina" + i)
                .lastname("Koen")
                .phone("0521234567" +i )
                .email("nina@gmail.com")
                .address("Herzl 1,Haifa")
                .description("")
                .build();
        openContactForm();
        fillContactForm(contact);
        isAdded();
        pause(500);
    }
}