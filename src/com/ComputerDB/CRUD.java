package com.ComputerDB;


import java.io.File;

import java.io.FileReader;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


//import org.testng.annotations.Test;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUD extends TestCase {
    private WebDriver driver;
    private Properties properties = new Properties();
      CRUD crud;
  
	
    @BeforeClass
    public void setUp() throws Exception {
    	
        
        properties.load(new FileReader(new File("C:\\Users\\Azy009\\workspace\\BackBase-TestAutomation\\src\\config&object.properties")));
        //Dont Change below line. Set this value in test.properties file incase you need to change it..
        System.setProperty("webdriver.chrome.driver",properties.getProperty("chromeexepath") );
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(properties.getProperty("baseUrl"));   
    }

    @After
    public void tearDown() throws Exception {
       //driver.quit();
    	
    }

    @Test
    public void testAabortCreateComputer( ) throws Exception {
    	
        // Finds and click on Add computer button ]
         WebElement addNewComputer = driver.findElement(By.id(properties.getProperty("add.new.computer")));
         addNewComputer.click();
         
       // Finds computer name field and enters input
         WebElement computerName = driver.findElement(By.id(properties.getProperty("computer.name")));
         String computerNamevalue = properties.getProperty("computer*Name");
         computerName.sendKeys(computerNamevalue);

         //finds Introduce Date field and enters test input
         WebElement introduceDateFieldNegative = driver.findElement(By.id(properties.getProperty("introduce.datefield")));
         String introduceDateValue = properties.getProperty("introduce*date*negative");
         introduceDateFieldNegative.sendKeys(introduceDateValue);
         
         //Finds Discontinued Date field and enters test input 
         WebElement discontinuedDateFieldNegative = driver.findElement(By.id(properties.getProperty("discontinued.datefield")));
         String discontinuedDateValue = properties.getProperty("discontinued*date*nagative");
         discontinuedDateFieldNegative.sendKeys(discontinuedDateValue);
         
         // Selects a company name
         WebElement companyDropdown = driver.findElement(By.id(properties.getProperty("company.dropdown")));
         Select dropDown = new Select(companyDropdown);
         dropDown.selectByIndex(5);
         
        // Clicks on Cancel button to abort
        WebElement cancelButton = driver.findElement(By.xpath(properties.getProperty("cancel.button")));
        cancelButton.click();
        
        //verify that cancellation led to navigation to home page
        String url = driver.getCurrentUrl();
        assertEquals("http://computer-database.herokuapp.com/computers", url );
        
        
         }
    
    @Test
    public void testBcreateComputer( ) throws Exception {
    	
       // Finds and click on Add computer button ]
        WebElement addNewComputer = driver.findElement(By.id(properties.getProperty("add.new.computer")));
        addNewComputer.click();
        
      // Finds computer name field and enters input
        WebElement computerName = driver.findElement(By.id(properties.getProperty("computer.name")));
        String computerNamevalue = properties.getProperty("computer*Name");
        computerName.sendKeys(computerNamevalue);

        //finds Introduce Date field and enters test input
        WebElement introduceDateField = driver.findElement(By.id(properties.getProperty("introduce.datefield")));
        String introduceDateValue = properties.getProperty("introduce*date");
        introduceDateField.sendKeys(introduceDateValue);
        
        //Finds Discontinued Date field and enters test input 
        WebElement discontinuedDateField = driver.findElement(By.id(properties.getProperty("discontinued.datefield")));
        String discontinuedDateValue = properties.getProperty("discontinued*date");
        discontinuedDateField.sendKeys(discontinuedDateValue);
        
        // Selects a company name
        WebElement companyDropdown = driver.findElement(By.id(properties.getProperty("company.dropdown")));
        Select dropDown = new Select(companyDropdown);
        dropDown.selectByIndex(3);
       // Clicks on Create This Computer Button
       WebElement createThisComputerButton = driver.findElement(By.xpath(properties.getProperty("create.this.computerButton")));
        createThisComputerButton.click();
        
      // Verifies that computer was successfully created
    		   WebElement computerCreatedText = driver.findElement(By.xpath("//*[@id='main']/div[1]"));
    			boolean expectedText = computerCreatedText.isDisplayed();
    			String actualText = "Done! Computer ASTRA has been created";
    			assertEquals(actualText, expectedText, true);			
    }
   @Test
    public void testCsearchComputer(){
    WebElement searchBoxField = driver.findElement(By.id(properties.getProperty("search.boxfield")));
    String searchBoxInput = properties.getProperty("search*box");
    searchBoxField.sendKeys(searchBoxInput);
    
    WebElement filterByNameButton = driver.findElement(By.id(properties.getProperty("search.boxbutton")));
    filterByNameButton.click();
    
    WebElement clickComputer = driver.findElement(By.linkText(properties.getProperty("search*result*linktext")));
    		clickComputer.click();
    
    
    	
    	
    }
   @Test
	public void testD_updateComputer () throws InterruptedException{
		  //crud = new CRUD ();
	
	   //Search for computer
	   WebElement searchBoxField = driver.findElement(By.id(properties.getProperty("search.boxfield")));
	    String searchBoxInput = properties.getProperty("search*box");
	    searchBoxField.sendKeys(searchBoxInput);
	    WebElement filterByNameButton = driver.findElement(By.id(properties.getProperty("search.boxbutton")));
	    filterByNameButton.click();
	    //Clicks to select computer
	    WebElement clickComputer = driver.findElement(By.linkText(properties.getProperty("search*result*linktext"))); 
	    		clickComputer.click();
	   
		 // Finds computer name field and enters input
        WebElement computerNameUpdate = driver.findElement(By.id(properties.getProperty("computer.name")));
        String computerNameUpdatevalue = properties.getProperty("computer*Name*update");
        computerNameUpdate.clear();
        computerNameUpdate.sendKeys(computerNameUpdatevalue);

        //finds Introduce Date field and enters test input
        WebElement introduceDateFieldUpdate = driver.findElement(By.id(properties.getProperty("introduce.datefield")));
        String introduceDateUpdateValue = properties.getProperty("introduce*date*Update");
        introduceDateFieldUpdate.clear();
        introduceDateFieldUpdate.sendKeys(introduceDateUpdateValue);
        
        //Finds Discontinued Date field and enters test input 
        WebElement discontinuedDateField = driver.findElement(By.id(properties.getProperty("discontinued.datefield")));
        String discontinuedDateUpdateValue = properties.getProperty("introduce*date*Update");
        discontinuedDateField.clear();
        discontinuedDateField.sendKeys(discontinuedDateUpdateValue);
        
        // Selects a company name
        WebElement companyDropdown = driver.findElement(By.id(properties.getProperty("company.dropdown")));
        Select dropDown = new Select(companyDropdown);
        dropDown.selectByIndex(4);
       // Clicks on Create This Computer Button
       WebElement createThisComputerButton = driver.findElement(By.xpath(properties.getProperty("create.this.computerButton")));
        createThisComputerButton.click();
        
      // Verifies that computer was successfully created and msg displayed
    		   WebElement computerCreatedText = driver.findElement(By.xpath("//*[@id='main']/div[1]"));
    		    boolean displayed =  computerCreatedText.isDisplayed();
    		    assertTrue(displayed);
    			String expectedText = computerCreatedText.getText();
    			String actualText = properties.getProperty("actualText*update"); 
    			assertEquals(actualText,expectedText);
    			
	}
   @Test
   public void testE_deleteComputer(){
	 
	   //Search for computer to be deleted
	   WebElement searchBoxField = driver.findElement(By.id(properties.getProperty("search.boxfield")));
	    String searchBoxInput = properties.getProperty("computer*Name*update");
	    searchBoxField.sendKeys(searchBoxInput);
	    
	    WebElement filterByNameButton = driver.findElement(By.id(properties.getProperty("search.boxbutton")));
	    filterByNameButton.click();
	    
	    WebElement clickComputer = driver.findElement(By.linkText(properties.getProperty("search*result*updated*linktext")));
         clickComputer.click();    		
	   WebElement deleteThisComputer = driver.findElement(By.xpath(properties.getProperty("delete.computerbtn")));
	    deleteThisComputer.click();
	    
	 // Verifies that computer was successfully deleted an;pod message displayed
		   WebElement computerDeletedText = driver.findElement(By.xpath("//*[@id='main']/div[1]"));
		    boolean displayed =  computerDeletedText.isDisplayed();
		    assertTrue(displayed);
			String expectedText = computerDeletedText.getText();
			String actualText = "Done! Computer has been deleted";
			assertEquals(actualText,expectedText);
   }
			
	@Test		 
   public void testF_attemptRetrieveofDeletedComputer(){
					 
			// Attempts to retrieve for deleted computer..
			
			 WebElement searchBoxFieldD = driver.findElement(By.id(properties.getProperty("search.boxfield")));
			    String searchBoxInputD = properties.getProperty("computer*Name*update");
			    searchBoxFieldD.sendKeys(searchBoxInputD);
			    
			    WebElement filterByNameButtonD = driver.findElement(By.id(properties.getProperty("search.boxbutton")));
			    filterByNameButtonD.click();
			    
			    // verifies that nothing was retrieved
			    
			    WebElement lt = driver.findElement(By.xpath(properties.getProperty("nothing.to.display")));
			    lt.isDisplayed(); 
			    
			  //*[@id="main"]/div[2]
			    //WebElement clickComputerD = driver.findElement(By.linkText("ASTRAB"));
			    	//	clickComputerD.click();    
			
			
			 //hthhow to use Github and how to derive testcases
			
			//work on cancel function..
			//Search non exiting  computer
			
	    
	    
	    		//*[@id="main"]/form[2]/input
	    		//#main > form.topRight > input
	    		
	    		
	    		
	   
	   
	   
	   
   }
}
