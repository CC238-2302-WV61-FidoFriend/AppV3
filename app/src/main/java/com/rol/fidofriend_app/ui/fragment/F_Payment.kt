package com.rol.fidofriend_app.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import com.rol.fidofriend_app.databinding.FragmentFPaymentBinding
import com.rol.fidofriend_app.ui.activity.PaymentActivity
import com.rol.fidofriend_app.ui.adapter.CartItemAdapter
import com.rol.fidofriend_app.ui.adapter.ProductAdapter
import com.rol.fidofriend_app.ui.adapter.ServiceAdapter
import com.rol.fidofriend_app.ui.viewmodel.ProductViewModel
import com.rol.fidofriend_app.ui.viewmodel.ServiceViewModel


/*class F_Payment : Fragment() {

    private var _binding: FragmentFPaymentBinding? = null
    private val binding get() = _binding!!
    /*private val viewModel: ProductViewModel by activityViewModels()

    private val adapter by lazy {
        ProductAdapter({}, false, false)
    }*/
    private val viewModel: ServiceViewModel by activityViewModels()

    private val adapter by lazy {
        ServiceAdapter({}, false, false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewShopping.adapter = adapter

        /*viewModel.selectedProducts.observe(viewLifecycleOwner) { products ->
            if (products != null) {
                adapter.submitList(products)
                val total = products.sumOf { it.price }
                binding.textTotal.text = "Total: S/. $total"
            } else {
                Toast.makeText(
                    context,
                    "No se pudieron cargar los productos seleccionados...",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }*/
        viewModel.selectedServices.observe(viewLifecycleOwner) { services ->
            if (services != null) {
                adapter.submitList(services)
                val total = services.sumOf { it.price }
                binding.textTotal.text = "Total: S/. $total"
            } else {
                Toast.makeText(
                    context,
                    "No se pudieron cargar los productos seleccionados...",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        binding.btnPayment.setOnClickListener {
            startActivity(Intent(requireContext(), PaymentActivity::class.java))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/
/*class F_Payment : Fragment() {

    private var _binding: FragmentFPaymentBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by activityViewModels()
    private val serviceViewModel: ServiceViewModel by activityViewModels()
    private val adapter by lazy {
        CartItemAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewShopping.adapter = adapter

        productViewModel.selectedProducts.observe(viewLifecycleOwner) { products ->
            updateCart()
        }

        serviceViewModel.selectedServices.observe(viewLifecycleOwner) { services ->
            updateCart()
        }

        binding.btnPayment.setOnClickListener {
            startActivity(Intent(requireContext(), PaymentActivity::class.java))
        }


    }

    private fun updateCart() {
        val products = productViewModel.selectedProducts.value ?: emptyList()
        val services = serviceViewModel.selectedServices.value ?: emptyList()
        Log.d("F_Payment", "Productos en el carrito: ${products.size}")
        Log.d("F_Payment", "Servicios en el carrito: ${services.size}")
        val items = mutableListOf<Any>()
        items.addAll(products)
        items.addAll(services)
        adapter.submitList(items)
        val total = (products.sumOf { it.price } ?: 0.0) +
                (services.sumOf { it.price } ?: 0.0)
        binding.textTotal.text = "Total: S/. $total"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}*/
class F_Payment : Fragment() {

    private var _binding: FragmentFPaymentBinding? = null
    private val binding get() = _binding!!
    private val productViewModel: ProductViewModel by activityViewModels()
    private val serviceViewModel: ServiceViewModel by activityViewModels()
    private val adapter by lazy {
        CartItemAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewShopping.adapter = adapter

        productViewModel.selectedProducts.observe(viewLifecycleOwner) { products ->
            updateCart()
        }

        serviceViewModel.selectedServices.observe(viewLifecycleOwner) { services ->
            updateCart()
        }

        binding.btnPayment.setOnClickListener {
            startActivity(Intent(requireContext(), PaymentActivity::class.java))
        }
    }

    private fun updateCart() {
        val products = productViewModel.selectedProducts.value ?: emptyList()
        val services = serviceViewModel.selectedServices.value ?: emptyList()
        val items = mutableListOf<Any>()
        items.addAll(products)
        items.addAll(services)
        adapter.submitList(items)
        val total = (products.sumOf { it.price } ?: 0.0) +
                (services.sumOf { it.price } ?: 0.0)
        binding.textTotal.text = "Total: S/. $total"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}




