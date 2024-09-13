package jp.hanaHASAO.hospitaldelninio.ui.home.adapter.viewHolder

import androidx.recyclerview.widget.RecyclerView
import jp.hanaHASAO.hospitaldelninio.data.local.user.entity.UserEntity
import jp.hanaHASAO.hospitaldelninio.databinding.UserItemBinding
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.events.UIEvent

sealed class UserViewHolderUIEvents: UIEvent {
    data class OnUserClick(val uuid: String): UserViewHolderUIEvents()
}

class UserViewHolder(
    private val binding: UserItemBinding,
    private val eventBus: (UIEvent) -> Unit,
): RecyclerView.ViewHolder(binding.root) {
    fun bind(data: UserEntity) = binding.run {
        txtName.text = data.name
        txtLastName.text = data.lastName
        txtEmail.text = data.email
        txtAge.text = data.age.toString()

        cvUser.setOnClickListener {
            eventBus.invoke(UserViewHolderUIEvents.OnUserClick(data.uuid))
        }
    }
}
