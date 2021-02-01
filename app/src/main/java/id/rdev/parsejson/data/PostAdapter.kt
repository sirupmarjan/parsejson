package id.rdev.parsejson.data

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import id.rdev.parsejson.DetailActivity
import id.rdev.parsejson.R
import kotlinx.android.synthetic.main.list_post.view.*

class PostAdapter(val data: List<ResultPosts>?):RecyclerView.Adapter<PostAdapter.Holder>() {


    class Holder(v : View) :RecyclerView.ViewHolder(v) {
        fun bind(get: ResultPosts?) {
            itemView.tvPostUser.text = get?.userId.toString()
            itemView.tvPostTitle.text = get?.title
            itemView.tvPostBody.text = get?.body
            itemView.setOnClickListener {
                val i : Intent = Intent(itemView.context, DetailActivity::class.java)
                i.putExtra("ID", get?.id.toString())
                itemView.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_post, parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(data?.get(position))
    }

    override fun getItemCount(): Int = data?.size ?: 0

}