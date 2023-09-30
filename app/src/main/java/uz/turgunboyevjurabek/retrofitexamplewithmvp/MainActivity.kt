package uz.turgunboyevjurabek.retrofitexamplewithmvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Contract.Contract
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Models.ApiClient
import uz.turgunboyevjurabek.retrofitexamplewithmvp.Presenter.Presenter
import uz.turgunboyevjurabek.retrofitexamplewithmvp.adapter.RvAdapter
import uz.turgunboyevjurabek.retrofitexamplewithmvp.databinding.ActivityMainBinding
import uz.turgunboyevjurabek.retrofitexamplewithmvp.madels.GetClinets

class MainActivity : AppCompatActivity(),Contract.View {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var apiServis: Contract.Model.ApiServis
    private lateinit var presenter: Presenter
    private lateinit var rvAdapter: RvAdapter
    private lateinit var list:ArrayList<GetClinets>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        presenter= Presenter(this,ApiClient)

        presenter.addItemInRv()
    }

    override fun showProgressLoading() {
        binding.progressCircular.visibility=View.VISIBLE
        binding.rv.visibility=View.GONE
    }

    override fun hideProgress() {
        binding.progressCircular.visibility=View.GONE
        binding.rv.visibility=View.VISIBLE
    }

    override fun showError(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
        binding.progressCircular.visibility=View.GONE
    }

    override fun failure(massage: String) {
        Toast.makeText(this, massage, Toast.LENGTH_SHORT).show()
        binding.progressCircular.visibility=View.GONE
    }

    override fun itemsList(data: ArrayList<GetClinets>) {
        list= ArrayList()
        list.addAll(data)

        rvAdapter=RvAdapter(list)
        binding.rv.adapter=rvAdapter
    }
}