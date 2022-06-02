package argon.digital.toolkit

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

abstract class ToolKitRecyclerAdapter<T : Any, VH : ViewBinding> :
    RecyclerView.Adapter<ToolKitRecyclerAdapter<T, VH>.MCViewHolder>() {
    private var onBottomReachedListenerToolKit: ToolKitRecyclerOnBottomReached? = null
    var itemListenerToolKit: ToolKitRecyclerOnItemSelected<T>? = null
    var activity: Activity? = null
    var navController: NavController? = null

    var items = AsyncListDiffer(
        this,
        object :
            DiffUtil.ItemCallback<T>() {
            override fun areItemsTheSame(
                oldItem: T,
                newItem: T
            ): Boolean {
                return isSame(oldItem, newItem)
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(
                oldItem: T,
                newItem: T
            ): Boolean {
                return isContentsSame(oldItem, newItem)
            }
        })

    fun update(items: List<T>) {
        this.items.submitList(items)
    }

    open fun setOnBottomReachedListener(onBottomReachedListenerToolKit: ToolKitRecyclerOnBottomReached?) {
        this.onBottomReachedListenerToolKit = onBottomReachedListenerToolKit
    }

    abstract fun onBindViewHolder(binding: VH, datum: T, position: Int)

    abstract fun binder(parent: ViewGroup): VH

    fun isSame(x: T, y: T): Boolean {
        return x == y
    }

    fun isContentsSame(x: T, y: T): Boolean {
        return x == y
    }

    inner class MCViewHolder(val binding: VH) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MCViewHolder {
        return MCViewHolder(binder(parent))
    }

    override fun onBindViewHolder(holder: MCViewHolder, position: Int) {
        if (position == itemCount - 1)
            onBottomReachedListenerToolKit?.onBottomReached(position)

        onBindViewHolder(holder.binding, items.currentList[position], position)
    }

    override fun getItemCount(): Int {
        return items.currentList.size
    }

    fun startActivity(intent: Intent) {
        activity.let {
            if (it != null)
                it.startActivity(intent)
            else
                throw IllegalArgumentException("Activity has not been set in RecyclerPlusAdapter")
        }
    }

    fun navigate(id: Int) {
        getNav().navigate(id)
    }

    fun navigate(id: NavDirections) {
        getNav().navigate(id)
    }

    private fun getNav(): NavController {
        var controller: NavController? = null
        navController.let {
            if (it != null)
                controller = it
            else
                throw IllegalArgumentException("NavController has not been set in RecyclerPlusAdapter")
        }
        return controller!!
    }
}