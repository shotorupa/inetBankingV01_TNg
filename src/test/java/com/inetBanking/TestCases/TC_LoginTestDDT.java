package com.inetBanking.TestCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBanking.PageObject.LoginPage;
import com.inetBanking.Utilitis.XlUtils;

public class TC_LoginTestDDT  extends BaseClass{
	
	
	@Test(dataProvider="LoginData")
     public void loginDDT(String user,String pwd) throws InterruptedException{
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		Thread.sleep(3000);
		
		if(isAlertPresent()==true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("login passed");
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	public boolean isAlertPresent() {
		
		try {
			driver.switchTo().alert();
		}catch(NoAlertPresentException e) {
			return false;
		}
		return false;
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][]getData() throws IOException{
		String path= System.getProperty("user.dir")+"/src/test/java/com/inetBanking/TestData/Test  Data.xlsx";
	   
		int rownum=XlUtils.getRowCount(path,"Sheet1");
	    int colcount=XlUtils.getCellCount(path,"Sheet1",1);
	    String logindata[][]=new String[rownum][colcount];
	    
	    for(int i=1; i<=rownum; i++) {
	    	for(int j=0; j<colcount; j++) {
	    		logindata[i-1][j]=XlUtils.getCellData(path,"Sheet1",i,j);
	    	}
	    }
	    return logindata;
	}

}
