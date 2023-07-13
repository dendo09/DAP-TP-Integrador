package adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nbateams.Team
import com.example.nbateams.R

class TeamViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtTitle: TextView = itemView.findViewById(R.id.teamTitle)
    private val teamsLayout: ConstraintLayout = itemView.findViewById(R.id.teams_layout)
    private val logoTeam = itemView.findViewById<ImageView>(R.id.imageView)

    fun bind(team: Team) {
        txtTitle.text = team.name
        Glide.with(logoTeam.context).load(team.logo).into(logoTeam)
    }

    init {
        teamsLayout.setOnClickListener {
            // Handle click event if needed
        }
    }
}
