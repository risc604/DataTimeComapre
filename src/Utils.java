import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.xml.bind.DatatypeConverter;

public class Utils 
{

	public static String toHexString(byte[] array) {
	    return DatatypeConverter.printHexBinary(array);
	}

	public static byte[] toByteArray(String s) {
	    return DatatypeConverter.parseHexBinary(s);
	}
	
	public static int byteToUnsignedInt(byte b)
    {
        return 0x00 << 24 | b & 0xff;
    }
	
	public static int[] covertDTFormat(String srcTime)
    {
        //byte[] startByte = hexStringToByteArray(srcTime);
		byte[] startByte = toByteArray(srcTime);
		int[] dtNumber = new int[startByte.length];
        for (int i=0; i<startByte.length; i++)
        {
            dtNumber[i] = byteToUnsignedInt(startByte[i]);
        }

        //Log.d(TAG, "Date Time Number: " + Arrays.toString(dtNumber));
        System.out.println("Date Time Number: " + Arrays.toString(dtNumber));
        return  dtNumber;
    }
	
	
	public static Date covertToDateObj(String srcTime)
    {
        //byte[] startByte = hexStringToByteArray(srcTime);
		byte[] startByte = toByteArray(srcTime);
		int[] dtNumber = new int[startByte.length];
        for (int i=0; i<startByte.length; i++)
        {
            dtNumber[i] = byteToUnsignedInt(startByte[i]);
        }
        System.out.println("Date Time Number: " + Arrays.toString(dtNumber));
        
        final String pattern = "[yy, MM, dd, HH, mm]";	
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Date tmpDate = null;
		try {
			tmpDate = sdf.parse(Arrays.toString(dtNumber));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return  tmpDate;
    }
	
	
	public static long checkDifferentMinute(String startDT, String lastEndDT)
    {
		Date[] dtArray = new Date[2];
		dtArray[0] = covertToDateObj(startDT);
		dtArray[1] = covertToDateObj(lastEndDT);
		long diffMinute = Math.abs((dtArray[0].getTime() - dtArray[1].getTime()) / (1000 * 60));
        System.out.println("dtArray[0]: " + dtArray[0].toString() + ", dtArray[1]: " + dtArray[1].toString() +
                			", diffMinute: " + diffMinute);

      
        return diffMinute;
    }

}

