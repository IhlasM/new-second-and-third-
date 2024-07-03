package com.example.homework2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.example.homework2.databinding.FragmentActiveBinding

class ActiveFragment : Fragment(R.layout.fragment_active) {
    private var binding: FragmentActiveBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentActiveBinding.bind(view)

        binding.run {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_active, container, false)
        val editText = view.findViewById<EditText>(R.id.editText)
        val sendButton = view.findViewById<Button>(R.id.sendButton)

        sendButton.setOnClickListener {
            val text = editText.text.toString()
            if (text.isEmpty()) {
                Snackbar.make(view, "The text field cannot be empty", Snackbar.LENGTH_SHORT).show()
            } else {
                val bundle = Bundle().apply {
                    putString("text", text)
                }
                findNavController().navigate(resId = R.id.action_activeFragment_to_messageFragment,
                    bundle)
            }
        }

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}