package pages;

import framework.Helper;
import framework.Page;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CategoriesPage extends Page {

    //PRIVATE METHODS
    private void addCategoryButton() {
        clickOnElement(By.className("btn"));
    }

    private void titleField() {
        sendTextOnField(By.id("title"), Helper.getRandomText());
    }

    private void saveCategoryButton() {
        clickOnElement(By.id("save-category-button"));
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
        clickOnElement(By.xpath("//*[@id=\'categoryDeleteDialog\']/div/div/div[3]/button[2]"));
    }

    private void disableBtn(WebElement row) {
        WebElement disableBtn = row.findElement(By.cssSelector("button[title='Disable']"));
        disableBtn.click();
    }

    private void confirmDisable() {
        clickOnElement(By.xpath("//*[@id=\"categoryDisableDialog\"]/div/div/div[3]/button[2]"));
    }
    
    private void enableBtn(WebElement row) {
        WebElement enableBtn = row.findElement(By.cssSelector("button[title='Enable']"));
        enableBtn.click();
    }
    
    private void confirmEnable() {
        clickOnElement(By.xpath("//*[@id=\"categoryEnableDialog\"]/div/div/div[3]/button[2]"));
    }

    private List<WebElement> getRowsFromTable() {
        WebElement tableBody = waitForElementVisibility(By.className("ui-sortable"));
        List<WebElement> rows = tableBody.findElements(By.tagName("tr"));
        System.out.println("Number of rows: " + rows.size());
        return rows;
    }

    private WebElement chooseFirstCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement firstRow = rows.get(0);
        return firstRow;
    }

    private WebElement chooseLastCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement lastRow = rows.get(rows.size() - 1);
        return lastRow;
    }

    private WebElement chooseRandomCategory() {
        List<WebElement> rows = getRowsFromTable();
        WebElement randomRow = rows.get(Helper.getRandomInteger(rows.size()));
        return randomRow;
    }

    //PUBLIC METHODS
    public void addNewCategory() {
        addCategoryButton();
        titleField();
        saveCategoryButton();
    }

    public void editFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        editButton(firstRow);
        titleField();
        saveCategoryButton();
    }

    public void editLastCategory() {
        WebElement lastRow = chooseLastCategory();
        editButton(lastRow);
        titleField();
        saveCategoryButton();

    }

    public void editRandomCategory() {
        WebElement randomRow = chooseRandomCategory();
        editButton(randomRow);
        titleField();
        saveCategoryButton();
    }

    public void deleteFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        deleteButton(firstRow);
        confirmDelete();
    }

    public void deleteLastCategory() {
        WebElement lastRow = chooseLastCategory();
        deleteButton(lastRow);
        confirmDelete();
    }

    public void deleteRandomCategory() {
        WebElement randomRow = chooseRandomCategory();
        deleteButton(randomRow);
        confirmDelete();
    }

    public void disableFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        disableBtn(firstRow);
        confirmDisable();

    }
    
    public void disableLastCategory() {
        WebElement lastRow = chooseLastCategory();
        disableBtn(lastRow);
        confirmDisable();
    }

    public void disableRandomCategory() {
        WebElement randomRow = chooseRandomCategory();
        disableBtn(randomRow);
        confirmDisable();
    }
    
    public void enableFirstCategory() {
        WebElement firstRow = chooseFirstCategory();
        enableBtn(firstRow);
        confirmEnable();
    }
    
    public void enableLastCategory() {
        WebElement lastRow = chooseLastCategory();
        enableBtn(lastRow);
        confirmEnable();
    }
}
