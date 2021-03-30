package theory;

/*Link - If the HTML code starts with 'a', it is a link
XPATH - Absolute and Relative
HTML (Tag, Attributes, Inner Text)

// "+i+" - Pass value in xpath

1. Tag with single attribute    //input[@id='email']  Mention '@' before attribute
2. Tag with multi attribute with Logical OR  //input[@id='email' or @name='email']
3. Tag with multi attribute with Logical AND  //input[@id='email' and @name='email']
4. //input[@*='email']
5. //*[@*='email']
6. Tag with inner text   <span>Create an account</span>  //span[text()='Create an account']
7. Tag with some part of text  //span[contains(text(),'an account')]
8. Tag with some part of Attribute  //input[contains(@id,'ema')]
9. Using parent to child  //table[@role='presentation']/tbody/tr[2]/td/input
or //table[@role='presentation']//input
10. Using child to parent
//input[@id='email']/parent::td/parent::tr/parent::tbody/parent::table
11. XPath for sibling (following and preceding)
//input[@id='u_0_7']/following-sibling::input[1]
input [i] : i is the index starting 1
//input[@id='u_0_8']/preceding-sibling::input[1]
 
*/

public class XPath {

}
