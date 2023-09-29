package uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract

import retrofit2.Call
import retrofit2.http.GET
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

interface Contract {
    interface View{

    }
    interface Model{

        interface ApiServis {

            @GET("wallpapers/")
            fun getAllClient(): Call<ArrayList<GetClinets>>
        }


    }
    interface Presenter{
        
    }


}