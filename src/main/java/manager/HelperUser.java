package manager;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginRegistrationForm(){
//    WebElement loginTab = wd.findElement(By.cssSelector("a[href='/login']"));
//    //xPath--> //a[text()='LOGIN']
//    loginTab.click();
        click(By.cssSelector("a[href='/login']"));
        logger.info("Open form by click on button with locator 'By.cssSelector(\"a[href='/login']");

    }


    public void fillLoginRegistrationForm(String email, String password) {
//        WebElement emailInput = wd.findElement(By.name("email"));
//        emailInput.click();
//        emailInput.clear();
//        emailInput.sendKeys(email);
        type(By.xpath("//input[last()]"),password);
        type(By.name("email"),email);
        logger.info("Type in input with locator 'By.name(\"email\")'");
    }
    public void fillLoginRegistrationForm(User user) {
        type(By.name("email"), user.getEmail());
        type(By.name("password"), user.getPassword());
    }

    public void sumit(){
        click(By.xpath("//button[text()='Login']"));
    }
    public void submitReg(){
        click(By.xpath("//button[text()='Registration']"));}

    public boolean isLogged() {
        return   isElementPresent(By.xpath("//button[text() = 'Sign Out']"));
    }

    public void logout() {
        click(By.xpath("//button[text() = 'Sign Out']"));
    }


    public void login(User user) {
        openLoginRegistrationForm();
        fillLoginRegistrationForm(user);
        sumit();
    }

    public boolean isAdded() {
        return  isElementPresent(By.xpath("//div[@class='add_form__2rsm2']//button"));
    }
}