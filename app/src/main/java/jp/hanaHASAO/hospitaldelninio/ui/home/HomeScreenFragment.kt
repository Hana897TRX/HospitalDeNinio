package jp.hanaHASAO.hospitaldelninio.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import jp.hanaHASAO.hospitaldelninio.databinding.HomeScreenFragmentBinding
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.UserAdapter
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.events.UIEvent
import jp.hanaHASAO.hospitaldelninio.ui.home.adapter.viewHolder.UserViewHolderUIEvents
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeScreenFragment: Fragment() {
    private var _binding: HomeScreenFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeScreenViewModel by viewModels()

    private var _adapter: UserAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = HomeScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        userListener()
    }

    private fun setupRecyclerView() = binding.run {
        if (_adapter == null) {
            _adapter = UserAdapter(users = listOf(), eventBus = ::userListenerUIEvents)
        }

        rvUsers.adapter = _adapter
        rvUsers.layoutManager = LinearLayoutManager(requireContext())
    }

    private fun userListener() {
        viewModel.getAllUsers()
        viewModel.userUIEvent.onEach { uiEvent ->
            _adapter?.updateData(uiEvent)
        }.launchIn(lifecycleScope)
    }

    private fun userListenerUIEvents(event: UIEvent) {
        when (event) {
            is UserViewHolderUIEvents.OnUserClick -> {
                findNavController().navigate(
                    HomeScreenFragmentDirections.actionHomeScreenFragmentToDetailsScreenFragment(
                        userUUID = event.uuid
                    )
                )
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}