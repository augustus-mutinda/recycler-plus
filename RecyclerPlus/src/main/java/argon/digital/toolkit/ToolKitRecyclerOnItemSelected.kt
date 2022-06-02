package argon.digital.toolkit

interface ToolKitRecyclerOnItemSelected<DATA_TYPE> {
    fun onItemSelected(position: Int, data: DATA_TYPE)
}