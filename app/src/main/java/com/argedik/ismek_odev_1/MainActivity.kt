package com.argedik.ismek_odev_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.argedik.ismek_odev_1.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        auth = Firebase.auth
        setContentView(view)

        val currentUser=auth.currentUser
        if (currentUser != null){
            val intent = Intent(this@MainActivity,HomePage::class.java)
            startActivity(intent)
            finish()
        }
    }


    fun signInClick (view:View){
        val email = binding.userText.text.toString()
        val password = binding.passwordText.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()){
            auth.signInWithEmailAndPassword(email, password).addOnSuccessListener {
                val intent = Intent(this@MainActivity,HomePage::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Lütfen e-mail ve parola alanlarını doldurunuz.",Toast.LENGTH_LONG).show()
        }

    }
    fun signUpClick (view:View){
        val email = binding.userText.text.toString()
        val password = binding.passwordText.text.toString()
        if (email.isNotEmpty() && password.isNotEmpty()){
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener {
                val intent= Intent(this@MainActivity,HomePage::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this,it.localizedMessage,Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(this,"Lütfen e-mail ve parola alanlarını doldurunuz.",Toast.LENGTH_LONG).show()
        }
    }
}