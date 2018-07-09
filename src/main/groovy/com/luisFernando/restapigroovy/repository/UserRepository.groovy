package com.luisFernando.restapigroovy.repository

import com.luisFernando.restapigroovy.model.User

class UserRepository {


    final static USERS = [
            new User(name: 'Luis', age: 27),
            new User(name: 'Evandro', age: 45),
            new User(name: 'Carlos', age: 22)
    ]
}