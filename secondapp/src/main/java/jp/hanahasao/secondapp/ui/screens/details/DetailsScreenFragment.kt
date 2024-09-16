package jp.hanahasao.secondapp.ui.screens.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import jp.hanahasao.secondapp.R
import jp.hanahasao.secondapp.databinding.FragmentDetailsScreenBinding

class DetailsScreenFragment : Fragment() {
    private var _binding: FragmentDetailsScreenBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailsScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpView()
    }

    private fun setUpView() = binding.run {
        val userUUID = navArgs<DetailsScreenFragmentArgs>().value.userUUID
        txtUserUUID.text = userUUID

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}