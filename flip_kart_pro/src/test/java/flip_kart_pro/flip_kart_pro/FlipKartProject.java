package flip_kart_pro.flip_kart_pro;

import org.testng.annotations.Test;

import Generic_lib.Base_test;
import PomObjectRepo.HomePage;
import PomObjectRepo.Product_page;

public class FlipKartProject extends Base_test{
	
	@Test
	public void Select_Prodect() throws Throwable
	{
		String phone = eLib.getExcellData(EXCEL_path, "Sheet1", 1, 0);
		
		//searching product
		HomePage home = new HomePage(driver);
		home.Sreach_Options(phone);
		
		///filtering  the productand getting the  list is assanding order 
		Product_page proPage = new Product_page(driver);
		proPage.Product_Page();
	}

}
