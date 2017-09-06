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
	
	public long checkDifferentMinute(String startDT, String lastEndDT)
    {
        int[] intStartDT = covertDTFormat(startDT);
        int[] intLastEndDT = covertDTFormat(lastEndDT);

        System.out.println("checkDifferentMinute(), intStartDT: " + Arrays.toString(intStartDT) +
                    ", intLastEndDT: " + Arrays.toString(intLastEndDT));
        Date[] dtArray = new Date[2];
        dtArray[0] = new Date(  intStartDT[0]+(2000-1900), intStartDT[1]-1, intStartDT[2],
                                intStartDT[3], intStartDT[4]);
        dtArray[1] = new Date(  intLastEndDT[0]+(2000-1900), intLastEndDT[1]-1, intLastEndDT[2],
                                intLastEndDT[3], intLastEndDT[4]);

        long diffMinute = Math.abs((dtArray[0].getTime() - dtArray[1].getTime()) / (1000 * 60));
        System.out.println("intStartDT[]: " + Arrays.toString(intStartDT) +
                ", intLastEndDT[]: " + Arrays.toString(intLastEndDT) +
                "\n, dtArray[0]: " + dtArray[0].toString() +
                ", dtArray[1]: " + dtArray[1].toString() +
                ", diffMinute: " + diffMinute);

            return diffMinute;
    }

}

