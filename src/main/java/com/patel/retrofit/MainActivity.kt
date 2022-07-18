package com.patel.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.patel.retrofit.Adapter.MyAdapter
import com.patel.retrofit.Module.Post
import com.patel.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setup for using recyclerview
        setupRecyclerview()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this,viewModelFactory).get(MainViewModel::class.java)
        

        /*
        For simple get of 1 id request

        viewModel.getPost()
        viewModel.myResponse.observe(this, Observer {response ->
            if(response.isSuccessful) {
                Log.d("Response", response.body()?.userId.toString())
                Log.d("Response", response.body()?.id.toString())
                textView.text = response.body()?.title
                Log.d("Response", response.body()?.body!!)
            }else {
                Log.d("Response", response.errorBody().toString())
                textView.text = response.code().toString()
            }
        })
        */

        /*
        for seraching particular id

        button.setOnclickListener{
            val myNumber = number_editText.text.toString()
            viewModel.getPost2(Integer.parseInt(myNumber))
            viewModel.myResponse2.observe(this, Observer { response ->
                if (response.isSuccessful){
                    textView.text = response.body().toString()
                }else{
                    textView.text = response.code().toString()
                }
            })

         */

        /*
        for multiple id using query

        button.setOnclickListener{
            val myNumber = number_editText.text.toString()
            viewModel.getCustomPost(Integer.parseInt(myNumber),"id","asc")
            viewModel.myCustomResponse.observe(this, Observer { response ->
                if (response.isSuccessful){
                    textView.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response", response.body()?.userId.toString())
                        Log.d("Response", response.body()?.id.toString())
                        Log.d("Response", response.body()?.title.toString())
                        Log.d("Response", response.body()?.body!!)
                        Log.d("Response", "------------------------------")
                    }
                }else{
                    textView.text = response.code().toString()
                }
            })

         */

        /*
        for multiple id
        get request using querymap

        val option: HashMap<String,String> = HashMap()
        option["sort"] = "id"
        option["order"] = "asc"

        button.setOnclickListener{
            val myNumber = number_editText.text.toString()
            viewModel.getCustomPost2(Integer.parseInt(myNumber),option)
            viewModel.myCustomResponse2.observe(this, Observer { response ->
                if (response.isSuccessful){
                    textView.text = response.body().toString()
                    response.body()?.forEach {
                        Log.d("Response", response.body()?.userId.toString())
                        Log.d("Response", response.body()?.id.toString())
                        Log.d("Response", response.body()?.title.toString())
                        Log.d("Response", response.body()?.body!!)
                    }
                }else{
                    textView.text = response.code().toString()
                }
            })
        }
        */

        /*
        using recycler view

        viewModel.getCustomPost(5,"id", "desc")
        viewModel.myCustomResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                response.body()?.let { myAdapter.setData(it) }
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })

         */

        /*
        push post to the api


        viewModel.pushPost2(2,2, "Stevdza  ", "Android+")
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.message())
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
         */

        /*
        custom request header


        viewModel.getPost("11112222")
        viewModel.myResponse.observe(this, Observer { response ->
            if(response.isSuccessful){
                Log.d("Main", response.body().toString())
                Log.d("Main", response.code().toString())
                Log.d("Main", response.headers().toString())
            }else {
                Toast.makeText(this, response.code(), Toast.LENGTH_SHORT).show()
            }
        })
         */

    }


    private fun setupRecyclerview(){
        recyclerView.adapter = myAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}