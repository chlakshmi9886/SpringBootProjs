package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.EmployeeInfo;
import com.nt.repository.EmployeeInfoRepo;

@Component
public class CollectionMappingTestRunner implements CommandLineRunner {

	@Autowired
	private EmployeeInfoRepo empRepo;
	
	@Override
	public void run(String... args) throws Exception {
		EmployeeInfo info = new EmployeeInfo();
		info.setEname("raj sha");
		info.setFriends(List.of("ramesh","rakesh"));
		info.setPhone(Set.of(99999999L, 88888888888L));
		info.setIdDetails(Map.of("aadhar","6985688554455","pan","254789654556"));
		System.out.println("employee saved with id "+ empRepo.save(info).getEno());
		
		Iterable<EmployeeInfo> it = empRepo.findAll();
		it.forEach(System.out::println);
	}

}
