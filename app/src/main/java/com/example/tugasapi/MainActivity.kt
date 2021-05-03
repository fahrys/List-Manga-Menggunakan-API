package com.example.tugasapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupListOfDataIntoRecyclerView()
    }

    fun setupListOfDataIntoRecyclerView() {
        Rvitem.layoutManager = LinearLayoutManager(this)

        //Ambil data CEO dari API
        var apiInterface: ApiInterface = ApiClient().getApiClient()!!.create(ApiInterface::class.java)
        apiInterface.getCEOs().enqueue(object : Callback<CEOModel> {

            override fun onFailure(call: Call<CEOModel>, t: Throwable) {
                Toast.makeText(baseContext, "Data Downloading is Failed", Toast.LENGTH_LONG).show()
                Log.d("API Failed", t.message.toString())
            }

            override fun onResponse(call: Call<CEOModel>, response: Response<CEOModel>) {
                var ceoData = response?.body()!!
                if (ceoData.data.size > 0) {
                    Rvitem.visibility = View.VISIBLE
//                    tvnorecord.visibility = View.GONE
                    Rvitem.adapter = MyAdapter(this@MainActivity, ceoData.data)
                } else {
                    Rvitem.visibility = View.GONE
//                    tvnorecord.visibility = View.VISIBLE
                }
                Toast.makeText(baseContext, "Data Downloading is Success", Toast.LENGTH_LONG).show()
                Log.d("API Response", response.toString())
            }
        })
    }
}