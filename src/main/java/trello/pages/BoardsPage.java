package trello.pages;

import org.openqa.selenium.By;

import static trello.core.BrowserFactory.driver;

public class BoardsPage extends BasePage {

    private By createBoardBtnBy = By.xpath("//div[@class='board-tile mod-add']/p");
    private By boardTitleInpBy = By.xpath("//input[@class='subtle-input']");
    private By createBoardWithNameBtnBy = By.xpath("//button[@class='primary']");

    private By homeBtnBy = By.xpath("//a[@class='header-btn js-back-menu']");
    private By showMenuBtnBy = By.xpath("//a[@class='board-header-btn mod-show-menu js-show-sidebar']");
    private By showMoreBtnBy = By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']");
    private By closeBoardBtnBy = By.xpath("//a[@class='board-menu-navigation-item-link js-close-board']");

    private By closeInpBy = By.xpath("//input[@class='js-confirm full negate']");
    private By deleteBoardBy = By.xpath("//p[@class='delete-container']/a");

    private By favouriteAddBy = By.xpath("//*[@class='board-header-btn js-star-board']");
    private By favouriteDelBy = By.xpath("//*[@class='board-header-btn js-star-board board-header-btn-enabled']");

    private String homeUrl;

    public BoardsPage(String homeUrl) {
        super();
        this.homeUrl = homeUrl;
    }

    public void createBoard(String boardName) {
        openHome();
        click(createBoardBtnBy);
        typeText(boardTitleInpBy, boardName);
        click(createBoardWithNameBtnBy);
    }

    public void openBoard(String boardName) {
        openHome();
        By boardNameBy = By.xpath("//div[contains(text(),'" + boardName + "')]/ancestor::a");
        click(boardNameBy);
    }

    public void deleteBoard(String boardName) {
        openHome();
        openBoard(boardName);

//        if (isElementPresent(showMenuBtnBy)) {
//            click(showMenuBtnBy);
//        }
        click(showMoreBtnBy);
        click(closeBoardBtnBy);
        click(closeInpBy);
        click(deleteBoardBy);
        click(closeInpBy);
    }

    public void addToFav(String boardName) {
        openBoard(boardName);
        click(favouriteAddBy);
    }

    public boolean isBoardFavourite() {
        return isElementPresent(favouriteDelBy);
    }

    public boolean isBoardPresent(String boardName) {
        By boardNameBy = By.xpath("//div[contains(text(),'" + boardName + "')]/ancestor::a");
        return isElementPresent(boardNameBy);
    }

    public void openHome() {
        driver.get(homeUrl);
    }
}