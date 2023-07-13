package adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nbateams.R
import com.example.nbateams.Team

class TeamAdapter(
    private val teamsList: MutableList<Team>,
    private val onClick: (Team) -> Unit
) : RecyclerView.Adapter<TeamViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_team, parent, false)
        return TeamViewHolder(view)
    }

    override fun getItemCount(): Int {
        return teamsList.size
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        holder.bind(teamsList[position])
        holder.itemView.setOnClickListener {
            onClick(teamsList[position])
        }
    }
}
