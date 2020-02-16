package automationpractise.util;

import java.util.ArrayList;

import automationpractise.util.Xls_reader;



public class TestUtil {
	
	
	 static Xls_reader reader;
		
	 public static ArrayList<Object[]> GetDataFromExcel() {
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_reader("C:\\Users\\Swami\\eclipse-workspace\\AutoPractices\\src\\main\\java\\ap\\testdata\\CreatMessage.xlsx");
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum = 2; rowNum<= reader.getRowCount("message"); rowNum++) {
			
			String title = reader.getCellData("message", "title", rowNum);
			String email = reader.getCellData("message", "email", rowNum);
			String message = reader.getCellData("message", "message", rowNum);
			
			Object ob[] = {title,email,message};
			myData.add(ob);
		}	
		
		return myData;
		
	}

	 
	
}
