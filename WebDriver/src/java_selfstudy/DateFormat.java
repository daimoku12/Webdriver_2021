package java_selfstudy;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

public class DateFormat {
	
	public static void main(String[] args) {
		
		 SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss");
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 System.out.println(sdf.format(timestamp));
		 
		 LocalDateTime today = LocalDateTime.now();
		 System.out.println(today);
		 
		 System.out.println(LocalDateTime.now());
		 
		 String a = System.getProperty("user.dir")+"/src/report"+LocalDateTime.now()+".html";
		 System.out.println(a);
		 
	}

}
