package uz.turgunboyevjurabek.retrofitexamplewithmvp.Presenter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract.Contract
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Models.ApiClient
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

class Presenter(private val mainView:Contract.View,private val model: ApiClient)
    :Contract.Presenter,Contract.Model{
    val apiClinets=ApiClient
    override fun onDestroyed() {
    }

    override fun addItemInRv() {

        mainView.showProgressLoading()

        apiClinets.getApiServis().getAllClient().enqueue(object :Callback<ArrayList<GetClinets>>{
            override fun onResponse(
                call: Call<ArrayList<GetClinets>>,
                response: Response<ArrayList<GetClinets>>,
            ) {
                if (response.isSuccessful && response.body()!=null){
                    mainView.hideProgress()
                    mainView.itemsList(response.body()!!)
                }else{
                    mainView.showError(response.message())
                }
            }

            override fun onFailure(call: Call<ArrayList<GetClinets>>, t: Throwable) {
                mainView.failure(t.message!!)
            }
        })
    }


}