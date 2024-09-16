package jp.hanahasao.secondapp.ui.screens.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import jp.hanahasao.secondapp.data.local.user.entity.UserEntity
import jp.hanahasao.secondapp.databinding.UserItemBinding
import jp.hanahasao.secondapp.ui.event.UIEvent

class UserAdapter(
    private var users: List<UserEntity>,
    private val eventBust: (UIEvent) -> Unit,
): RecyclerView.Adapter<UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(
            binding = UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),
            eventBust = eventBust,
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position])
    }

    fun submitList(users: List<UserEntity>) {
        this.users = users
        notifyDataSetChanged()
    }
}