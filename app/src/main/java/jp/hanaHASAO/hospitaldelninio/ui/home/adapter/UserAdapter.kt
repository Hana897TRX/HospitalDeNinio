package jp.hanaHASAO.hospitaldelninio.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.databinding.UserItemBinding
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.events.UIEvent
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.viewHolder.UserViewHolder

class UserAdapter(
    private var users: List<UserEntity>,
    private val eventBus: (UIEvent) -> Unit
): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            binding = UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            eventBus = eventBus,
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun updateData(newData: List<UserEntity>) {
        users = newData
        notifyDataSetChanged()
    }
}
