package uz.turgunboyevjurabek.retrofitexamplewithmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract.Contract
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Models.ApiClient
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Presenter.Presenter
import uz.turgunboyevjurabek.retrofitexamplewithmvp.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

class MainActivity : AppCompatActivity(),Contract.View {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var apiServis: Contract.Model.ApiServis
    private lateinit var presenter: Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter= Presenter(this,ApiClient)

        presenter.addItemInRv()

    }

    override fun showProgressLoading() {
        
    }

    override fun hideProgress() {
        
    }

    override fun showError(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
    }

    override fun failure(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
    }

    override fun itemsList(data: ArrayList<GetClinets>) {
        Toast.makeText(this, "A'loo", Toast.LENGTH_SHORT).show()
    }
}