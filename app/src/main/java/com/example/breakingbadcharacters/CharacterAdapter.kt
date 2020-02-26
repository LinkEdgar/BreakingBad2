package com.example.breakingbadcharacters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CharacterAdapter(var context: Context, var data: ArrayList<BreakingBadCharacter>): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){




    class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view){
        val charName = view.findViewById<TextView>(R.id.char_name)
        val actorName  =view.findViewById<TextView>(R.id.actor_name)
        val birthDate = view.findViewById<TextView>(R.id.birth_day)
        val nickname = view.findViewById<TextView>(R.id.nick_name)
        val charImage = view.findViewById<ImageView>(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.character_container, parent, false)
        return CharacterViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {

        val character = data[position]

        holder.charName.text = character.name
        holder.actorName.text = character.portrayed
        holder.nickname.text = character.nickname
        holder.birthDate.text = character.birthday
        Glide.with(context).load(character.img).into(holder.charImage)
    }
}