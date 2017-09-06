import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MainDataTime 
{
	public static Date stringToDateFormat(String srcDate) throws ParseException 
	{
		String pattern1 = "yyMMddHHmm";
		SimpleDateFormat sdf1 = new SimpleDateFormat(pattern1);
	
		Date date = sdf1.parse(srcDate);
		
		//debug
		System.out.println("stringToDateFormat(), date: " + date);
		
		return date;
	}
	
	
	public static void DataTimeTest() throws ParseException 
	{
		String srcDate = "1708181648";
		Date recordDT = stringToDateFormat(srcDate);
		Date currentDT = new Date(System.currentTimeMillis());
		
		System.out.println(	"Data DT: " + recordDT.toString() + 
							", currentDT: " + currentDT.toString() + 
							", compare DT: " + recordDT.compareTo(currentDT));
		
		System.out.println("currentDT - recordDT = " + 
							new Date(currentDT.getTime() - recordDT.getTime()) );
	}
	
	public static void testHexStringToByteArray()
	{
		String hexString = "11081F111A";
		String lastEndDT = "11081F112A";
		byte[] byteArrayHex = Utils.toByteArray(hexString);
		
		System.out.println("byte Array: " + Arrays.toString(byteArrayHex));

		long tmpLong = Utils.checkDifferentMinute(hexString, lastEndDT);
		System.out.println("tmpLong: " + tmpLong);
	}
		
	public static void main(String[] args)
	{
		//try {
		//	DataTimeTest();
		//} catch (ParseException e) {
		//	// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}
		
		testHexStringToByteArray();
	}

}
