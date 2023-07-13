package adapter

import android.view.View
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.nbateams.Team
import com.example.nbateams.R

class TeamsHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val txtTitle: TextView = itemView.findViewById(R.id.teamTitle)
    private val teamsLayout: ConstraintLayout = itemView.findViewById(R.id.teams_layout)

    fun bind(team: Team) {
        txtTitle.text = team.name
    }

    init {
        teamsLayout.setOnClickListener {
            // Handle click event if needed
        }
    }
}
