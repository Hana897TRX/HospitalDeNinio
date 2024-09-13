package jp.hanaHASAO.hospitaldelninio.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import jp.hanaHASAO.hospitaldelninio.databinding.DetailsScreenFragmentBinding

class DetailsScreenFragment: Fragment() {
    private var _binding: DetailsScreenFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailsScreenFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = binding.run {
        setInfo()
        setUpListeners()
    }

    private fun setInfo() = binding.run {
        val args by navArgs<DetailsScreenFragmentArgs>()
        txtDetails.text = args.userUUID
    }

    private fun setUpListeners() = binding.run {
        btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}