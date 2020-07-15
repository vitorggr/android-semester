package br.com.cotemig.instagramgalery.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import br.com.cotemig.instagramgalery.R
import br.com.cotemig.instagramgalery.models.Post
import br.com.cotemig.instagramgalery.services.RetrofitInitializer
import br.com.cotemig.instagramgalery.ui.activities.MainActivity
import br.com.cotemig.instagramgalery.ui.adapters.AdapterFeed
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Response

/**
 * A simple [Fragment] subclass.
 */
class HomeFragment : Fragment() {

    var value: Int = 0
    var name: String = ""

    companion object {
        fun newInstance(value: Int, name: String): HomeFragment {
            var f = HomeFragment()
            f.value = value
            f.name = name
            return f
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        getFeed()

        return view
    }

    fun getFeed() {

        var activity = context as MainActivity

        var s = RetrofitInitializer().serviceFeed()

        var call = s.getFeed()

        call.enqueue(object : retrofit2.Callback<List<Post>> {

            override fun onResponse(call: Call<List<Post>>?, response: Response<List<Post>>?) {
                response?.let {

                    if (it.code() == 200) {

                        listView.adapter = AdapterFeed(activity, it.body())

                    }

                }
            }

            override fun onFailure(call: Call<List<Post>>?, t: Throwable?) {
                Toast.makeText(activity, "Ops", Toast.LENGTH_LONG).show()
            }

        })

    }

}
