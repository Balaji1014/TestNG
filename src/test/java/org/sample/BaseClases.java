package org.sample;

import java.awt.AWTException;
import java.awt.KeyEventPostProcessor;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClases {

	public static WebDriver driver;
	
	public static Actions a;
	
	public static Robot r;
	
	public static Alert al;
	
	public static TakesScreenshot ts;
	
	public static JavascriptExecutor js;
	
	public static Select s;
	
	public static void browserConfigure() {
		
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();	
	}
	
	public static void getUrl(String url) {
		
		driver.get(url);
		
	}
	public static void maxiMize() {
		
		driver.manage().window().maximize();

	}
	public static void getTitle() {
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	public static void getCurrentUrl() {
		
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
		
	}
	
	public static void close() {
		
		driver.close();
	}
	
	public static void quit() {
	
		driver.quit();
	}
	
	public static void sendKeys(WebElement ref , String data) {
		
		ref.sendKeys(data);
		
	}
	
	public static void click(WebElement ref) {
		
		ref.click();
	}
	
	public static void getText(WebElement ref) {
		String text = ref.getText();
		System.out.println(text);
	}
	
	public static void getAttribute(WebElement ref) {
	
		String attribute = ref.getAttribute("value");
		System.out.println(attribute);
	}
	
	
	public static void actions(WebDriver ref) {
	
		a = new Actions(ref);
	}
	
	public static void moveToElement(WebElement ref) {
		a.moveToElement(ref).perform();
	}
	
	public static void rightClick(WebElement ref) {
		a.contextClick(ref).perform();
	}
	
	public static void doubleClick(WebElement ref) {
		a.doubleClick(ref).perform();
	}
	
	public static void dragAndDrop(WebElement source , WebElement target) {
		a.dragAndDrop(source, target).perform();
	}
	
	public static void keyUpShift() {
		
		a.keyUp(Keys.SHIFT).perform();
	}
	
	public static void keyDownShift() {
	
		a.keyDown(Keys.SHIFT).perform();
	}
	
	public static void robotClass() throws AWTException {
		
		r = new Robot();
	}
	
	public static void keyPress(int arg0) {
		
		r.keyPress(arg0);
	}
	
	public static void keyRelease(int arg0) {
		
		r.keyRelease(arg0);
	}
	
	
	public static void alert() {
		
		al = driver.switchTo().alert();
	}
	
	public static void accept() {
		
		al.accept();
	}
	
	public static void cancle() {

		al.dismiss();
	}
	
	public static void alertSendKeys(String data) {
		
		al.sendKeys(data);
	}
	
	public static void alertGetText() {
		String text = al.getText();
		System.out.println(text);
	}
	
	public static void takeScreenShot(String ref) throws IOException {
		
		ts = (TakesScreenshot)driver;
		
		File ss = ts.getScreenshotAs(OutputType.FILE);
		
		File F = new File(ref);
	
		FileUtils.copyFile(ss, F);
	}
	
	public static void javaScriptExecutor(String arg , WebElement ref) {
		
		js = (JavascriptExecutor)driver;

		Object get = js.executeScript(arg, ref);
		System.out.println(get);
		
	}
	public static String returnjavaScriptExecutor(String arg , WebElement ref) {
		
		js = (JavascriptExecutor)driver;

		Object getText = js.executeScript(arg , ref);
		
		String s = (String)getText;
		
		return s;
	}
	
	public static void switchToFrame(WebElement ref) {
		
		driver.switchTo().frame(ref);
	}
	
	public static void getParentWindow() {
		
		String parentWindow = driver.getWindowHandle();
		System.out.println(parentWindow);

	}
	
	public static void getAllWindows() {
		
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
	}
	public static void switchToNextWindow(int i) {
		
		Set<String> allWindow = driver.getWindowHandles();
		System.out.println(allWindow);
	
		List<String> l = new LinkedList<String>();
		l.addAll(allWindow);
		driver.switchTo().window(l.get(i));
	}
	public static void dropDown(WebElement ref) {
		
		s = new Select(ref);
	
	}
	public static void selectByIndex(int i) {
		
		s.selectByIndex(i);

	}
	public static void getOptions() {
		
		List<WebElement> options = s.getOptions();
		System.out.println(options);

	}
	
	public static void getAllSelectedOption() {
		List<WebElement> allSelected = s.getAllSelectedOptions();
		System.out.println(allSelected);
	}
	public static void getFirstSelectedOption() {
		WebElement firstSelected = s.getFirstSelectedOption();
		System.out.println(firstSelected);

	}
	
	public static void getAllExcelValues(String path , int index) throws IOException {
		File f = new File(path);
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook xs = new XSSFWorkbook(fi);	// Upcasting XSSFWorkbook to Workbook//
		
		Sheet sh = xs.getSheetAt(index);
		
		for (int i = 0; i < sh.getPhysicalNumberOfRows(); i++) {
			
			Row r = sh.getRow(i);
			for (int j = 0; j < r.getPhysicalNumberOfCells(); j++) {
			
				Cell c = r.getCell(j);
				String value = "";
				int ct = c.getCellType();
				if (ct==1) {
					
					value = c.getStringCellValue();
				}
				else if (DateUtil.isCellDateFormatted(c)) {
					
					Date dv = c.getDateCellValue();
					SimpleDateFormat si = new SimpleDateFormat("dd-M-yyyy");
					value = si.format(dv);
				}
				else {
					
					double nu = c.getNumericCellValue();
				
					long l = (long)nu;
					value = String.valueOf(l);
				
				}
			System.out.println(value);
			
			}
		}

	}
	

	public static String returnExcelValues(String path , int sheetIndex , int rowIndex , int cellIndex) throws IOException {
			File f = new File(path);
			
			FileInputStream fi = new FileInputStream(f);
			
			Workbook xs = new XSSFWorkbook(fi);
			
			Sheet sh = xs.getSheetAt(sheetIndex);
				
				Row r = sh.getRow(rowIndex);
					Cell c = r.getCell(cellIndex);
					String value = "";
					int ct = c.getCellType();
					if (ct==1) {
						
						value = c.getStringCellValue();
					}
					else if (DateUtil.isCellDateFormatted(c)) {
						
						Date dv = c.getDateCellValue();
						SimpleDateFormat si = new SimpleDateFormat("dd-M-yyyy");
						value = si.format(dv);
					}
					else {
						
						double nu = c.getNumericCellValue();
					
						long l = (long)nu;
						value = String.valueOf(l);
					
					}
				return value;			 
		}	
	
		public static void writeInExcel(String path , String sheet , int row , int cell , String setValue) throws IOException {
			File f = new File(path);
			
			Workbook xs = new XSSFWorkbook();
			
			Sheet Sheet = xs.createSheet(sheet);
			
			Row Row = Sheet.createRow(row);
			
			Cell Cell = Row.createCell(cell);
			
			Cell.setCellValue(setValue);
			
			FileOutputStream out = new FileOutputStream(f);

			xs.write(out);
			
			System.out.println("Writed.....");


		}


	public static void writeRowWithCell(String path , int index , int row , int cell , String setValue) throws IOException {
		
		File f = new File(path);

		FileInputStream fi = new FileInputStream(f);
		Workbook xs = new XSSFWorkbook(fi);
			
		Sheet Sheet = xs.getSheetAt(index);
			
		Row Row = Sheet.createRow(row);
			
		Cell Cell = Row.createCell(cell);
			
		Cell.setCellValue(setValue);
			
		FileOutputStream out = new FileOutputStream(f);

		xs.write(out);
			
		System.out.println("Writed.....");


		}

public static void writeOnlyCell(String path , int index , int row , int cell , String setValue) throws IOException {
		
		File f = new File(path);
		
		FileInputStream fi = new FileInputStream(f);
		
		Workbook xs = new XSSFWorkbook(fi);
			
		Sheet Sheet = xs.getSheetAt(index);
			
		Row Row = Sheet.getRow(row);
			
		Cell Cell = Row.createCell(cell);
			
		Cell.setCellValue(setValue);
			
		FileOutputStream out = new FileOutputStream(f);

		xs.write(out);
			
		System.out.println("Writed.....");


		}

public static void updateExcel(String path , int index , int row , int cell , String data , String setValue) throws IOException {
	
	File f = new File(path);

	FileInputStream fi = new FileInputStream(f);
	
	Workbook xs = new XSSFWorkbook(fi);
		
	Sheet Sheet = xs.getSheetAt(index);
		
	Row Row = Sheet.getRow(row);
		
	Cell Cell = Row.getCell(cell);
	String sv = Cell.getStringCellValue();

	if (sv.equals(data)) {
		
		Cell.setCellValue(setValue);
	}

	FileOutputStream out = new FileOutputStream(f);
	xs.write(out);

	System.out.println("Writed......");
}








}
	
	
	
	
	
	
	
	
	

