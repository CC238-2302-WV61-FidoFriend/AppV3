package com.rol.fidofriend_app.data.service

import com.rol.fidofriend_app.model.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FidoFriendApi {

    @GET("/api/User/{id}")
    fun getUserById(@Path("id") id: Int): Call<User>

    @POST("/api/User/login")
    fun loginUser(@Body requestBody: Login): Call<User>

    @POST("/api/User")
    fun registerUser(@Body requestBody: RegisterLogin): Call<User>

    //@GET("/api/Pet/{id}")
    //fun getPets(@Path("id") id: Int): Call<List<Pet>>

    //@POST("/api/Pet")
    //fun postPet(@Body requestBody: Pet): Call<Pet>
    @POST("/api/Pet")
    fun postPet(@Body requestBody: Pet): Call<Boolean>

    @GET("/api/User/{userId}/pets")
    fun getUserPets(@Path("userId") userId: Int): Call<List<Pet>>

    // ---- PRODUCTS ----
    @GET("/api/Product")
    fun getProducts(): Call<List<Product>>

    @POST("/api/Product")
    fun postProduct(@Body product: Product): Call<Product>

    // ---- USER VETS ----
    @GET("/api/User/vets")
    fun getVets(): Call<List<User>>


    // ---- SERVICES ----
    @GET("/api/Service")
    fun getServices(): Call<List<Service>>

    @POST("/api/Service")
    fun createService(@Body service: Service): Call<Service>

}