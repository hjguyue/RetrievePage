package retrieve;

import java.io.*;
import java.util.Vector;

public class Retriever {

	public static int threadMax = 80;	
	public static int threadNum = 0;	
	public static PrintStream printer;
	
	public static final Object threadLock = new Object();
	public static Vector<UrlEntity> urlEntities = new Vector<UrlEntity>();
	
	public static void setThreadMax(int num){
		threadMax = num;
	}
	
	public static void setOutput(String fileName){
		try {
			printer = new PrintStream(new File(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void retrieve(){
		UrlEntity entity = urlEntities.remove(urlEntities.size()-1);
		RetrieveThread retriever = new RetrieveThread(entity);
		retriever.start();
		Retriever.threadNum++;
	}
	
}
