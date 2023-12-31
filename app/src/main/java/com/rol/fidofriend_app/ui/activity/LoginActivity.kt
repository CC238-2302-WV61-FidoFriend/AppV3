package com.rol.fidofriend_app.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import com.rol.fidofriend_app.databinding.ActivityLoginBinding
import com.rol.fidofriend_app.model.Login
import com.rol.fidofriend_app.ui.viewmodel.LoginViewModel

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*viewModel.loginStatus = { success ->
            if (success) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, MainActivity::class.java))
                finish() // Finaliza la actividad actual
            } else {
                Toast.makeText(this, "No se pudo iniciar sesión...", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.userId = { id ->
            if (id != null) {
                Log.d("LoginActivity", "ID del usuario: $id")
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_ID", id)
                startActivity(intent)
                finish() // Finaliza la actividad actual
            } else {
                // Manejar error
            }
        }*/
        viewModel.loginStatus = { user ->
            if (user != null) {
                Log.d("LoginActivity", "ID del usuario: ${user.id}")
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("USER_ID", user.id)
                intent.putExtra("IS_VET", user.isVet)
                startActivity(intent)
                finish() // Finaliza la actividad actual
            } else {
                Toast.makeText(this, "No se pudo iniciar sesión...", Toast.LENGTH_SHORT).show()
            }
        }


        binding.btnCreateAccount.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
            finish()
        }

        /*binding.btnLogIn.setOnClickListener {
            val user = Login(
                email = binding.emailEditText.text.toString(),
                password = binding.passwordEditText.text.toString()
            )
            viewModel.loginUser(user)
        }*/
        binding.btnLogIn.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val user = Login(email, password)
                viewModel.loginUser(user)
            }
        }
    }
}