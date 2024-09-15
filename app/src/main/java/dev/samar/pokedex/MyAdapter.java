package dev.samar.pokedex;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private final List<Pokemon> pokemonList;
    private final OnItemClickListener onItemClickListener;

    // Constructor
    public MyAdapter(List<Pokemon> pokemonList, OnItemClickListener onItemClickListener) {
        this.pokemonList = pokemonList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.activity_pokemons, parent, false); // Change to your layout resource
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.bind(pokemon);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(Pokemon pokemon);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPokemon;
        TextView txtName;
        ImageView imgType;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPokemon = itemView.findViewById(R.id.imgPokemon);
            txtName = itemView.findViewById(R.id.txtName);
            imgType = itemView.findViewById(R.id.imgType);


            // Set click listener for the item view
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    Pokemon pokemon = pokemonList.get(position);
                    onItemClickListener.onItemClick(pokemon);
                }
            });
        }

        public void bind(Pokemon pokemon) {
            txtName.setText(pokemon.getName());
            imgPokemon.setImageResource(pokemon.getImageId());
            imgType.setImageResource(pokemon.getTypeId());

        }
    }
}
