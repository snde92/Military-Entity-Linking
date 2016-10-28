import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;

public class Picture {
	public int id;
	public String title;
	public String shortTitle;
	public String date;
	public String url;
	public String imgUrl;
	public String shortIntro;
	public ArrayList<String> intro;
	public String printPicInfo() {
		//String str = id +"\t"+ title + "\t" + shortTitle + "\t" + date + "\t" + url + "\t" + imgUrl + "\t" + intro.get(0) + "\r\n";
		String str = id + "\t" + title + "\t" + shortTitle + "\t" +  intro.toString() + "\r\n";
		return str;
	}
	 public void download(String downloadPath)  
	 {         
		 String imageName= id + imgUrl.substring(imgUrl.lastIndexOf("."),imgUrl.length());  
		 try {  
			 URL uri=new URL(imgUrl);   
	         InputStream in=uri.openStream();                   
	         String file=downloadPath+imageName; 
	         FileOutputStream fo=new FileOutputStream(new File(file));  
	         byte[] buf=new byte[1024];  
	         int length=0;  
	         while((length=in.read(buf,0,buf.length))!=-1)  
	        	 fo.write(buf, 0, length);  
	         in.close(); 
	         fo.close();  
	         } catch (FileNotFoundException e1) {                  
	        	 System.out.println("找不到文件");  
	         } catch(IOException e2) {  
	             System.out.println("IO异常");  
	         }  
	 }
}
