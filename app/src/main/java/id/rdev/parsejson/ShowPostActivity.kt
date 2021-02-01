package id.rdev.parsejson

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import id.rdev.parsejson.data.PostAdapter
import id.rdev.parsejson.data.ResultPosts
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_show_post.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ShowPostActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_post)
        getData()
    }

    private fun getData() {
        NetworkConfig().getService()
            .getPosts()
            .enqueue(object : Callback<List<ResultPosts>> {
                override fun onResponse(
                    call: Call<List<ResultPosts>>,
                    response: Response<List<ResultPosts>>
                ) {
                    rvPost.apply {
                        adapter = PostAdapter(response.body())
                        layoutManager = LinearLayoutManager(this@ShowPostActivity)
                    }
                    Log.d("TAG", "onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<List<ResultPosts>>, t: Throwable) {
                    Log.d("TAG", "onFailure: " + t.localizedMessage)
                }

            })
    }
}