package dapri.tablayout

import AdapterClass
import Data
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AnimeFragment : Fragment() {

    private lateinit var adapter: AdapterClass
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_anime, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInitialize()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = AdapterClass(dataInitialize())
        recyclerView.adapter = adapter
    }

    private fun dataInitialize(): ArrayList<Data> {
        val titles = resources.getStringArray(R.array.anime_titles)!!
        val descriptions = resources.getStringArray(R.array.anime_descriptions)!!
        val images = arrayOf(
            R.drawable.fullmetalalchemist_anime,
            R.drawable.attackontitan_anime,
            R.drawable.myheroacademia_anime,
            R.drawable.demonslayer_anime,
            R.drawable.deathnote_anime,
            R.drawable.cowboybebop_anime,
            R.drawable.neongenesisevangelion_anime,
            R.drawable.onepiece_anime,
            R.drawable.spiritedaway_anime,
            R.drawable.yourname_anime
        )

        val array = ArrayList<Data>()
        for (i in titles.indices) {
            val anime = Data(images[i], titles[i], descriptions[i])
            array.add(anime)
        }
        return array
    }
}
