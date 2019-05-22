import trello2.core.BrowserFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import trello.pages.HeaderPage;
import trello.pages.LoginPage;

public class LoginTest extends BrowserFactory {

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();

        loginPage.open();
        loginPage.login("shytliuk.ihor+2@pdffiller.team", "qwe1rty2");

        Assert.assertTrue(new HeaderPage().isHeaderPresent());
//        Assert.assertFalse(driver.findElements(By.cssSelector(".mod-add")).isEmpty(), "Board page not opened");
    }

    @Test
    public void logoutTest() {
        HeaderPage header = new HeaderPage();
        header.logout();
        Assert.assertTrue(new LoginPage().isLoggedOut());
    }

    //todo create-delete board
    //add board to favourites
    //private-public
    //move cards

}
