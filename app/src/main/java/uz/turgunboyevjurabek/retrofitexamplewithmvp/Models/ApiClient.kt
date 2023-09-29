package uz.turgunboyevjurabek.retrofitexamplewithmvp.Models

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract.Contract

object ApiClient {
    val BASE_URL="https://wallpaperapi.pythonanywhere.com/"

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
    }
    fun getServis(): Contract.Model.ApiServis {
        return getRetrofit().create(Contract.Model.ApiServis::class.java)
    }

}