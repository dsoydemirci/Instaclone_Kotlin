package com.soydemircidogukan.instakotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.soydemircidogukan.instakotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        auth = Firebase.auth

        val currentUser = auth.currentUser

        if (currentUser != null) {
            val intent = Intent(this, FeedActivity::class.java)
            startActivity(intent)
            finish()
        }





    }
    fun signin(view: View){
        println("dd")
        val userEmail = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(userEmail.equals("") || password.equals("")){
            Toast.makeText(this@MainActivity,"E MAİL YA DA PASSWORD BOS",Toast.LENGTH_LONG).show()

        }else{
            auth.signInWithEmailAndPassword(userEmail,password).addOnSuccessListener {
                println("cc")
                val intentt = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intentt)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()


            }



            }









    }
    fun gec(view: View) {
        val intent = Intent(this@MainActivity, FeedActivity::class.java)
        startActivity(intent)
        finish()
    }
    fun signup(view:View){
        val userEmail = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(userEmail.equals("") || password.equals("")){
            Toast.makeText(this@MainActivity,"E MAIL YA DA PASSWORD BOS",Toast.LENGTH_LONG).show()

        }else{
            auth.createUserWithEmailAndPassword(userEmail,password).addOnSuccessListener {
                val intentt = Intent(this@MainActivity, FeedActivity::class.java)
                startActivity(intentt)
                finish()


            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()


            }



        }



    }

}