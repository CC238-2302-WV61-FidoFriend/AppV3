package com.rol.fidofriend_app.ui.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.rol.fidofriend_app.R
import com.rol.fidofriend_app.databinding.FragmentFProfileBinding
import com.rol.fidofriend_app.ui.viewmodel.LoginViewModel
import com.rol.fidofriend_app.ui.viewmodel.UserProfileViewModel

class F_Profile : Fragment() {

    private var _binding: FragmentFProfileBinding? = null
    private val binding get() = _binding!!
    private val viewModel: UserProfileViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.userProfile = { user ->
            if (user != null) {
                binding.nameText.text = "Nombre: ${user.firstName} ${user.lastName}"
                binding.emailText.text = "Email: ${user.email}"
                binding.vetText.text = if (user.isVet) "Tipo Usuario: Veterinario" else "Tipo Usuario: Cliente"

                // Carga la imagen del usuario
                Glide.with(this)
                    .load(user.imgUrl)
                    .placeholder(R.mipmap.ic_launcher) //loading
                    .error(R.mipmap.ic_launcher) //error
                    .into(binding.profileImage)

            } else {
                Toast.makeText(context, "No se pudo obtener los datos del usuario...", Toast.LENGTH_SHORT).show()
            }
        }

        /*val userId = arguments?.getInt("USER_ID", -1)
        Log.d("MainActivity", "User ID: $userId")
        if (userId != null && userId != -1) {
            viewModel.getUser(userId)
        } else {
            //Toast.makeText(context, "Hubo algun error...", Toast.LENGTH_SHORT).show()
        }*/
    }

    override fun onResume() {
        super.onResume()

        // Aquí es donde obtienes el ID del usuario del Bundle y lo pasas a tu UserProfileViewModel
        val userId = arguments?.getInt("USER_ID", -1)
        Log.d("MainActivity", "User ID: $userId")
        if (userId != null && userId != -1) {
            viewModel.getUser(userId)
        } else {
            // Manejar error
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}



