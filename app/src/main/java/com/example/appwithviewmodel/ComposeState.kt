package com.example.appwithviewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class ComposeState : ViewModel() {
  private val _username= mutableStateListOf("")
   // username: State<String>=_username
    private val _password= mutableStateListOf("")
 //   password: State<String>=_password
}