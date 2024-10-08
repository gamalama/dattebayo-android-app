package id.biz.equatron.dattebayo.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import coil.load
import id.biz.equatron.dattebayo.R
import id.biz.equatron.dattebayo.core.ui.model.UiCharacter
import id.biz.equatron.dattebayo.databinding.FragmentDetailBinding
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val characterId = arguments?.getString("characterId")?.toInt()

        viewLifecycleOwner.lifecycleScope.launch {
            val character = characterId?.let { detailViewModel.getCharacter(it) }
            if (character != null) {
                showDetailCharacter(character)
            }
        }
    }

    private fun showDetailCharacter(character: UiCharacter) {
        binding?.apply {
            topAppBar.title = character.name
            ivImage.load(character.images[0])
            tvName.text = character.name
            tvJutsu.text = character.jutsu.joinToString(separator = ",\n")
        }

        var statusFavorite = character.isFavorite
        setStatusFavorite(statusFavorite)
        binding?.fabFavorite?.setOnClickListener {
            statusFavorite = !statusFavorite
            detailViewModel.setFavoriteCharacter(character, statusFavorite)
            setStatusFavorite(statusFavorite)
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_favorite_24
                )
            )
        } else {
            binding?.fabFavorite?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.ic_favorite_border_24
                )
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}