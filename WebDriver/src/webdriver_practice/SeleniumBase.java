package webdriver_practice;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.nio.file.CopyOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class SeleniumBase {


	protected static final int ONE_SECOND = 1;
	protected static File resourcesDirectory = new File("src/main/resources");
	protected static final String UPLOAD_FILE_PATH = resourcesDirectory.getAbsoluteFile() + "\\upLoadFiles";
	protected static final String DOWNLOAD_FILE_PATH = resourcesDirectory.getAbsoluteFile() + "\\downLoadFiles";

	public enum Expected_Conditions {
		isElementClickable, isElementVisible, isElementPresent
	}

	/**
	 * Function Name : getDriver Description : it is getter method to get Driver
	 * instance.
	 * 
	 * @return : WebDriver
	 */
	public static WebDriver getDriver() throws Exception {
		try {
			TestLogger.info("Inside : FrameworkBase.getDriver. Thread Id: " + Thread.currentThread().getId());
			return WebDriverManager.getDriver();
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.getDriver : \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : closeBrowser Description : Quit the browser equivalent of
	 * close browser and make driver as null
	 * 
	 * @return : none
	 */
	public static void closeBrowser() throws Exception {
		try {
			TestLogger.info("Inside : FrameworkBase.closeBrowser");
			WebDriver driver = WebDriverManager.getDriver();
			if (driver != null) {
				driver.quit();
			}
		} catch (Exception e) {
			TestLogger.error("Exception in method  FrameworkBase.quitDriver \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getScreenshot Description : if there is error during text
	 * execution, it will capture application screenshot and saved in Screen
	 * hshot folder for easy debugging. * @param testCaseName : testCaseName
	 * 
	 * @return : none
	 */
	public static void getScreenshot(String testCaseName) throws Exception {
		try {
			CaptureScreenShot.captureScreenShot(getDriver(), testCaseName);
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.getScreenshot : \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getLocatorString Description : This function will
	 * separate locator type and locator value based on delimiter. If delimiter
	 * is missing it will log error in log file.
	 * 
	 * @param locator
	 *            : WebElement locator /identifier e.g.
	 *            "xpath~//input[@class='classvalue']"
	 * @return : By
	 */
	private By getLocatorString(String locator) throws Exception {
		try {
			String separator = ReadConfigData.getPropertyValue("LOCATER_DELIMITOR");
			String array[] = null;
			if (!locator.contains(separator)) {
				TestLogger.error("Invalid locator: locator format is 'xpath'" + separator + "'//div[@class=value]'"
						+ " It must include locator type like xpath or css ; delimiters like ~ /#  and the locator value");
				throw new Exception("Invalid locator: locator format is 'xpath'" + separator + "'//div[@class=value]'"
						+ " It must include locator type like xpath or css ; delimiters like ~ /#  and the locator value");
			}
			array = locator.split(separator, 2);
			By by = null;

			switch (array[0].toLowerCase()) {
			case "xpath":
				by = By.xpath(array[1]);
				break;
			case "css":
				by = By.cssSelector(array[1]);
				break;
			case "id":
				by = By.id(array[1]);
				break;
			case "class":
				by = By.className(array[1]);
				break;
			case "name":
				by = By.name(array[1]);
				break;
			case "linktext":
				by = By.linkText(array[1]);
				break;
			case "tagname":
				by = By.tagName(array[1]);
				break;
			default:
				by = By.xpath(array[1]);
				break;
			}
			return by;
		} catch (Exception e) {
			TestLogger.error(
					"Exception in FrameworkBase.getLocatorString: " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : locateElement Description : This function will find first
	 * matching element in DOM and will poll DOM every one second till maximum
	 * amount of wait time has elapsed. (maximum time
	 * =WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS time is set in config/properties
	 * file).
	 * 
	 * @param locator
	 *            : WebElement locator /identifier e.g.
	 *            "xpath~//input[@class='classvalue']" xpath~//*[text()='VALUE']
	 * @return : WebElement
	 */
	protected WebElement locateElement(String locator) throws Exception {
		try {
			waitForDOMElementsRefresh(ONE_SECOND);
			WebElement element = null;
			By by = getLocatorString(locator);
			String err_Message = null;
			int number_Attempts = Integer
					.parseInt(ReadConfigData.getPropertyValue("WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS"));
			for (int count = 1; count <= number_Attempts; count++) {
				try {
					element = getDriver().findElement(by);
					if (element != null) {
						return element;
					}
				} catch (StaleElementReferenceException ser) {
					waitForDOMElementsRefresh(ONE_SECOND);
					err_Message = ser.getMessage();
				} catch (NoSuchElementException ne) {
					waitForDOMElementsRefresh(ONE_SECOND);
					err_Message = ne.getMessage();
				} catch (Exception e) {
					waitForDOMElementsRefresh(ONE_SECOND);
					err_Message = e.getMessage();
				}
			}

			TestLogger.error(" Exception in locating Element in method FrameworkBase.locateElement: \n " + err_Message);
			throw new Exception(err_Message);
		} catch (Exception e) {
			TestLogger.error("\n Exception  in  FrameworkBase.locateElement outer try block:: " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : locateElements Description : To find the list of
	 * WebElements based on the locator type and locator value. This will find
	 * elements in DOM and will poll DOM every one second till maximum amount of
	 * wait time has elapsed. (maximum time
	 * =WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS time is set in config/properties
	 * file).
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : List of WebElements
	 */
	protected List<WebElement> locateElements(String locator) throws Exception {

		String err_Message = null;
		List<WebElement> elements = null;
		waitForDOMElementsRefresh(ONE_SECOND);
		By by = getLocatorString(locator);
		int number_Attempts = Integer
				.parseInt(ReadConfigData.getPropertyValue("WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS"));
		for (int count = 1; count <= number_Attempts; count++) {
			try {
				elements = getDriver().findElements(by);
				if (!elements.isEmpty() || elements.size() >= 1) {
					return elements;
				}
			} catch (Exception e) {
				waitForDOMElementsRefresh(ONE_SECOND);
				err_Message = e.getMessage();
			}
		}
		TestLogger.error(" Exception in locating Elements in method FrameworkBase.locateElements: " + err_Message);
		return elements;
	}

	/**
	 * Function Name : autoScrollWebElement Description : If object is not
	 * visible due to Scroll bar, it will automatically scrolls vertically or
	 * horizontally to make element visible using JavaScript
	 * 
	 * @param _element
	 *            : WebElement
	 * @return : none
	 */
	protected void autoScrollWebElement(WebElement _element) throws Exception {
		TestLogger.info("Inside : FrameworkBase.autoScrollWebElement: " + _element);
		try {
			((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", _element);
		} catch (Exception e) {
			TestLogger.error("auto scroll operation failed on: " + _element + " \n Exception is:" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : clickWebElement Description : To click on WebElement.
	 * ScrollIntoAndClick if set to true, it will automatically scrolls
	 * vertically or horizontally on element. expectedCondition, while locating
	 * element it will check if element is visible or present or click able.
	 * 
	 * @param locator
	 *            : WebElement locator /identifier e.g.
	 *            "xpath~//input[@class='classvalue']"
	 * @return : none
	 */
	protected void clickWebElement(String locator) throws Exception {
		clickWebElement(locator, false);
	}

	/**
	 * Function Name : clickWebElement Description : To click on webElement.
	 * ScrollIntoAndClick if set to true it will automatically scrolls
	 * vertically or horizontally on to Webelement. Additional optional values
	 * are To click on object. ScrollIntoAndClick if set to true it will
	 * automatically scrolls vertically or horizontally to check element.
	 * expectedCondition, while locating element it will check if element is
	 * visible or presence or click able.
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @param ScrollIntoAndClick
	 *            :ScrollIntoAndClick if set to true it will automatically
	 *            scrolls vertically or horizontally on to Webelement.
	 * @return : none
	 */
	protected void clickWebElement(String locator, boolean scroll_Into_And_Click) throws Exception {
		WebElement element = null;
		try {
			element = locateElement(locator);
			if (element != null) {
				element.click();
			} else {
				TestLogger.error("WebElement is not found. it is null: " + locator);
				throw new Exception("WebElement is not found. it is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error("Click operation failed on: " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : clickWebElement Description : To click on object.
	 * ScrollIntoAndClick if set to true it will automatically scrolls
	 * vertically or horizontally to check element. expectedCondition, while
	 * locating element it will check if element is visible or presence or click
	 * able.
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @param expectedCondition
	 *            :enum values like Conditions.isElementVisible or
	 *            Conditions.isElementClickable or Conditions.isElementClickable
	 * @param ScrollIntoAndClick
	 *            :ScrollIntoAndClick if set to true it will automatically
	 *            scrolls vertically or horizontally on to Webelement.
	 * @return : none
	 */
	protected void clickWebElement(String locator, Expected_Conditions expectedCondition, boolean ScrollIntoAndClick)
			throws Exception {

		WebElement element = null;
		By by = getLocatorString(locator);
		try {
			WebDriverWait wait = new WebDriverWait(getDriver(),
					Integer.parseInt(ReadConfigData.getPropertyValue("WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS")));
			switch (expectedCondition) {
			case isElementClickable:
				element = wait.until(ExpectedConditions.elementToBeClickable(by));
				break;
			case isElementVisible:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
				break;
			case isElementPresent:
				element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
				break;
			default:
				element = wait.until(ExpectedConditions.elementToBeClickable(by));
				break;
			}

			if (element != null) {
				if (ScrollIntoAndClick) {
					autoScrollWebElement(element);
				}
				if (element.isDisplayed() && element.isEnabled()) {
					TestLogger.info("WebElement is Displayed and enabled and hence clicking  " + locator);
					element.click();
					return;
				} else {
					TestLogger.error("WebElement is not Displayed.  " + locator);
					throw new Exception("WebElement is not Displayed.  " + locator);
				}
			} else {
				TestLogger.error("WebElement is not found. it is null: " + locator);
				throw new Exception("WebElement is not found. it is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error("Click operation failed on: " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : hoverAndClickWebElement Description : Mouse over main
	 * Menu and after list of subMenu are displayed, then click subMenu.
	 * 
	 * @param mouseHoverParentLocator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @param clickChildLocator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : none
	 */
	protected void hoverAndClickWebElement(String mouseHoverParentLocator, String clickChildLocator) throws Exception {

		TestLogger.info("Inside : FrameworkBase.hoverAndClickWebElement");
		WebElement menu = null;
		WebElement subMenu = null;

		try {
			TestLogger.debug("hoverAndClickWebElementt - Mouse Hover on parent WebElement: " + mouseHoverParentLocator
					+ " and Click on child WebElement:" + clickChildLocator);
			menu = locateElement(mouseHoverParentLocator);
			if (menu != null) {
				Actions builder = new Actions(getDriver());
				builder.clickAndHold(menu).build().perform();
			} else {
				TestLogger.error("Parent WebElement is not found. It is null: " + mouseHoverParentLocator);
				throw new Exception("Parent WebElement is not found. It is null: " + mouseHoverParentLocator);
			}

			subMenu = locateElement(clickChildLocator);
			if (subMenu != null) {
				if (subMenu.isDisplayed() && subMenu.isEnabled()) {
					subMenu.click();
				} else {
					TestLogger.error("Child WebElement is found. it is either not displayed or is not enabled: "
							+ clickChildLocator);
					throw new Exception("Child WebElement is found. it is either not displayed or is not enabled: "
							+ clickChildLocator);
				}
			} else {
				TestLogger.error("Child WebElement is not found. It is null: " + clickChildLocator);
				throw new Exception("Child WebElement is not found. It is null: " + clickChildLocator);
			}
			return;
		} catch (Exception e) {
			TestLogger.error("Mouse Hover on WebElement: " + mouseHoverParentLocator + " and Click on WebElement:"
					+ clickChildLocator + " failed" + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : hoverAndSelectInnerMostMenu Description : Mouse over main
	 * Menu and after list of subMenu are displayed, then click subMenu.
	 * 
	 * @param mouseHoverParentLocator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @param clickChildLocator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : none
	 */
	protected void hoverAndSelectInnerMostMenu(String mouseHoverParentMenu, String mouseHoverSubMenuLocator,
			String clickInnerMostMenu) throws Exception {

		TestLogger.info("Inside : FrameworkBase.hoverAndSelectInnerMostMenu");
		WebElement menu = null;
		WebElement subMenu = null;
		WebElement innerMostMenu = null;

		try {
			TestLogger.debug("hoverAndSelectInnerMostMenu - Mouse Hover on parent WebElement: " + mouseHoverParentMenu
					+ "Mouse Hover on parent WebElement: " + mouseHoverSubMenuLocator
					+ " and Click on innerMost  WebElement:" + clickInnerMostMenu);
			menu = locateElement(mouseHoverParentMenu);

			Actions builder = new Actions(getDriver());

			if (menu != null) {
				builder.moveToElement(menu).build().perform();
			} else {
				TestLogger.error("Parent Menu WebElement is not found. It is null: " + mouseHoverParentMenu);
				throw new Exception("Parent Menu WebElement is not found. It is null: " + mouseHoverParentMenu);
			}

			subMenu = locateElement(mouseHoverSubMenuLocator);
			if (subMenu != null) {
				builder.moveToElement(subMenu).build().perform();
			} else {
				TestLogger.error("SubMenu WebElement is not found. It is null: " + mouseHoverSubMenuLocator);
				throw new Exception("SubMenu WebElement is not found. It is null: " + mouseHoverSubMenuLocator);
			}

			innerMostMenu = locateElement(clickInnerMostMenu);
			if (innerMostMenu != null) {
				if (innerMostMenu.isDisplayed() && innerMostMenu.isEnabled()) {
					innerMostMenu.click();
				} else {
					TestLogger.error("InnerMostMenu WebElement is found. it is either not displayed or is not enabled: "
							+ clickInnerMostMenu);
					throw new Exception(
							"InnerMostMenu WebElement is found. it is either not displayed or is not enabled: "
									+ clickInnerMostMenu);
				}
			} else {
				TestLogger.error("InnerMostMenu WebElement is not found. It is null: " + clickInnerMostMenu);
				throw new Exception("InnerMostMenu WebElement is not found. It is null: " + clickInnerMostMenu);
			}
			return;
		} catch (Exception e) {
			TestLogger.error("Mouse Hover on Menu , SubMenu : " + mouseHoverParentMenu
					+ " and Click on innerMost Submenu WebElement:" + clickInnerMostMenu + " failed"
					+ " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : rightClickWebElement Description : Equivalent to Right
	 * click operation using mouse
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : none
	 */
	protected void rightClickWebElement(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.rightClickWebElement: " + locator);
		WebElement element = null;
		waitForDOMElementsRefresh();
		try {
			TestLogger.debug("clickWebElement - Click operation on WebElement: " + locator);
			element = locateElement(locator);
			if (element != null) {
				Actions builder = new Actions(getDriver());
				builder.contextClick(element).build().perform();
				return;
			} else {
				TestLogger.error("WebElement is null: " + locator);
				throw new Exception("WebElement is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error("Right Click operation failed on: " + locator + " \n Exception is" + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : doubleClickWebElement Description : Equivalent of double
	 * click operation
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : none
	 */
	protected void doubleClickWebElement(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.doubleClickWebElement");
		WebElement element = null;
		try {
			TestLogger.debug("clickWebElement - Click operation on WebElement: " + locator);
			element = locateElement(locator);
			if (element != null) {
				Actions builder = new Actions(getDriver());
				builder.doubleClick(element).build().perform();
				return;
			} else {
				TestLogger.error("WebElement is null" + locator);
				throw new Exception("WebElement is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error("Double  Click operation failed on: " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : ctrlPlusClick Description : This is used for multiple
	 * selection. This will select the WebElement and then press Control key
	 * 
	 * @param locator
	 *            : String value with locator type and property separated by
	 *            delimiter ~ e.g. xpath~//input[text()='visible text'
	 *            or @class='classvalue']
	 * @return : none
	 */
	protected void ctrlPlusClick(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.ctrlPlusClick");
		WebElement element = null;
		try {
			TestLogger.info("ctrlPlusClick - press control and click on element: " + locator);
			element = locateElement(locator);
			if (element != null) {
				Actions builder = new Actions(getDriver());
				builder.keyDown(Keys.LEFT_CONTROL).click(element).keyUp(Keys.LEFT_CONTROL).build().perform();
				return;
			} else {
				TestLogger.error("WebElement is null" + locator);
				throw new Exception("WebElement is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error(
					"Control plus Click operation failed on: " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : mouseOverWebElement Description : Mouse over to get tool
	 * tip
	 * 
	 * @param locator
	 *            : locator value
	 * @return : none
	 */
	protected void mouseOverWebElement(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.mouseOverWebElement");
		WebElement menu = null;
		try {
			TestLogger.info("- Mouse Hover on WebElement: " + locator);
			menu = locateElement(locator);
			if (menu == null) {
				TestLogger.error("WebElement is null: " + locator);
				throw new Exception("WebElement is null: " + locator);
			}
			Actions builder = new Actions(getDriver());
			builder.moveToElement(menu).build().perform();
			builder.clickAndHold(menu).build().perform();

		} catch (Exception e) {
			TestLogger.error("Mouse Hover on WebElement: " + locator + "  Exception is:  " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	protected void moveMousePosition(int x, int y) throws Exception {
		TestLogger.info("Inside : FrameworkBase.moveMousePosition");
		try {
			TestLogger.info("moveMousePosition to : " + "(" + x + "," + y + ")");
			Robot r = new Robot();
			r.mouseMove(x, y);
			return;
		} catch (Exception e) {
			TestLogger.error("Ajax Selection Failed" + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : printMessage Description : Send message to console and
	 * log file. Console printing is used during test Debugging. During actual
	 * execution, comment out Syso line
	 * 
	 * @param message
	 *            : String Message to be printed /sent too Console /log file
	 * @return : none
	 */
	public static void printMessage(String message) throws Exception {
		try {
			System.out.println(message);

			if (message.toLowerCase().trim().startsWith("fail")) {
				TestLogger.error(message);
			} else
				TestLogger.info(message);

		} catch (Exception e) {
			TestLogger.error("printMessage failed" + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : ajaxControlSelection Description : This is used to type
	 * value, and select one of the suggested values from list.
	 * 
	 * @param textLocator
	 *            : locator value for Webelement where text needs to be entered
	 * @param text
	 *            : text to be entered
	 * @param selectLocator
	 *            : locator value for suggested values that appears as Ajax
	 *            element
	 * @return : none
	 */
	protected void ajaxControlSelection(String textLocator, String text, String selectLocator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.ajaxControlSelection");
		try {
			TestLogger.debug("ajaxControlSelection - Enter text on : " + textLocator + "and select operation on:"
					+ selectLocator);
			enterText(textLocator, text);

			clickWebElement(selectLocator);
			return;
		} catch (Exception e) {
			TestLogger.error("Ajax Selection Failed" + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : enterText Description : This is used to type/set /enter
	 * value.
	 * 
	 * @param locatorTextBox
	 *            : locator value for Webelement where text needs to be entered
	 * @param text
	 *            : text to be entered
	 * @return : none
	 */
	protected void enterText(String locatorTextBox, String text) throws Exception {
		TestLogger.info("Inside : FrameworkBase.enterText");
		WebElement element = null;
		try {
			TestLogger.debug("enterText - Enter text operation on WebElement: " + locatorTextBox);
			element = locateElement(locatorTextBox);
			if (element != null) {
				element.clear();
				element.sendKeys(text);

				return;
			} else {
				TestLogger.error("WebElement is null" + locatorTextBox);
				throw new Exception("WebElement is null" + locatorTextBox);
			}
		} catch (Exception e) {
			TestLogger
					.error("Enter Text operation failed on: " + locatorTextBox + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : numberOfItems Description : Return the number of items
	 * present for locator.
	 * 
	 * @param locator
	 *            : locator value for Webelement where text needs to be entered
	 * @return : int
	 */
	protected int numberOfItems(String locator) throws Exception {
		List<WebElement> optionCount = getDriver().findElements(By.xpath(locator));
		return optionCount.size();
	}

	/**
	 * Function Name : verifyElementExists Description : Return true if element
	 * exists else return false
	 * 
	 * @param locator
	 *            : locator value for Webelement where text needs to be entered
	 * @return : boolean
	 */
	protected boolean verifyElementExists(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.verifyElementExists");
		By by = getLocatorString(locator);
		WebElement element = null;
		String err_Message = null;
		int number_Attempts = Integer
				.parseInt(ReadConfigData.getPropertyValue("WEBDRIVER_EXPLICIT_WAIT_TIME_IN_SECONDS"));
		for (int count = 1; count <= number_Attempts; count++) {

			try {
				element = getDriver().findElement(by);
				if (element != null) {
					return true;
				}
			} catch (StaleElementReferenceException ser) {
				waitForDOMElementsRefresh(ONE_SECOND);
				err_Message = ser.getMessage();
			} catch (NoSuchElementException ne) {
				waitForDOMElementsRefresh(ONE_SECOND);
				err_Message = ne.getMessage();
			} catch (Exception e) {
				waitForDOMElementsRefresh(ONE_SECOND);
				err_Message = e.getMessage();
			}
		}

		if (element != null)
			return true;
		else
			TestLogger.error(
					" Exception in locating Element in method FrameworkBase.verifyElementExists: " + err_Message);
		return false;

	}

	/**
	 * Function Name : isElementDisplayed Description : Return true if element
	 * is displayed on DOM
	 * 
	 * @param locator
	 *            : locator value for Webelement where text needs to be entered
	 * @return : boolean
	 */
	protected boolean isElementDisplayed(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.isElementDisplayed");
		WebElement element = null;
		try {
			element = locateElement(locator);
			if (element != null)
				if (element.isDisplayed()) {
					TestLogger.info("WebElement is  displayed :" + locator);
					return true;
				} else {
					TestLogger.error("WebElement is not displayed :" + locator);
					return false;
				}

			else {
				TestLogger.error("WebElement is null : " + locator);
				return false;
			}
		} catch (Exception e) {
			TestLogger.error(
					"FrameworkBase.isElementDisplayed Exception : " + locator + " \n Exception is: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : isElementEnabled Description : Return true if element is
	 * enabled else return false
	 * 
	 * @param locator
	 *            : locator value for Webelement
	 * @return : boolean
	 */
	protected boolean isElementEnabled(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.isElementEnabled");
		WebElement element = null;
		try {
			element = locateElement(locator);
			if (element != null)
				if (element.isEnabled()) {
					TestLogger.info("WebElement is  enabled :" + locator);
					return true;
				} else {
					TestLogger.error("WebElement is not enabled :" + locator);
					return false;
				}

			else {
				TestLogger.error("WebElement is null : " + locator);
				return false;
			}
		} catch (Exception e) {
			TestLogger.error(
					"FrameworkBase.isElementEnabled Exception : " + locator + " \n Exception is" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getElementAttributeValue Description : Return attribute
	 * values like 'value', 'innerText' , 'innerHTML'; If getText or
	 * getElementTextValue is returning null value, use this function to get
	 * reliable values.
	 * 
	 * @param locator
	 *            : locator value
	 * @param attributeName
	 *            : 'value', 'innerText' , 'innerHTML', 'textContent'
	 * @return : String
	 */
	protected String getElementAttributeValue(String locator, String attributeName) throws Exception {
		TestLogger.info("Inside : FrameworkBase.getElementAttributeValue");
		WebElement element = null;
		try {
			element = locateElement(locator);

			if (element != null)
				if (element.isDisplayed()) {
					return element.getAttribute(attributeName);
				} else {
					TestLogger.error("WebElement is present However it is not Displayed.: " + locator);
					throw new Exception("WebElement is present However it is not Displayed.: " + locator);
				}
			else {
				TestLogger.error("WebElement is null: " + locator);
				throw new Exception("WebElement is null: " + locator);
			}

		} catch (Exception e) {
			TestLogger.error("WebElement attribute not found: " + locator + " \n Exception is" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getElementTextValue Description : Equivalent to getText ,
	 * If getText or getElementTextValue is returning null value use this to get
	 * reliable values.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : String
	 */
	protected String getElementTextValue(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.getElementTextValue");
		WebElement element = null;
		String str_Value = "";
		waitForDOMElementsRefresh();
		try {
			element = locateElement(locator);
			if (element != null) {
				if (!element.isDisplayed()) {
					TestLogger.error("WebElement is present however it is  not displayed: " + locator);
					throw new Exception("WebElement is present however it is  not displayed: " + locator);

				}

				if (StringUtils.isNotBlank(element.getText())) {
					str_Value = element.getText();
					return str_Value;
				} else if (StringUtils.isNotBlank(element.getAttribute("innerText"))) {
					str_Value = element.getAttribute("innerText");
					return str_Value;
				} else if (StringUtils.isNotBlank(element.getAttribute("value"))) {
					str_Value = element.getAttribute("value");
					return str_Value;
				}

				else if (StringUtils.isNotBlank(element.getAttribute("textContent"))) {
					str_Value = element.getAttribute("textContent");
					return str_Value;
				} else if (StringUtils.isNotBlank(element.getText()) == false) {
					str_Value = "";
					return str_Value;
				}
			} else {
				TestLogger.error("WebElement is null: " + locator);
				throw new Exception("WebElement is null: " + locator);
			}
		} catch (Exception e) {
			TestLogger.error(
					"getElementTextValue operation failed on : " + locator + " \n Exception is" + e.getMessage());
			throw new Exception(e.getMessage());
		}
		return str_Value;
	}

	/**
	 * Function Name : waitForDOMElementsRefresh Description : Equivalent to
	 * static wait for Thread.sleep.
	 * 
	 * @param timeInSeconds
	 *            : wait time in Seconds
	 * @return : none
	 */
	public static void waitForDOMElementsRefresh(int timeInSeconds) throws Exception {

		try {
			Thread.sleep(timeInSeconds * 1000);
		} catch (Exception e) {
			TestLogger.error("Exception in waitForDOMElementsRefresh : \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : waitForDOMElementsRefresh Description : Equivalent to
	 * static wait for Thread.sleep. It will wait for the values set in config
	 * file. WAIT_TIME_FOR_DOM_ELEMENT_REFRESH
	 * 
	 * @return : none
	 */
	public static void waitForDOMElementsRefresh() throws Exception {
		waitForDOMElementsRefresh(
				Integer.valueOf(ReadConfigData.getPropertyValue("WAIT_TIME_FOR_DOM_ELEMENT_REFRESH")));
	}

	/**
	 * Function Name : uploadFile Description : upload file using Robot class
	 * * @param str_File : Filename alongiwth folder name. Ensure that all files
	 * are kept in folders or designated folders. src/main/resources/upLoadFiles
	 * 
	 * @return : none
	 */
	public static void uploadFile(String str_File) throws Exception {
		TestLogger.info("Inside : FrameworkBase.uploadFile");
		try {
			TestLogger.debug("Inside : FrameworkBase.uploadFile");
			StringSelection stringSelection = new StringSelection(str_File);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
			waitForDOMElementsRefresh();
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (Exception e) {
			TestLogger.error("Exception Caught: uploadFile file \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : delete_Downloaded_File Description : Clean up
	 * activity.Ensure that all files are downloaded in folders or designated
	 * folders. src/main/resourcesdownpLoadFiles
	 * 
	 * @return : none
	 */
	public static void delete_Downloaded_File() throws Exception {
		TestLogger.info("Inside : FrameworkBase.delete_Downloaded_File");
		try {
			TestLogger.debug("Inside : FrameworkBase.delete_Downloaded_File");
			FrameworkBase.printMessage("Deleting all files in download foler");

			File folder = new File(FrameworkBase.DOWNLOAD_FILE_PATH);
			File[] listOfFiles = folder.listFiles();

			FrameworkBase.printMessage("No of files found : " + listOfFiles.length);
			if (listOfFiles.length == 0) {
				return;
			}
			FrameworkBase.printMessage("Deleting all files in folders: '" + folder + "'");
			int lenght_OfFiles = listOfFiles.length;
			for (int i = 0; i < lenght_OfFiles; i++) {
				listOfFiles[i].delete();
			}

			FrameworkBase.printMessage("Deleted all files in folders  \n");
		} catch (Exception e) {
			TestLogger.error("Exception Caught: Downloding file \n" + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : get_List_Of_Available_Values Description : GetText of all
	 * matching webElements * @param locator : locator value
	 * 
	 * @return : String
	 */
	protected String get_List_Of_Available_Values(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.get_List_Of_Available_Values");
		String list_Values = "";
		String str_Value = "";
		try {
			List<WebElement> elements = locateElements(locator);
			if (elements.isEmpty() || elements.size() <= 0) {
				return list_Values;
			} else {
				for (WebElement element : elements) {
					if (StringUtils.isNotBlank(element.getText())) {
						str_Value = element.getText().trim();
					} else if (StringUtils.isNotBlank(element.getAttribute("innerText"))) {
						str_Value = element.getAttribute("innerText").trim();
					} else if (StringUtils.isNotBlank(element.getAttribute("value"))) {
						str_Value = element.getAttribute("value").trim();
					}

					list_Values = list_Values + ";" + str_Value.trim();
				}
			}
			list_Values = list_Values.trim().replaceFirst(";", "");
			return list_Values;
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.get_List_Of_Available_Values " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	protected String sortString(String string, String delimiter) throws Exception {
		TestLogger.info("Inside : FrameworkBase.sortString");
		try {
			String[] arr = string.trim().split(delimiter);
			Arrays.sort(arr);
			return StringUtils.join(arr, delimiter);
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.sortString method. " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : select_VisibleText Description : Select value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param visibleText
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void select_VisibleText(String locator, String... visibleText) throws Exception {
		TestLogger.info("Inside : FrameworkBase.select_VisibleText");
		WebElement element = null;

		try {
			TestLogger.debug(
					"select_VisibleText - from drowndown " + locator + "  and visibleText: " + visibleText.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + locator);

			}
			Select dropdown = new Select(element);
			if (visibleText.length >= 1 && dropdown.isMultiple()) {
				TestLogger.error("Multiple selection is not possible in FrameworkBase.select_VisibleText method");
				throw new Exception("Multiple selection is not possible in FrameworkBase.select_VisibleText method");

			}

			int length = visibleText.length;
			for (int i = 0; i < length; i++) {
				dropdown.selectByVisibleText(visibleText[i]);
			}

			return;
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.select_VisibleText method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : select_ByValue Description : Select value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param byValue
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void select_ByValue(String locator, String... byValue) throws Exception {
		TestLogger.info("Inside : FrameworkBase.select_ByValue");
		WebElement element = null;

		try {
			TestLogger.debug("select_ByValue - from drowndown " + locator + "  and byValue: " + byValue.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			if (byValue.length >= 1 && dropdown.isMultiple()) {
				TestLogger.error("Multiple selection is not possible in FrameworkBase.select_VisibleText method");
				throw new Exception("Multiple selection is not possible in FrameworkBase.select_VisibleText method");

			}
			int length = byValue.length;
			for (int i = 0; i < length; i++) {
				dropdown.selectByValue(byValue[i]);
			}

		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.select_ByValue method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : select_ByIndex Description : Select value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param index
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void select_ByIndex(String locator, int... index) throws Exception {
		TestLogger.info("Inside : FrameworkBase.select_ByIndex");
		WebElement element = null;

		try {
			TestLogger.debug("select_ByIndex - from drowndown " + locator + "  and index: " + index.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);
			if (index.length >= 1 && dropdown.isMultiple()) {
				TestLogger.error("Multiple selection is not possible in FrameworkBase.select_VisibleText method");
				throw new Exception("Multiple selection is not possible in FrameworkBase.select_VisibleText method");

			}

			int lenght = index.length;
			for (int i = 0; i < lenght; i++) {
				dropdown.selectByIndex(index[i]);
			}
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.select_ByIndex method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : deselect_VisibleText Description : Deselect value from
	 * Select list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param visibleText
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void deselect_VisibleText(String locator, String... visibleText) throws Exception {
		TestLogger.info("Inside : FrameworkBase.deselect_VisibleText");
		WebElement element = null;

		try {
			TestLogger.debug("deselect_VisibleText - from drowndown " + locator + "  and visibleText: "
					+ visibleText.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			int lenght = visibleText.length;
			for (int i = 0; i < lenght; i++) {
				dropdown.deselectByVisibleText(visibleText[i]);
			}
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.deselect_VisibleText method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : deselect_ByValue Description : Deselect value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param byValue
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void deselect_ByValue(String locator, String... byValue) throws Exception {
		TestLogger.info("Inside : FrameworkBase.deselect_ByValue");
		WebElement element = null;

		try {
			TestLogger.debug("deselect_ByValue - from drowndown " + locator + "  and byValue: " + byValue.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			int lenght = byValue.length;
			for (int i = 0; i < lenght; i++) {
				dropdown.deselectByValue(byValue[i]);
			}
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.deselect_ByValue method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : deselect_ByIndex Description : Deselect value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @param index
	 *            : variable length argument. e.g value1, value2 . or value1,
	 *            value2, value3 , ..value n. it could be null as well.
	 * @return : none
	 */
	protected void deselect_ByIndex(String locator, int... index) throws Exception {
		TestLogger.info("Inside : FrameworkBase.select_ByIndex");
		WebElement element = null;

		try {
			TestLogger.debug("deselect_ByIndex - from drowndown " + locator + "  and index: " + index.toString());
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			int length = index.length;
			for (int i = 0; i < length; i++) {
				dropdown.deselectByIndex(index[i]);
			}
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.deselect_ByIndex method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : deselect_All Description : Deselect all value from Select
	 * list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : none
	 */
	protected void deselect_All(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.deselect_All");
		WebElement element = null;

		try {
			TestLogger.debug("deselect_All - from drowndown " + locator);
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);
			dropdown.deselectAll();

		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.deselect_All method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getAllOptions Description : Get all available option
	 * values from Select list box. It can't be used for other non Select list.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : List<String>
	 */
	protected List<String> getAllOptions(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.getAllOptions");
		WebElement element = null;

		try {
			TestLogger.debug("getAllOptions - from drowndown " + locator);
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			List<WebElement> objWebelement = dropdown.getOptions();
			if (objWebelement.isEmpty() || objWebelement.size() <= 0) {
				TestLogger.error("Select list is Empty");
				return null;
			}
			List<String> lst_SelectedOptions = new ArrayList<String>();
			for (WebElement ele : objWebelement) {
				lst_SelectedOptions.add(ele.getText());
			}
			return lst_SelectedOptions;
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.getAllOptions method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getAllSelectedOptions Description : Get all selected
	 * option values from Select list box. It can't be used for other non Select
	 * list.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : List<String>
	 */
	protected List<String> getAllSelectedOptions(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.getAllSelectedOptions");
		WebElement element = null;

		try {
			TestLogger.debug("getAllSelectedOptions - from drowndown " + locator);
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);

			}
			Select dropdown = new Select(element);

			List<WebElement> objWebelement = dropdown.getAllSelectedOptions();
			if (objWebelement.isEmpty() || objWebelement.size() <= 0) {
				TestLogger.error("Select list is Empty");

			}
			List<String> lst_SelectedOptions = new ArrayList<String>();
			for (WebElement ele : objWebelement) {
				lst_SelectedOptions.add(ele.getText());
			}
			return lst_SelectedOptions;
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.getAllSelectedOptions method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : getFirstSelectedOption Description : Get first selected
	 * option values from Select list box. It can't be used for other non Select
	 * list.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : String
	 */
	protected String getFirstSelectedOption(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.getFirstSelectedOption");
		WebElement element = null;

		try {
			TestLogger.debug("getFirstSelectedOption - from drowndown " + locator);
			element = locateElement(locator);
			if (element == null) {
				TestLogger.error("WebElement is null: " + element);
				throw new Exception("WebElement is null: " + element);
			}
			Select dropdown = new Select(element);
			return dropdown.getFirstSelectedOption().getText();

		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.getFirstSelectedOption method: " + e.getMessage());
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * Function Name : copyFile Description : To copy the file from 1 folder to
	 * another
	 * 
	 * @param strFrom
	 *            : File Name and path to copy from
	 * @param strTo
	 *            : File name path to copy to
	 * @return : boolean
	 */
	protected boolean copyFile(String strFrom, String strTo) throws Exception {
		TestLogger.info("Inside : FrameworkBase.copyFile");

		boolean strResult = true;
		Path ToFolder;
		Path FromFolder;

		try {

			FromFolder = Paths.get(strFrom);
			ToFolder = Paths.get(strTo);
			CopyOption[] options = new CopyOption[] { StandardCopyOption.REPLACE_EXISTING,
					StandardCopyOption.COPY_ATTRIBUTES };

			java.nio.file.Files.copy(FromFolder, ToFolder, options);
			return strResult;

		} catch (Exception e) {
			strResult = false;
			TestLogger.error("Exception in FrameworkBase.copyFile method: " + e.getMessage());
			return strResult;
		}
	}

	/**
	 * Function Name : deleteFile Description : To delete the file
	 * 
	 * @param strFrom
	 *            : File Name and path to delete
	 * @return : boolean
	 */
	protected static boolean deleteFile(String strFilePath) throws Exception {
		TestLogger.info("Inside : FrameworkBase.deleteFile");
		boolean strResult = true;
		Path FromFolder;
		boolean blnResult;
		try {

			FromFolder = Paths.get(strFilePath);
			blnResult = java.nio.file.Files.deleteIfExists(FromFolder);

			if (blnResult == true) {
				return strResult;
			} else {
				return false;
			}

		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.deleteFile  method: " + e.getMessage());
			strResult = false;
			return strResult;
		}
	}

	/**
	 * Function Name : utilCreateDirectory Description : Create the folder
	 * structure. if not present then create else return
	 * 
	 * @param :
	 *            strFolderPath - Full Path to be created
	 * @return : boolean
	 */
	protected static boolean utilCreateDirectory(String strFolderPath) throws Exception {
		TestLogger.info("Inside : FrameworkBase.utilCreateDirectory");
		boolean strResult = true;
		File directory = new File(strFolderPath);
		try {
			if (directory.exists()) {
				strResult = true;
			} else if (directory.isFile()) {
				strResult = false;
			} else {
				if (!directory.exists()) {
					directory.mkdirs();
					strResult = true;
				}
			}

			return strResult;
		} catch (Exception e) {
			TestLogger.error("Exception in FrameworkBase.utilCreateDirectory  method: " + e.getMessage());
			strResult = false;
			return strResult;
		}
	}

	/**
	 * Function Name : VerifyText Description : To verify the expected and
	 * actual value
	 * 
	 * @param strExpected
	 *            : String Expected Value
	 * @param strActual
	 *            : String Actual Value
	 * @param strExactMatch
	 *            : Set False if Exact Match is not required , by default exact
	 *            match
	 * @param strCaseSensitive
	 *            : Set True id Case Sensitive comparison is required, by
	 *            default case in sensitive
	 * @return : String Pass\Fail
	 * 
	 */
	protected static String VerifyText(String strExpected, String strActual, String strExactMatch,
			String strCaseSensitive) throws Exception {
		TestLogger.info("Inside : FrameworkBase.VerifyText");
		String strResult = "Fail";

		try {
			// Go inside if Exact Match is required
			if (!strExactMatch.trim().equalsIgnoreCase("false")) {
				// Go inside if Not Case Sensitive Match is required
				if (strCaseSensitive.trim().equalsIgnoreCase("false")) {
					if (strExpected.equalsIgnoreCase(strActual)) {
						strResult = "Pass";
					} else {
						strResult = "Fail|Expected value : " + strExpected + " Actual Value : " + strActual;
					}
					// Go inside if Case Sensitive Match is required
				} else {
					if (strExpected.equals(strActual)) {
						strResult = "Pass";
					} else {
						strResult = "Fail|Expected value : " + strExpected + " Actual Value : " + strActual;
					}

				}

			} else {// Go inside if not Exact Match is required
					// Go inside if Not Case Sensitive Match is required
				if (!strCaseSensitive.trim().equalsIgnoreCase("true")) {
					if (strActual.toUpperCase().contains(strExpected.toUpperCase())) {
						strResult = "Pass";
					} else {
						strResult = "Fail|Expected value : " + strExpected + " Actual Value : " + strActual;
					}

				} else { // Go inside if Case Sensitive Match is required
					if (strActual.contains(strExpected)) {
						strResult = "Pass";
					} else {
						strResult = "Fail|Expected value : " + strExpected + " Actual Value : " + strActual;
					}
				}
			}

			return strResult;
		} catch (Exception e) {
			strResult = "Fail|Error in function VerifyText , Exception Message" + e.getMessage();
			return strResult;
		}
	}

	/**
	 * Function Name : selectCheckbox Description : To Select the checkbox
	 * provided it is not already selected.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : none
	 */
	protected void selectCheckbox(String locator) throws Exception {
		TestLogger.info("Inside : FrameworkBase.selectCheckbox");
		try {
			WebElement element = locateElement(locator);

			if (!element.isSelected()) {

				element.click();
			} else {
				TestLogger.info("Checkbox is already selected and hence not clicking");
			}
		} catch (Exception e) {
			TestLogger.error("selectCheckbox operation failed Exception Message" + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : unselectCheckbox Description : To Unselect the checkbox
	 * provided it is not already unselected.
	 * 
	 * @param locator
	 *            : locator value
	 * @return : none
	 */
	protected void unselectCheckbox(String locator) throws Exception {
		WebElement element = locateElement(locator);
		try {
			TestLogger.info("Inside : FrameworkBase.unselectCheckbox");
			if (element.isSelected()) {
				element.click();
			} else {
				TestLogger.info("Checkbox is already unselected and hence not clicking");
			}
		} catch (Exception e) {
			TestLogger.error("unselectCheckbox operation failed on: " + locator + " Exception :" + e.getMessage());
			throw new Exception(e.getMessage());
		}

	}

	/**
	 * Function Name : VerifyList Description : To verify the expected and
	 * actual value in the list
	 * 
	 * @param arrExpected
	 *            : Array list of String Expected Value
	 * @param arrActual
	 *            : Array list of String Actual Value
	 * @return : String Pass\Fail
	 */
	protected static String VerifyList(ArrayList<String> arrExpected, ArrayList<String> arrActual) throws Exception {
		TestLogger.info("Inside : FrameworkBase.VerifyList");
		String strResult = "Fail";
		Integer intExpCount;
		Integer intActCount;
		String strTempResult = "";
		String strExpected;
		String strActual;

		try {
			int arr_Expected_Size = arrExpected.size();
			int arr_Actual_Size = arrActual.size();
			for (intExpCount = 0; intExpCount < arr_Expected_Size; intExpCount++) {
				strExpected = arrExpected.get(intExpCount);

				for (intActCount = 0; intActCount < arr_Actual_Size; intActCount++) {
					strActual = arrActual.get(intActCount);

					if (strExpected.equals(strActual)) {
						strExpected = "";
						break;
					}

				}

				if (strTempResult.trim().equals("")) {
					strTempResult = strTempResult + strExpected;
				} else {
					if (!strExpected.trim().equals("")) {
						strTempResult = strTempResult + ";" + strExpected;
					}
				}

			}

			if (strTempResult.trim().equals("")) {
				strResult = "Pass";
				return strResult;

			} else {

				strResult = strResult + "|" + "Following values are not present in the list " + strTempResult;
				return strResult;
			}

		} catch (Exception e) {
			TestLogger.error("Exception in method  FrameworkBase.VerifyList \n" + e.getMessage());
			strResult = "Fail|Error in function VerifyList , Exception Message" + e.getMessage();

			return strResult;
		}

	}

	/**
	 * Function Name : VerifyList Description : To verify the expected and
	 * actual value in the list
	 * 
	 * @param arrExpected
	 *            : Array of String Expected Value
	 * @param arrActual
	 *            : Array of String Actual Value
	 * @return : String Pass\Fail
	 * 
	 */
	protected static String VerifyList(String[] arrExpected, String[] arrActual) throws Exception {
		TestLogger.info("Inside : FrameworkBase.VerifyList");
		String strResult = "Fail";
		Integer intExpCount;
		Integer intActCount;
		String strTempResult = "";
		String strExpected;
		String strActual;

		try {
			int arr_Expected_Size = arrExpected.length;
			int arr_Actual_Size = arrActual.length;
			for (intExpCount = 0; intExpCount < arr_Expected_Size; intExpCount++) {
				strExpected = arrExpected[intExpCount];
				for (intActCount = 0; intActCount < arr_Actual_Size; intActCount++) {
					strActual = arrActual[intActCount];

					if (strExpected.equals(strActual)) {
						strExpected = "";
						break;
					}

				}

				if (strTempResult.trim().equals("")) {
					strTempResult = strTempResult + strExpected;
				} else {
					if (!strExpected.trim().equals("")) {
						strTempResult = strTempResult + ";" + strExpected;
					}
				}

			}

			if (strTempResult.trim().equals("")) {
				strResult = "Pass";
				return strResult;

			} else {
				strResult = strResult + "|" + "Following values are not present in the list " + strTempResult;
				return strResult;
			}

		} catch (Exception e) {
			TestLogger.error("Exception in method  FrameworkBase.VerifyList \n" + e.getMessage());
			strResult = "Fail|Error in function VerifyList , Exception Message" + e.getMessage();

			return strResult;
		}

	}

	/**
	 * Function Name : VerifyList Description : To verify the expected and
	 * actual value in the list
	 * 
	 * @param strExp
	 *            : Delimited String Expected Value
	 * @param strAct
	 *            : Delimited String Actual Value
	 * @param strDelm
	 *            : Delimiter to break the string
	 * @return : String Pass\Fail
	 */
	protected static String VerifyList(String strExp, String strAct, String strDelm) throws Exception {
		TestLogger.info("Inside : FrameworkBase.VerifyList");
		String strResult = "Fail";
		Integer intExpCount;
		Integer intActCount;
		String strTempResult = "";
		String strExpected;
		String strActual;
		String[] arrActual;
		String[] arrExpected;

		try {
			if ((strDelm.trim().equals("") || strDelm.trim().equals("|")) && !(strDelm.equals("\t"))) {

				strDelm = "\\|";
			}

			arrActual = strAct.split(strDelm, -1);
			arrExpected = strExp.split(strDelm, -1);
			int arr_Expected_Size = arrExpected.length;
			int arr_Actual_Size = arrActual.length;

			for (intExpCount = 0; intExpCount < arr_Expected_Size; intExpCount++) {
				strExpected = arrExpected[intExpCount];
				for (intActCount = 0; intActCount < arr_Actual_Size; intActCount++) {
					strActual = arrActual[intActCount];

					if (strExpected.equals(strActual)) {
						strExpected = "";
						break;
					}

				}

				if (strTempResult.trim().equals("")) {
					strTempResult = strTempResult + strExpected;
				} else {
					if (!strExpected.trim().equals("")) {
						strTempResult = strTempResult + ";" + strExpected;
					}
				}

			}

			if (strTempResult.trim().equals("")) {
				strResult = "Pass";
				return strResult;

			} else {

				strResult = strResult + "|" + "Following values are not present in the list " + strTempResult;
				return strResult;
			}

		} catch (Exception e) {
			TestLogger.error("Exception in method  FrameworkBase.VerifyList \n" + e.getMessage());
			strResult = "Fail|Error in function VerifyList , Exception Message" + e.getMessage();

			return strResult;
		}
	}

	public static void untilPageLoadComplete() throws Exception {
		WebDriver driver = getDriver();
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			waitForDOMElementsRefresh(ONE_SECOND);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			Assert.fail("Timeout waiting for Page Load Request to complete.");
		}
	}
	
	
	public static void killProcess(String processName) throws Exception{
		TestLogger.debug("Inside : FrameworkBase.killProcess: " + processName +".exe");
		try{
			String cmdarray ="cmd /c start c:/windows/system32/cmd.exe " +"taskkill /f /im "+ processName+  ".exe /t";		
			Runtime rt =Runtime.getRuntime();
			rt.exec(cmdarray);
		}
		catch(Exception e){
			TestLogger.error("Exception in FrameworkBase.killProcess while killing chromedriver  process. \n" + e.getMessage());
		}
	}

}