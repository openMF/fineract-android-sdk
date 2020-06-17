package org.mifos.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_home.*
import org.mifos.R
import org.mifos.models.ApiItemRecyclerAdapter
import org.mifos.models.ApiItemsContent.Companion.getApiItemsContent
import org.mifos.utils.toast

class HomeActivity : AppCompatActivity(), HomeListener {

    private lateinit var apiItemAdapter: ApiItemRecyclerAdapter

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        viewModel.homeListener = this
        viewModel.context = this

        initRecyclerView()
    }

    private fun initRecyclerView() {
        rv_home.layoutManager = LinearLayoutManager(this)
        apiItemAdapter = ApiItemRecyclerAdapter(
            this,
            getApiItemsContent(),
            viewModel
        )
        rv_home.adapter = apiItemAdapter
    }

    override fun onSuccess(response: String) {
        toast(response)
    }

    override fun onFailure(message: String) {
        toast(message)
    }

}