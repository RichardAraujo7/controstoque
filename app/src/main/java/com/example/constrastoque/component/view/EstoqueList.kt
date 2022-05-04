package com.example.constrastoque.component.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat.getAccessibilityDelegate
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.constrastoque.R
import com.example.constrastoque.component.adapter.EstoqueRecyclerViewAdapter
import com.example.constrastoque.component.model.EstoqueModel

class EstoqueList @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    private lateinit var list: MutableList<EstoqueModel>
    private var rvStockLimit: RecyclerView
    private lateinit var adapter: EstoqueRecyclerViewAdapter

    init {
        View.inflate(context, R.layout.item_estoque_recycler_view_list, this)
        rvStockLimit = findViewById(R.id.rvEelList)

        getAccessibilityDelegate(rvStockLimit)
    }

    private fun initValues() {
        val layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL, false)

        adapter = EstoqueRecyclerViewAdapter(list)
        rvStockLimit.adapter = adapter

        rvStockLimit.isNestedScrollingEnabled = false
        rvStockLimit.setHasFixedSize(true)
        rvStockLimit.layoutManager = layoutManager
    }

    fun setStockList(list: MutableList<EstoqueModel>) {
        this.list = list
        initValues()
    }

}