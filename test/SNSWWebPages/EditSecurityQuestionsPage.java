package SNSWWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EditSecurityQuestionsPage extends DriverPage 
{

	public EditSecurityQuestionsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
			
	//First Question and Answer
	@FindBy(id="firstsecurityquestion")
	private WebElement firstQuestion;
	
	@FindBy(id="firstsecurityanswer")
	private WebElement firstAnswer;
	
	//Second Question and Answer
	@FindBy(id="secondsecurityquestion")
	private WebElement secondQuestion;
	
	@FindBy(id="secondsecurityanswer")
	private WebElement secondAnswer;
	
	//Third Question and Answer
	@FindBy(id="thirdsecurityquestion")
	private WebElement thirdQuestion;
	
	@FindBy(id="thirdsecurityanswer")
	private WebElement thirdAnswer;
	
	//Save Button
	@FindBy(xpath="//button[text()='Save']")
	private WebElement SaveBtn;
	
	public void selectFirstQ()
	{
		Select firstSel = new Select(firstQuestion);
		firstSel.selectByIndex(1);
		
	}
	
	public void enterFirstAnswer(String firstAns){
		explicitFluentWait(firstAnswer);
		firstAnswer.sendKeys(firstAns);
	}
	public void selectSecondQ()
	{
		Select secondSel = new Select(secondQuestion);
		secondSel.selectByIndex(1);
	}
	
	public void enterSecondAnswer(String secondAns){
		explicitFluentWait(secondAnswer);
		secondAnswer.sendKeys(secondAns);
	}
	
	public void selectThirdQ()
	{
		Select thirdSel = new Select(thirdQuestion);
		thirdSel.selectByIndex(1);
	}
	
	public void enterThirdAnswer(String thirdAns){
		explicitFluentWait(thirdAnswer);
		thirdAnswer.sendKeys(thirdAns);
	}
	
	public void pressSaveBtn(){
		SaveBtn.click();
	}
	public SettingsPage EditQuestions(String firstAns,String secondAns, String thirdAns){
		
		explicitFluentWait(firstQuestion);
		selectFirstQ();
		enterFirstAnswer(firstAns);
		selectSecondQ();
		enterSecondAnswer(secondAns);
		selectThirdQ();
		enterThirdAnswer(thirdAns);
		pressSaveBtn();
		return PageFactory.initElements(driver, SettingsPage.class);
	}
	
}
