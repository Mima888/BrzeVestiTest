package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegionsPage extends Page {
    
    //PRIVATE METHODS
    private void addRegionButton() {
        clickOnElement(By.className("pull-right"));
    }

    private void titleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void saveRegionButton() {
        clickOnElement(By.id("save-region-button"));
    }

    private void editButton(WebElement row) {
        WebElement editButton = row.findElement(By.cssSelector("a[title='Edit']"));
        editButton.click();
    }

    private void deleteButton(WebElement row) {
        WebElement deleteButton = row.findElement(By.cssSelector("button[title='Delete']"));
        deleteButton.click();
    }

    private void confirmDelete() {
        clickOnElement(By.xpath("//*[@id=\"regionDeleteDialog\"]/div/div/div[3]/button[2]"));
    }

    private void disableBtn(WebElement row) {
        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {
        clickOnElement(By.xpath("//*[@id=\"regionDisableDialog\"]/div/div/div[3]/button[2]"));
    }
    
    private void enableBtn(WebElement row) {
        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }
    
    private void confirmEnable() {
        clickOnElement(By.xpath("//*[@id=\"regionEnableDialog\"]/div/div/div[3]/button[2]"));
    }

    private List<WebElement> getRowsFromTable() {
        WebElement tableBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    private WebElement chooseFirstRegion() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);
        return firstRow;
    }

    private WebElement chooseLastRegion() {
        List<WebElement> rows = getRowsFromTable();
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomRegion() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    //PUBLIC METHODS
    public void addNewRegion() {
        addRegionButton();
        titleField();
        saveRegionButton();
    }

    public void editFirstRegion() {
        WebElement firstRow = chooseFirstRegion();
        editButton(firstRow);
        titleField();
        saveRegionButton();
    }

    public void editLastRegion() {
        WebElement lastRow = chooseLastRegion();
        editButton(lastRow);
        titleField();
        saveRegionButton();

    }

    public void editRandomRegion() {
        WebElement randomRow = chooseRandomRegion();
        editButton(randomRow);
        titleField();
        saveRegionButton();
    }

    public void deleteFirstRegion() {
        WebElement firstRow = chooseFirstRegion();
        deleteButton(firstRow);
        confirmDelete();
    }

    public void deleteLastRegion() {
        WebElement lastRow = chooseLastRegion();
        deleteButton(lastRow);
        confirmDelete();
    }

    public void deleteRandomRegion() {
        WebElement randomRow = chooseRandomRegion();
        deleteButton(randomRow);
        confirmDelete();
    }

    public void disableFirstRegion() {
        WebElement firstRow = chooseFirstRegion();
        disableBtn(firstRow);
        confirmDisable();

    }
    
    public void disableLastRegion() {
        WebElement lastRow = chooseLastRegion();
        disableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomRegion() {
        WebElement randomRow = chooseRandomRegion();
        disableBtn(randomRow);
        confirmDisable();
    }
    
    public void enableFirstRegion() {
        WebElement firstRow = chooseFirstRegion();
        enableBtn(firstRow);
        confirmEnable();
    }
    
    public void enableLastRegion() {
        WebElement lastRow = chooseLastRegion();
        enableBtn(lastRow);
        confirmEnable();
    }
}
