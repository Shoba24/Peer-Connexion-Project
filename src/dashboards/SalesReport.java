package dashboards;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SalesReport {
	
	WebDriver driver;
	@BeforeClass
	public void web() {
		System.setProperty("webdriver.chrome.driver","C:\\Web Driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ph-uat.peerconnexions.com");
	}
	@Test(dataProvider="Signin",dataProviderClass = DataSheetprovider.class)
	public void signuppage(String email,String password) {
		//Sign in
		WebElement signin = driver.findElement(By.xpath("//*[@id=\'site-header\']/div[1]/div/div/div[9]/a/span[1]"));
		signin.click();
		
		//Credentials
		WebElement emailbox = driver.findElement(By.name("email"));
		emailbox.sendKeys(email);
		
		WebElement passwordbox = driver.findElement(By.name("password"));
		passwordbox.sendKeys(password);
		
		//Sign in button
		WebElement m =driver.findElement(By.xpath("//*[@id=\'root\']/div[3]/div/div/div/div/div[2]/div/form/div[3]/button"));
	    JavascriptExecutor j =(JavascriptExecutor) driver;
		j.executeScript("arguments[0].click();",m);
	
		
		//BuyerZone
		WebElement buyerzone=driver.findElement(By.xpath("//*[@id=\"site-header\"]/div[2]/div/div/div[2]/div/nav/div/ul/li[4]/a/span"));
		buyerzone.click();
				
		//My Dash board
		WebElement mydashboard = driver.findElement(By.xpath("//*[@id=\'site-header\']/div[2]/div/div/div[2]/div/nav/div/ul/li[4]/div/button[3]/a/span"));
		mydashboard.click();

	}
	@Test(priority= 2,dataProvider="Daterange",dataProviderClass = DataSheetprovider.class)
	public void DateRange(String stdate,String eddate) {
		 //Date Range
		WebElement datebox =driver.findElement(By.xpath("//*[@id=\'root\']/div[3]/div/div[2]/div/div/div[2]/div/div[3]/div/div/div[1]/span/span"));
		datebox.click();
		
		//StartDate
		WebElement startdate =driver.findElement(By.cssSelector("body.language-en:nth-child(2) div.ant-calendar-picker-container.ant-calendar-picker-container-placement-bottomLeft div.ant-calendar.ant-calendar-range div.ant-calendar-panel div.ant-calendar-date-panel div.ant-calendar-range-part.ant-calendar-range-left:nth-child(1) div.ant-calendar-input-wrap:nth-child(1) div.ant-calendar-date-input-wrap > input.ant-calendar-input"));
        startdate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
        startdate.sendKeys(Keys.BACK_SPACE);
        startdate.sendKeys(stdate);
      
         //End Date
 		WebElement enddate =driver.findElement(By.cssSelector("body.language-en:nth-child(2) div.ant-calendar-picker-container.ant-calendar-picker-container-placement-bottomLeft div.ant-calendar.ant-calendar-range div.ant-calendar-panel div.ant-calendar-date-panel div.ant-calendar-range-part.ant-calendar-range-right:nth-child(3) div.ant-calendar-input-wrap:nth-child(1) div.ant-calendar-date-input-wrap > input.ant-calendar-input"));
 		enddate.sendKeys(Keys.chord(Keys.CONTROL,"a"));
 		enddate.sendKeys(Keys.BACK_SPACE);
 		enddate.sendKeys(eddate);
        enddate.sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 		}
	@Test(priority=3)
	public void Suppliernameplusandminus() throws InterruptedException {
		//Plus
		 JavascriptExecutor s = (JavascriptExecutor) driver;
   	  s.executeScript("window.scrollBy(0,50)");
   	  //Thread.sleep(3000);
   	  System.out.println("Scrolled down..");
		 WebElement plus1 =driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/div"));
	  	 plus1.click();
	  JavascriptExecutor si = (JavascriptExecutor) driver;
  	  si.executeScript("window.scrollBy(0,50)");
  	  Thread.sleep(3000);
  	  System.out.println("Scrolled down..");
	  	 //Minus
	  	 WebElement minus1= driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div[3]/div[1]/div[2]/div/div/div/div/div/div/table/tbody/tr[1]/td[1]/div"));
	  	 minus1.click();
	  	 Thread.sleep(5000);
	}
	@Test(priority=4,dataProvider="Supplier",dataProviderClass =DataSheetprovider.class )
	public void Suppliernmaecolumn(String sch) throws InterruptedException {
		//Search
		WebElement search1=driver.findElement(By.cssSelector("#root > div.site > div > div.block.full-card > div > div > div.col-12.col-lg-10.mt-4.mt-lg-0 > div > div.reseller-table-div.registration-summary-inn.reseller-sales-dashboard > div.ant-tabs.ant-tabs-top.ant-tabs-line > div.ant-tabs-content.ant-tabs-content-animated.ant-tabs-top-content > div.ant-tabs-tabpane.ant-tabs-tabpane-active > div.table-responsive > div > div > div > div > div > div > table > thead > tr > th:nth-child(2) > span > div > span.ant-table-column-title > div > span > input"));
		
		search1.sendKeys(sch);
		Thread.sleep(5000);
		search1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		search1.sendKeys(Keys.DELETE);
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(5000);
		
		
		
	}
	@Test(priority=6)
	public void sort1() throws InterruptedException {
		//Sort1
		WebElement datedes = driver.findElement(By.xpath("//thead/tr[1]/th[4]/span[1]/div[1]/span[2]/div[1]/i[2]/*[1]"));
  		datedes.click();
  	    WebElement datease =driver.findElement(By.xpath("//thead/tr[1]/th[4]/span[1]/div[1]/span[2]/div[1]/i[1]/*[1]"));
  		datease.click();
  		Thread.sleep(5000);
  	}
	@Test(priority=5,dataProvider="Orderno",dataProviderClass =DataSheetprovider.class )
	public void ordernocolumn(String schod) throws InterruptedException {
		WebElement search2=driver.findElement(By.cssSelector("#root > div.site > div > div.block.full-card > div > div > div.col-12.col-lg-10.mt-4.mt-lg-0 > div > div.reseller-table-div.registration-summary-inn.reseller-sales-dashboard > div.ant-tabs.ant-tabs-top.ant-tabs-line > div.ant-tabs-content.ant-tabs-content-animated.ant-tabs-top-content > div.ant-tabs-tabpane.ant-tabs-tabpane-active > div.table-responsive > div > div > div > div > div > div > table > thead > tr > th:nth-child(3) > span > div > span.ant-table-column-title > div > span > input"));
		search2.sendKeys(schod);
		search2.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	    search2.sendKeys(Keys.DELETE);
	    search2.sendKeys(Keys.ENTER);
	    Thread.sleep(5000);
	    }
	@Test(priority=7)
	public void sort2() throws InterruptedException {
		//Sort2
		WebElement orderdes = driver.findElement(By.xpath("//thead/tr[1]/th[5]/span[1]/div[1]/span[2]/div[1]/i[2]/*[1]"));
  		orderdes.click();
  		Thread.sleep(3000);
  		WebElement orderase = driver.findElement(By.xpath("//thead/tr[1]/th[5]/span[1]/div[1]/span[2]/div[1]/i[2]/*[1]"));
  		orderase.click();	
	}
	@Test(priority=8)
	public void filter() throws InterruptedException {
		//Filter Menu
			WebElement filtermenu =driver.findElement(By.xpath("//thead/tr[1]/th[6]/i[1]/*[1]"));
			filtermenu.click();
			//Thread.sleep(1000);
			
			//Part fulfilled
			WebElement partcheckbox =driver.findElement(By.cssSelector("body.language-en:nth-child(2) div.ant-dropdown.ant-dropdown-placement-bottomRight div.ant-table-filter-dropdown ul.ant-dropdown-menu.ant-dropdown-menu-without-submenu.ant-dropdown-menu-root.ant-dropdown-menu-vertical li.ant-dropdown-menu-item:nth-child(2) > label.ant-checkbox-wrapper:nth-child(1)"));
			partcheckbox.click();
			Thread.sleep(3000);
			//OK Button
			WebElement okbutton =driver.findElement(By.xpath("//a[contains(text(),'OK')]"));
			okbutton.click();
			Thread.sleep(5000);
			
			WebElement filtermenu1 =driver.findElement(By.xpath("//thead/tr[1]/th[6]/i[1]/*[1]"));
			filtermenu1.click();
			Thread.sleep(3000);
			//Reset Button
			WebElement resetbutton =driver.findElement(By.xpath("//a[contains(text(),'Reset')]"));
			resetbutton.click();
			Thread.sleep(5000);
			
			//Scroll down with action
			Actions act =new Actions(driver);
			act.sendKeys(Keys.PAGE_DOWN).build().perform();
			Thread.sleep(3000);
			
			System.out.println("Scroll down performed");
	}
	@Test(priority=9)
	public void pagenavigation() throws InterruptedException {
		//Page navigation 
			
			WebElement typepage =driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div[3]/div[1]/div[2]/div/div/div/ul/li[11]/div[2]/input"));
  			typepage.sendKeys("1");
  			typepage.sendKeys(Keys.ENTER);
  			
  		   
			
			WebElement pagedrop =driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[4]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]/ul[1]/li[11]/div[1]/div[1]/span[1]/i[1]/*[1]"));
			pagedrop.click();
			WebElement pagedrrop1 = driver.findElement(By.xpath("//li[contains(text(),'20 / page')]"));
			pagedrop.click();
			
			WebElement page1 =driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div[3]/div[1]/div[2]/div/div/div/ul/li[10]/a"));
			page1.click();
			Thread.sleep(5000);
			
			
  			
  			Actions ac = new Actions(driver);
  			ac.sendKeys(Keys.PAGE_UP).build().perform();
  			System.out.println("Scroll up performed");
  			Thread.sleep(3000);
  			

  			//Download Excel1
  			/*WebElement e1 = driver.findElement(By.cssSelector("body.language-en:nth-child(2) div.site div.site__body:nth-child(3) div.block.full-card div.container-fluid div.row div.col-12.col-lg-10.mt-4.mt-lg-0:nth-child(2) div.card div.card-body.pl-3.pr-3.pb-2.pt-2 div.col-md-12 div.row div.col-md-5.p-0.text-right:nth-child(3) a.btn.btn-secondary.mr-2 > span:nth-child(2)"));
  			e1.click();
  			Thread.sleep(6000);*/
	}
	@Test(priority=10)
	public void bonusreport() {
  			
  		//BonusLedgerReport
  			WebElement Bonus=driver.findElement(By.xpath("//span[contains(text(),'Bonus Accrued Report')]"));
  			Bonus.click();
  			////JavascriptExecutor si = (JavascriptExecutor) driver;
  	  	 // si.executeScript("window.scrollBy(0,150)");
  			
  		//drop down
  			WebElement drop1=driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/*[1]"));
  			drop1.click();
  		}
	/*@Test(priority=11,dataProvider = "Datepicker",dataProviderClass =DataSheetprovider.class  )
	public void daterange1(String stdate,String eddate) throws InterruptedException {
		Actions ac = new Actions(driver);
			ac.sendKeys(Keys.PAGE_UP).build().perform();
			System.out.println("Scroll up performed");
			Thread.sleep(3000);
		WebElement date =driver.findElement(By.xpath("//body/div[@id='root']/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[4]/div[1]/span[1]/span[1]"));
	   date.click();
	    
	    //start date
	    WebElement startdate1=driver.findElement(By.cssSelector("#document-body > div:nth-child(11) > div > div > div > div > div.ant-calendar-date-panel > div.ant-calendar-range-part.ant-calendar-range-left > div.ant-calendar-input-wrap > div > input"));
	    startdate1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	    startdate1.sendKeys(Keys.BACK_SPACE);
	    startdate1.sendKeys(stdate);
	    startdate1.sendKeys(Keys.ENTER);
	    
	    
	    //end date
	    WebElement enddate1=driver.findElement(By.cssSelector("#document-body > div:nth-child(11) > div > div > div > div > div.ant-calendar-date-panel > div.ant-calendar-range-part.ant-calendar-range-left > div.ant-calendar-input-wrap > div > input"));
	    enddate1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
	    enddate1.sendKeys(Keys.BACK_SPACE);
	    enddate1.sendKeys(eddate);
	    enddate1.sendKeys(Keys.ENTER);
	   
	}*/
	/*@Test(priority=11)
	public void column() throws InterruptedException {
    WebElement search1=driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div/div/div/div/div/table/thead/tr/th[1]/span/div/span[1]/div/span/input"));
		
		search1.sendKeys("PH_ODOR29031434_3106_8316944");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Thread.sleep(5000);
		search1.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		search1.sendKeys(Keys.DELETE);
		search1.sendKeys(Keys.ENTER);
		Thread.sleep(8000);
		}*/
	/*@Test(priority=11)
	public void sort() throws InterruptedException {
		WebElement sort1 = driver.findElement(By.cssSelector("#root > div.site > div > div.block.full-card > div > div > div.col-12.col-lg-10.mt-4.mt-lg-0 > div > div.reseller-table-div.registration-summary-inn.sales-dashboard.bonus_applied_report_table-div > div.ant-table-wrapper > div > div > div > div > div > table > thead > tr > th.ant-table-column-has-actions.ant-table-column-has-sorters.ant-table-column-sort > span > div > span.ant-table-column-sorter > div > i.anticon.anticon-caret-down.ant-table-column-sorter-down.on > svg > path"));
		 JavascriptExecutor j =(JavascriptExecutor) driver;
			j.executeScript("arguments[0].click();",sort1);
			
		Thread .sleep(2000);
		WebElement sort2 = driver.findElement(By.cssSelector("#root > div.site > div > div.block.full-card > div > div > div.col-12.col-lg-10.mt-4.mt-lg-0 > div > div.reseller-table-div.registration-summary-inn.sales-dashboard.bonus_applied_report_table-div > div.ant-table-wrapper > div > div > div > div > div > table > thead > tr > th.ant-table-column-has-actions.ant-table-column-has-sorters.ant-table-column-sort > span > div > span.ant-table-column-sorter > div > i.anticon.anticon-caret-up.ant-table-column-sorter-up.on > svg"));
		 JavascriptExecutor j1 =(JavascriptExecutor) driver;
			j1.executeScript("arguments[0].click();",sort2);
			
	}*/
	/*@Test(priority=11)
	public void pagenavigation1() throws InterruptedException {
		Actions act =new Actions(driver);
		act.sendKeys(Keys.PAGE_DOWN).build().perform();
		Thread.sleep(3000);
		
		System.out.println("Scroll down performed");
		WebElement page1= driver.findElement(By.xpath("//*[@id=\"root\"]/div[3]/div/div[2]/div/div/div[2]/div/div[4]/div[2]/div/div/ul/li[6]/a"));
		page1.click();
	}*/
	
	}


