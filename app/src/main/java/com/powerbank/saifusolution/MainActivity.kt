package com.powerbank.saifusolution

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val txList = arrayListOf<Transaction>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSampleData()
        initView()
    }

    private fun initSampleData() {
        txList.add(Transaction(0, "Uber", "Transport", 16.0, "13th May", TransactionType.TRANSPORT))
        txList.add(Transaction(1, "NTUC", "Grocery", 104.0, "12th May", TransactionType.GROCERY))
        txList.add(Transaction(2, "Grab", "Transport", 11.0, "11th May", TransactionType.TRANSPORT))
        txList.add(Transaction(3, "Zalora", "Clothes", 82.0, "11th May", TransactionType.CLOTHES))
        txList.add(Transaction(4, "Adidas", "Sportswear", 209.0, "6th May", TransactionType.CLOTHES))
        txList.add(Transaction(5, "Monster Curry", "Food", 43.0, "4th May", TransactionType.FOOD_AND_BEVERAGE))
        txList.add(Transaction(6, "Starbucks", "Coffee", 12.0, "23th Apr", TransactionType.FOOD_AND_BEVERAGE))
        txList.add(Transaction(7, "SP Group", "Bill", 189.0, "13th Apr", TransactionType.BILLS))
        txList.add(Transaction(8, "Singtel", "Telco", 63.0, "13th Apr", TransactionType.BILLS))
        txList.add(Transaction(9, "Singapore air", "Travel", 1.0, "4th Apr", TransactionType.TRAVEL))
    }

    private fun initView() {
        rv.run {
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = TransactionAdapter(txList)
        }
        tvTopup.setOnClickListener {
            //startActivity(Intent(this, WebviewActivity::class.java))
            MaterialAlertDialogBuilder(this)
                .setPositiveButton("CLAIM") { _, _ ->
                    val browserIntent =
                        Intent(Intent.ACTION_VIEW, Uri.parse("https://light.microsite.perxtech.io/game/3?token=${BuildConfig.PERX_TOKEN}"))
                    startActivity(browserIntent)
                }
                .setTitle("Reward")
                .setMessage("You are eligible for a scratch card!")
                .setNegativeButton("SKIP") { _, _ ->
                }.show()
        }

        rlServices.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlStatement.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlProfile.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlTools.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlBankManagement.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlInvestment.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
        rlMarketplace.setOnClickListener {
            Toast.makeText(this, "Coming soon", Toast.LENGTH_SHORT).show()
        }
    }
}
