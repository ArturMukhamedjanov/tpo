package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class UiFunctionalityTests extends BaseTest {
    private static final String GOOGLE_TRANSLATE_URL = "https://translate.google.ru/";

    @Test
    public void testLanguageSwap() {
        context.getDriver().get(GOOGLE_TRANSLATE_URL);

        setSourceLanguage("English");
        setTargetLanguage("Russian");

        WebElement sourceLanguageButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='More source languages']"));
        WebElement targetLanguageButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='More target languages']"));

        String sourceLanguageBefore = sourceLanguageButton.getText();
        String targetLanguageBefore = targetLanguageButton.getText();

        WebElement swapButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='Swap languages']"));
        swapButton.click();
        String sourceLanguageAfter = sourceLanguageButton.getText();
        String targetLanguageAfter = targetLanguageButton.getText();

        assertThat(sourceLanguageAfter).isEqualTo(targetLanguageBefore);
        assertThat(targetLanguageAfter).isEqualTo(sourceLanguageBefore);
    }

    @Test
    public void testClearTextButton() {
        context.getDriver().get(GOOGLE_TRANSLATE_URL);

        // Вводим текст
        WebElement sourceTextArea = context.getDriver().findElement(
                By.xpath("//textarea[@aria-label='Source text']"));
        sourceTextArea.sendKeys("Test text to clear");

        // Проверяем, что текст введен
        assertThat(sourceTextArea.getAttribute("value")).isNotEmpty();

        // Нажимаем кнопку очистки
        WebElement clearButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='Clear source text']"));
        clearButton.click();

        // Проверяем, что текст очищен
        assertThat(sourceTextArea.getAttribute("value")).isEmpty();
    }

    @Test
    public void testVirtualKeyboard() {
        context.getDriver().get(GOOGLE_TRANSLATE_URL);

        // Открываем виртуальную клавиатуру
        WebElement keyboardButton = context.getDriver().findElement(
                By.xpath("//button[@aria-label='Show the keyboard']"));
        keyboardButton.click();

        // Проверяем, что клавиатура отобразилась
        WebElement keyboard = context.getWait().until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='keyboard-key']")));
        assertThat(keyboard.isDisplayed()).isTrue();

        // Закрываем клавиатуру
        keyboardButton.click();

        // Проверяем, что клавиатура скрыта
        context.getWait().until(
                ExpectedConditions.invisibilityOfElementLocated(
                        By.xpath("//div[@class='keyboard-key']")));
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