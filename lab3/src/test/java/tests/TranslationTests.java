package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class TranslationTests extends BaseTest {
    private static final String GOOGLE_TRANSLATE_URL = "https://translate.google.ru/";

    @Test
    public void testEnglishToRussianTranslation() {
        context.getDriver().get(GOOGLE_TRANSLATE_URL);

        setSourceLanguage("English");
        setTargetLanguage("Russian");

        WebElement sourceTextArea = context.getDriver().findElement(
                By.xpath("//textarea[@aria-label='Source text']"));
        sourceTextArea.sendKeys("Hello, world!");

        WebElement translateButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='Translate']"));
        translateButton.click();

        WebElement resultArea = context.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='ryNqvb']")));

        assertThat(resultArea.getText()).isEqualTo("Привет, мир!");
    }

    @Test
    public void testRussianToEnglishTranslation() {
        context.getDriver().get(GOOGLE_TRANSLATE_URL);

        setSourceLanguage("Russian");
        setTargetLanguage("English");

        WebElement sourceTextArea = context.getDriver().findElement(
                By.xpath("//textarea[@aria-label='Source text']"));
        sourceTextArea.sendKeys("Привет, мир!");

        WebElement translateButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='Translate']"));
        translateButton.click();

        WebElement resultArea = context.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[@class='ryNqvb']")));

        assertThat(resultArea.getText()).isEqualTo("Hello world!");
    }

    private void setSourceLanguage(String language) {
        setLanguage("source", language);
    }

    private void setTargetLanguage(String language) {
        setLanguage("target", language);
    }

    private void setLanguage(String type, String language) {
        WebElement languageButton = context.getDriver().findElement(
                By.xpath(String.format("//button[@aria-label='More %s languages']", type)));
        languageButton.click();

        WebElement searchInput = context.getDriver().findElement(
                By.xpath("//input[@aria-label='Search languages']"));
        searchInput.sendKeys(language);

        WebElement languageOption = context.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(String.format("//div[@data-language-code]//div[text()='%s']", language))));
        languageOption.click();
    }
}