package com.nt.config;



import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;




@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping(value = "/employee/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getEmployee(@AuthenticationPrincipal Jwt principal, @PathVariable String id) {
        System.out.println(principal.toString());
        System.out.println("user name "+ principal.getClaimAsString("preferred_username"));
        return new Employee(id, "John Newman");
    }
    @GetMapping(value = "/student/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getStudent(@AuthenticationPrincipal Jwt principal, @PathVariable String id) {
        System.out.println(principal.toString());
        System.out.println("user name "+ principal.getClaimAsString("preferred_username"));
        return new Employee(id, "John Newman");
    }
    @GetMapping(value = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getAllEmployees(@AuthenticationPrincipal Jwt principal, @PathVariable String id) {
        System.out.println(principal.toString());
        System.out.println("user name "+ principal.getClaimAsString("preferred_username"));
        return new Employee(id, "John Newman");
    }
    @GetMapping(value = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee getAllStudents(@AuthenticationPrincipal Jwt principal, @PathVariable String id) {
        System.out.println(principal.toString());
        System.out.println("user name "+ principal.getClaimAsString("preferred_username"));
        return new Employee(id, "John Newman");
    }
}