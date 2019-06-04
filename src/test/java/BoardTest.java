import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import trello.core.BrowserFactory;
import trello.pages.BoardsPage;
import trello.pages.LoginPage;

public class BoardTest extends BrowserFactory {

    private BoardsPage page;
    private String boardName = "test5";

    @BeforeClass
    public void login() {
        LoginPage loginPage = new LoginPage();
        loginPage.open();
        loginPage.login("shytliuk.ihor+2@pdffiller.team", "qwe1rty2");;
        page = new BoardsPage(driver.getCurrentUrl());
    }

    @Test
    public void createBoardTest() {
        page.createBoard(boardName);
        Assert.assertTrue(page.isBoardPresent(boardName));
    }

    @Test(dependsOnMethods = "createBoardTest")
    public void addToFavTest() {
        page.addToFav(boardName);
        Assert.assertTrue(page.isBoardFavourite());
    }

    @Test(dependsOnMethods = "createBoardTest")
    public void deleteBoardTest() {
        page.deleteBoard(boardName);
        Assert.assertFalse(page.isBoardPresent(boardName));
    }
}
