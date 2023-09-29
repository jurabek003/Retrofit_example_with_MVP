package uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract

import retrofit2.Call
import retrofit2.http.GET
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

interface Contract {
    // for View
    interface View{

        fun showProgressLoading()
        fun hideProgress()
        fun showError(massage:String)

        fun failure(massage: String)
        fun itemsList(data:ArrayList<GetClinets>)


    }
    // for Madel
    interface Model{

        interface ApiServis {
            @GET("clientlar/")
            fun getAllClient(): Call<ArrayList<GetClinets>>
        }


    }
    // for Presenter
    interface Presenter{
       fun  onDestroyed()
        fun addItemInRv()
    }


}