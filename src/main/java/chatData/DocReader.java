package chatData;

import java.io.File;   
import java.io.FileOutputStream;   
import org.apache.poi.xwpf.usermodel.XWPFDocument;   
import org.apache.poi.xwpf.usermodel.XWPFParagraph;   
import org.apache.poi.xwpf.usermodel.XWPFRun;   

public class DocReader 
{
	public void newWordDoc(String filePath, String filename, String fileContent)   throws Exception 
	{   
		@SuppressWarnings("resource")
		XWPFDocument document = new XWPFDocument();   
		XWPFParagraph tmpParagraph = document.createParagraph();   
		XWPFRun tmpRun = tmpParagraph.createRun();   
		tmpRun.setText(fileContent);   
		tmpRun.setFontSize(18);
		String filePath1 = System.getProperty("user.dir");
		String filePath2 = filePath1.concat(filePath);
		FileOutputStream fos = new FileOutputStream (new File (filePath2 + filename + ".doc"));   
		document.write(fos);
		fos.close();
	}
}

