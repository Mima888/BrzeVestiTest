package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PortalsPage extends Page {

    //PRIVATE METHODS
    private void addPortalBtn() {
        clickOnElement(By.className("pull-right"));
    }

    private void titleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void urlField() {
        sendTextOnField(By.id("url"), Helper.getRandomUrl());
    }

    private void selectRegion() {

        Select dropDown = new Select(getDriver().findElement(By.name("region_id")));
        dropDown.selectByIndex(3);
    }

    private void savePortBtn() {
        clickOnElement(By.id("save-portal-button"));
    }

    private void editButton(WebElement row) {
        WebElement editBtn = row.findElement(By.cssSelector("a[title='Edit']"));
        editBtn.click();
    }

    private void selectNewRegion() {
        Select newDropDown = new Select(getDriver().findElement(By.name("region_id")));
        newDropDown.selectByIndex(5);
    }

    private void deleteBtn(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete() {
        clickOnElement(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[2]"));

    }

    private void closeBtn() {
        clickOnElement(By.xpath("//*[@id=\"portalDeleteDialog\"]/div/div/div[3]/button[1]"));
    }

    private void disableBtn(WebElement row) {
        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {
        clickOnElement(By.xpath("//*[@id=\"portalDisableDialog\"]/div/div/div[3]/button[2]"));

    }

    private void enableBtn(WebElement row) {
        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }

    private void confirmEnable() {
        clickOnElement(By.xpath("//*[@id=\"portalEnableDialog\"]/div/div/div[3]/button[2]"));
    }

    private List<WebElement> getRowsFromTable() {
        WebElement tableBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    private WebElement chooseLastRow() {

        List<WebElement> rows = getRowsFromTable();
        return rows.get(rows.size() - 1);
    }

    private WebElement chooseFirstRow() {

        return getRowsFromTable().get(0);
    }

    private WebElement chooseRandomRow() {

        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    //PUBLIC METHODS
    public void addNewPortal() {

        addPortalBtn();
        titleField();
        urlField();
        selectRegion();
        savePortBtn();
    }

    public void editFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        editButton(firstRow);
        titleField();
        urlField();
        selectNewRegion();
        savePortBtn();
    }

    public void editLastPortal() {

        WebElement lastRow = chooseLastRow();
        editButton(lastRow);
        titleField();
        urlField();
        selectNewRegion();
        savePortBtn();
    }

    public void editRandomPortal() {

        WebElement randomRow = chooseRandomRow();
        editButton(randomRow);
        titleField();
        urlField();
        selectNewRegion();
        savePortBtn();
    }

    public void deleteFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        deleteBtn(firstRow);
        confirmDelete();
    }

    public void deleteLastPortal() {

        WebElement lastRow = chooseLastRow();
        deleteBtn(lastRow);
        confirmDelete();
//          closeBtn();
    }

    public void deleteRandomPortal() {

        WebElement randomRow = chooseRandomRow();
        deleteBtn(randomRow);
        confirmDelete();
    }

    public void disableFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        disableBtn(firstRow);
        confirmDisable();

    }

    public void disableLastPortal() {

        WebElement lastRow = chooseLastRow();
        disableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomPortal() {

        WebElement randomRow = chooseRandomRow();
        disableBtn(randomRow);
        confirmDisable();
    }

    public void enableFirstPortal() {

        WebElement firstRow = chooseFirstRow();
        enableBtn(firstRow);
        confirmEnable();
    }

    public void enableLastPortal() {

        WebElement lastRow = chooseLastRow();
        enableBtn(lastRow);
        confirmEnable();
    }
}
