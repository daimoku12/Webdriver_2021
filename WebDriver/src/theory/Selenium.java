package theory;

/* Selenium supports 8 Element locators to recognize elements in web pages.

id,
name,
className,
tagName,
linkText,
partialLinkText,
cssSelector,
xpath

------------------------------------------------
Important WebDriver API Commands

1) get() - Opens a specified URL in the Browser window.

driver.get("https://www.google.com");
------------------------------------------------
2) getTitle() - Returns the Browser Title.

String Title = driver.getTitle();
------------------------------------------------
3) getCurrentUrl() -  Returns Current URL of the Browser

String Url = driver.getCurrentUrl();
----------------------------------------------------------
4) navigate().to() - Loads a new page in the current browser window.

driver.navigate().to("https://in.yahoo.com");
------------------------------------------------
5) navigate().back() - It moves a single item back in the Browser history.

driver.navigate().back();
------------------------------------------------
6) navigate().forward() - It moves single item forward in the browser history.

driver.navigate().forward();
------------------------------------------------
7) navigate().refresh() - Refreshes the Current web page

driver.get("https://www.google.com");
------------------------------------------------
8) close() - Closes the focused Browser.

driver.close();
------------------------------------------------
9) findElement() - Finds the first Element within the current page using given locator.

driver.findElement(By.id("Email")).sendKeys("India123");
------------------------------------------------
10) sendKeys() - Enters a value into Edit box/Text box.

driver.findElement(By.id("Email")).sendKeys("India@123");
------------------------------------------------
11) clear() - It clears the value from Edit box

driver.findElement(By.id("Email")).clear();
------------------------------------------------
12) click() - Clicks an Element (Buttons, Links etc...)

driver.findElement(By.id("next")).click();
------------------------------------------------
13) isEnabled() - Checks weather the Element is in Enabled state or not?

boolean a = driver.findElement(By.id("next")).isEnabled();
------------------------------------------------
14) isDisplayed() - Checks weather the Element is displayed or not?

boolean a = driver.findElement(By.linkText("Gmail")).isDisplayed();
------------------------------------------------
15) isSelected() - Checks weather the Element is selected or not?

boolean after = driver.findElement(By.xpath("html/body/input[3]")).isSelected();
.................................................................
16) getText()
17) getAttribute() - Returns value of attribute

<input attr1='a' attr2='b' attr3='c'>foo</input>
getAttribute(attr1) you get 'a'
getAttribute(attr2) you get 'b'
getAttribute(attr3) you get 'c'
getText() with no parameter you can only get 'foo'

...........................................................
18) NoSuchElementException
19) invalid element state
------------------------------------------------
20) For List - size() and get()
...................................................
21) Element.getLocation().getX() and getY() - If 0, element is not visible
*/

public class Selenium {

}
