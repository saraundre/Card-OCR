package com.example.a.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.a.databinding.LangViewholderBinding
import com.example.a.ui.languageClickListener


class LanguagesAdapter(val languageClickListener: languageClickListener)
    : RecyclerView.Adapter<LanguagesAdapter.LanguageViewHolder>() {

//**********************************************************************************************************//
    inner class LanguageViewHolder(private val itemViewBinding: LangViewholderBinding) :
        RecyclerView.ViewHolder(
            itemViewBinding.root
        ) {

        fun bindView(languageItem: String) {
            itemViewBinding.apply {
                tvlang.text = languageItem
            }
            itemViewBinding.root.setOnClickListener {
                languageClickListener(languageItem)
            }
        }
    }
//**********************************************************************************************************//
    private val differCallBack = object : DiffUtil.ItemCallback<String>() {

        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem.length == newItem.length
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

    }
//**********************************************************************************************************//
    val differ = AsyncListDiffer(this, differCallBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(

            LangViewholderBinding.inflate(
                LayoutInflater.from(parent.context)
            )
        )
    }
//**********************************************************************************************************//
    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {

        val languageItem = differ.currentList[position]
        holder.bindView(languageItem)
    }
//**********************************************************************************************************//

    override fun getItemCount(): Int {
        return differ.currentList.size
    }
//**********************************************************************************************************//

}