package jp.hanahasao.secondapp.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import jp.hanahasao.secondapp.R
import jp.hanahasao.secondapp.data.local.user.entity.UserEntity
import jp.hanahasao.secondapp.databinding.HomeScreenFragmentBinding
import jp.hanahasao.secondapp.domain.states.DomainStates
import jp.hanahasao.secondapp.ui.event.UIEvent
import jp.hanahasao.secondapp.ui.screens.home.adapter.UserAdapter
import jp.hanahasao.secondapp.ui.screens.home.adapter.UserViewHolderUIEvents
import jp.hanahasao.secondapp.ui.utils.gone
import jp.hanahasao.secondapp.ui.utils.show
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class HomeScreenFragment : Fragment() {
    private var _binding: HomeScreenFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomeScreenViewModel by viewModels()
    private var usersAdapter: UserAdapter? = null

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

        setUpRecyclerView()
        usersListener()
    }

    private fun setUpRecyclerView() = binding.run {
        if (usersAdapter == null) {
            usersAdapter = UserAdapter(users = listOf(), eventBust = ::uiAdapterEventsListener)
        }

        rvUsers.adapter = usersAdapter
        rvUsers.layoutManager = LinearLayoutManager(binding.root.context)
    }

    private fun uiAdapterEventsListener(event: UIEvent) {
        when (event) {
            is UserViewHolderUIEvents.OnUserClick -> {
                val action = HomeScreenFragmentDirections.actionHomeScreenFragmentToDetailsScreenFragment(
                    userUUID = event.uuid
                )
                findNavController().navigate(action)

            }
        }
    }

    private fun usersListener() = binding.run {
        viewModel.getAllUsers()

        viewModel.usersUIData.onEach { uiState ->
            when (uiState) {
                is DomainStates.Loading -> {
                    pbUsers.show()
                }

                is DomainStates.Success -> {
                    usersAdapter?.submitList(uiState.data)
                    rvUsers.show()
                    pbUsers.gone()
                }

                is DomainStates.Error -> {
                    pbUsers.gone()
                    Toast.makeText(
                        requireContext(),
                        uiState.message,
                        Toast.LENGTH_SHORT,
                    ).show()
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}