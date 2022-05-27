package me.augustus.recycler.plus

interface RecyclerPlusOnItemSelected<DATA_TYPE> {
    fun onItemSelected(position: Int, data: DATA_TYPE)
}