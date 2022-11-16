package com.inetBanking.TestCases;



import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;

public class TC_LoginTest_001  extends BaseClass{
	
	@Test
	public void LoginTest() throws InterruptedException, IOException {
		
		logger.info("URL is open");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
	
		Thread.sleep(3000);
		lp.setPassword(password);
		logger.info("Entered password");
		
		lp.clickSubmit();
		
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage1"))
		{
			Assert.assertTrue(true);
			logger.info("Longin test passed");
		}
		else
		{
		captureScreen(driver, "TC_LoginTest_001");
		Assert.assertTrue(false);
		logger.info("Loging test failed");
	     }
		
	}
}
