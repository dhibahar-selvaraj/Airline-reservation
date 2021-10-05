package com.example.demo.layer3.AdminRepository;


import org.springframework.stereotype.Repository;

import com.example.demo.model.AirAdmin;




@Repository
public interface AdminRepository { //DAO is known as Repository framework
	AirAdmin selectAdminbyid(String dno);
}
//interface DeptRepository cannot be instantiated
//but the child of this interface can be innstantiated
