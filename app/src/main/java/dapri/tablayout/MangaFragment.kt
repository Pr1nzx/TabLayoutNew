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

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MangaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MangaFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_manga, container, false)
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
        val titles = resources.getStringArray(R.array.manga_titles)!!
        val descriptions = resources.getStringArray(R.array.manga_descriptions)!!
        val images = arrayOf(
            R.drawable.onepiece_manga,
            R.drawable.attackontitan_manga,
            R.drawable.fullmetalalchemist_manga,
            R.drawable.deathnote_manga,
            R.drawable.demonslayer_manga,
            R.drawable.myheroacademia_manga,
            R.drawable.berserk_manga,
            R.drawable.vinlansaga_manga,
            R.drawable.vagabond_manga,
            R.drawable.monster_manga
        )


        val array = ArrayList<Data>()
        for (i in titles.indices) {
            val manga = Data(images[i], titles[i], descriptions[i])
            array.add(manga)
        }
        return array
    }
}
