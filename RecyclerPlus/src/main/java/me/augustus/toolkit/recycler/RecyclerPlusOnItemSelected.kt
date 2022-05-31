package me.augustus.toolkit.recycler

interface RecyclerPlusOnItemSelected<DATA_TYPE> {
    fun onItemSelected(position: Int, data: DATA_TYPE)
}