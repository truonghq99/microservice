package com.thomas.user.service;

import com.thomas.user.VO.Department;
import com.thomas.user.VO.ResponseTemplateVO;
import com.thomas.user.entity.User;
import com.thomas.user.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("User saved in userservice.");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long id){
        ResponseTemplateVO vo= new ResponseTemplateVO();
        User user = userRepository.findByUserId(id);

        Department department= 
            restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        vo.setUser(user);
        vo.setDepartment(department);
        return vo;
        }
}
