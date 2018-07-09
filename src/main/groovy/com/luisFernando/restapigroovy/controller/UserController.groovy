package com.luisFernando.restapigroovy.controller

import com.luisFernando.restapigroovy.model.User
import com.luisFernando.restapigroovy.repository.UserRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
class UserController {


    @GetMapping("/users")
    List getAllUsers(){
        UserRepository.USERS
    }


    @GetMapping("/tostring")
    String toString(){
        UserRepository.USERS.inject(''){ acc, user ->
            acc + "${user.name}, ${user.age} "
        }
    }

    @GetMapping("/ageavg")
    int getAvgAge(){
        UserRepository.USERS.inject (0){ acc, user ->
            acc + user.age/2
        }
    }

    @GetMapping("/agesum")
    int getAgeSum(){
        UserRepository.USERS.inject (0){ acc, user ->
            acc + user.age
        }
    }

    @GetMapping("/name")
    String getAllNames(){
        UserRepository.USERS.inject (''){ acc, user ->
            acc + "${user.name} "
        }
    }

    @GetMapping("/age")
    String getAllAges(){
        UserRepository.USERS.inject (''){ acc, user ->
            acc + "${user.age} "
        }
    }

    @GetMapping("/oddage")
    List getOddAge(){
        UserRepository.USERS.findAll{it.age % 2 == 1}
    }

    @GetMapping("/evenage")
    List getEvenAge(){
        UserRepository.USERS.findAll{it.age % 2 == 0}
    }

    @GetMapping("/agebiggerthan")
    List ageBiggerThan(@RequestParam int age){
        UserRepository.USERS.findAll{it.age > age}
    }
}
