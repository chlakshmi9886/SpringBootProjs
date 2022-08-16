package com.nt.runner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.OutputStream;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.PersonInfo;
import com.nt.service.IPersonInfoService;

@Component
public class PersonInfoLobTestRunner implements CommandLineRunner {

	@Autowired
	private IPersonInfoService service;
	
	@Override
	public void run(String... args) throws Exception {
		/*Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter person Name ");		
		String name = sc.next();
		
		System.out.println("Enter Date of birth ");		
		String dbirth = sc.next();
		
		System.out.println("Is person married? ");		
		boolean status = sc.nextBoolean();
		
		System.out.println("Enter the photo file path ");		
		String imagePath = sc.next().trim();
		
		System.out.println("Enter biodata path ");		
		String biodataPath = sc.next().trim();
		
		//Converting string date format to LocalDateTime class object 
		LocalDateTime ldt = LocalDateTime.parse(dbirth);
		
		// Prepare byte[] from the photo file content
		File file1 = new File(imagePath);
		FileInputStream fis = new FileInputStream(file1);
		byte[] photoContent = new byte[(int) file1.length()];
		fis.read(photoContent);
		
		//Prepare char[] from the resume file content
		File file2 = new File(biodataPath);
		FileReader reader = new FileReader(file2);
		char[] resumeContent = new char[(int) file2.length()];
		reader.read(resumeContent);
		
		PersonInfo info = new PersonInfo();
		info.setPname(name);
		info.setDob(ldt);
		info.setMarried(status);
		info.setPimage(photoContent);
		info.setPbiodata(resumeContent);
				
		try {
			service.registerPersonInfo(info);
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}*/
		
		System.out.println("===========Retrieval Logic =============");
		try {
		PersonInfo person = service.fetchPersonDetailsById(11);
		
		if(person != null)
		{
			System.out.println("person id : " +person.getPid() + " Person Name : " + person.getPname() + " Person DOB : " +person.getDob());
			
			// retrieving photo data from db
			byte[] photoContent = person.getPimage();
			OutputStream os = new FileOutputStream("d:\\images\\ntr_photo_download.jpg");
			os.write(photoContent);
			os.flush();
			os.close();
			
			System.out.println("photo retrieved successful from db");
			char[] biodataContent = person.getPbiodata();
			Writer writer = new FileWriter("d:\\images\\biodata_retrieved.txt");
			writer.write(biodataContent);
			writer.flush();
			writer.close();
			System.out.println("retrieved biodata successfully from db");
		}
		else {
			System.out.println("person info not found");
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}

	}

}
