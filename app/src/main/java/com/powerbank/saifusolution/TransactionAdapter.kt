package com.powerbank.saifusolution

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.powerbank.saifusolution.utils.toPriceString
import kotlinx.android.synthetic.main.item_transaction.view.*

class TransactionAdapter(private val itemList: List<Transaction>) : RecyclerView.Adapter<TransactionVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionVH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionVH(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: TransactionVH, position: Int) {
        holder.bind(itemList[position])
    }
}

class TransactionVH(private val view: View): RecyclerView.ViewHolder(view) {
    fun bind(transaction: Transaction) {
        view.run {
            tvMerchantName.text = transaction.merchantName
            tvAmt.text = transaction.amt.toPriceString()
            tvMerchantCategory.text = transaction.merchantCategory
            tvDate.text = transaction.dateString

            when(transaction.transactionType) {
                TransactionType.TRANSPORT -> ivIcon.setImageResource(R.drawable.ic_commute_black_24dp)
                TransactionType.CLOTHES -> ivIcon.setImageResource(R.drawable.ic_store_mall_directory_black_24dp)
                TransactionType.GROCERY -> ivIcon.setImageResource(R.drawable.ic_local_grocery_store_black_24dp)
                TransactionType.FOOD_AND_BEVERAGE -> ivIcon.setImageResource(R.drawable.ic_fastfood_black_24dp)
                TransactionType.BILLS -> ivIcon.setImageResource(R.drawable.ic_receipt_black_24dp)
                TransactionType.TRAVEL -> ivIcon.setImageResource(R.drawable.ic_card_travel_black_24dp)
            }
        }
    }
}
