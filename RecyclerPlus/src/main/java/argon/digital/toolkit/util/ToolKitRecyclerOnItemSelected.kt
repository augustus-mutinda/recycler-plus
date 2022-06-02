package argon.digital.toolkit.util

interface ToolKitRecyclerOnItemSelected<DATA_TYPE> {
    fun onItemSelected(position: Int, data: DATA_TYPE)
}