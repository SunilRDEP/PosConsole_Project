package rough;

import utility.ExcelReader;

public class Excel_Reading {

	public static void main(String[] args) {
		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\Test_Data_Sheet.xlsx");
		// excel.addSheet("Test Sunil");
		// excel.addColumn("Test Sunil", "SLNo.");
		// excel.addColumn("Test Sunil", "SUMAN");
		// excel.addColumn("Test Sunil", "SUNIL");
		//System.out.println(excel.setCellData("Test Sunil", "1234", 3, "1234"));
		System.out.println(excel.getCellData("Test Sunil", "1234", 3));
	}
}
 