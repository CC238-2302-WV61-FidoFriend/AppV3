package com.rol.fidofriend_app.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rol.fidofriend_app.databinding.ActivityPaymentBinding

class PaymentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}