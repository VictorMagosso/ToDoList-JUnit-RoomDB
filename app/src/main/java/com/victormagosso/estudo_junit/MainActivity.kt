package com.victormagosso.estudo_junit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    var existingUsers = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    internal fun isValidUser(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ): Boolean {
        existingUsers.add("victor@magosso")
        return if (email in existingUsers) {
            false
        } else {
            name.isNotEmpty() &&
                    email.isNotEmpty() &&
                    email.contains("@") &&
                    password == confirmPassword &&
                    password.isNotEmpty() &&
                    confirmPassword.isNotEmpty()
        }
    }
}