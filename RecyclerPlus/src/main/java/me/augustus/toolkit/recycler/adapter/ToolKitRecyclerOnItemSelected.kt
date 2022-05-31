package me.augustus.toolkit.recycler.adapter

interface ToolKitRecyclerOnItemSelected<DATA_TYPE> {
    fun onItemSelected(position: Int, data: DATA_TYPE)
}