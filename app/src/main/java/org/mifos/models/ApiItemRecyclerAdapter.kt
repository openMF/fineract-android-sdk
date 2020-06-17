package org.mifos.models

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.layout_api_item.view.*
import org.mifos.R
import org.mifos.ui.HomeViewModel

/**
 * Created by grandolf49 on 17-06-2020
 *
 * RecyclerView Adapter class for displaying ApiItems
 */
class ApiItemRecyclerAdapter(
    var context: Context,
    private var apiItemsList: MutableList<ApiItemModel>,
    private val homeViewModel: HomeViewModel
) : RecyclerView.Adapter<ApiItemRecyclerAdapter.ApiItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ApiItemViewHolder {
        return ApiItemViewHolder(
            LayoutInflater
                .from(context)
                .inflate(R.layout.layout_api_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return apiItemsList.size
    }

    override fun onBindViewHolder(holder: ApiItemViewHolder, position: Int) {
        val apiItem: ApiItemModel = apiItemsList[position]
        holder.tv_api_name.text = apiItem.apiName
        holder.tv_api_description.text = apiItem.apiDescription
        holder.tv_api_response.text = apiItem.apiResponse
        holder.btn_test_api.setOnClickListener {
            holder.ll_api_response.visibility = VISIBLE
            homeViewModel.testApi(apiItem.apiEndPoint, holder.tv_api_response)
        }
    }

    class ApiItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_api_name: TextView = itemView.tv_api_name
        var tv_api_description: TextView = itemView.tv_api_description
        var tv_api_response: TextView = itemView.tv_api_response
        var btn_test_api: Button = itemView.btn_test_api
        var btn_copy_response: Button = itemView.btn_copy_response
        var ll_api_response: LinearLayout = itemView.ll_api_response
    }

}