package com.namlu.recyclerviewexample.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.namlu.recyclerviewexample.R
import com.namlu.recyclerviewexample.models.BlogPost
import kotlinx.android.synthetic.main.blog_list_item.view.*

class BlogRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var blogItems: List<BlogPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return BlogViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.blog_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is BlogViewHolder -> {
                holder.bind(blogItems[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return blogItems.size
    }

    fun submitList(blogs: List<BlogPost>) {
        blogItems = blogs
    }

    // Describes an item view
    class BlogViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val blogImage = itemView.image_blog_image
        val blogTitle = itemView.text_blog_title
        val blogAuthor = itemView.text_blog_author

        fun bind(blogPost: BlogPost) {
            blogTitle.text = blogPost.title
            blogAuthor.text = blogPost.authorName

            // Get an image to load
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(blogPost.image)
                .into(blogImage)
        }
    }
}