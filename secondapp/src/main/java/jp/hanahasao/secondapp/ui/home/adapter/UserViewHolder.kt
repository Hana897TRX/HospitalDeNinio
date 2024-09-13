package jp.hanahasao.secondapp.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import jp.hanahasao.secondapp.data.local.user.entity.UserEntity
import jp.hanahasao.secondapp.databinding.UserItemBinding
import jp.hanahasao.secondapp.ui.event.UIEvent

sealed class UserViewHolderUIEvents: UIEvent {
    data class OnUserClick(val uuid: String): UserViewHolderUIEvents()
}

class UserViewHolder(
    private val binding: UserItemBinding,
    private val eventBust: (UIEvent) -> Unit
): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserEntity) = binding.run {
        txtName.text = data.name
        txtLastName.text = data.lastName
        txtEmail.text = data.email
        txtAge.text = data.age.toString()

        cvUser.setOnClickListener {
            eventBust.invoke(UserViewHolderUIEvents.OnUserClick(data.uuid))
        }
    }
}