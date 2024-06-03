package com.example.demo.service;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public ResponseEntity<?> registerUser(UserDTO userDTO){

        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);

        if(savedUser.getUserId() != null){
            return ResponseEntity.ok(1);
        }else{
            return ResponseEntity.ok(0);
        }
    }

    public ResponseEntity<?> selectUserList(){
        List<User> userList = userRepository.findAll();

        List<UserDTO> userDTOList = userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();

        return ResponseEntity.ok(userDTOList);
    }

}
