package dev.samar.pokedex;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Description extends AppCompatActivity {

    private List<Pokemon> pokemonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
        ImageView backArrow = findViewById(R.id.imageView2);

        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Description.this, MyList.class);
                finish();
            }
        });

        // Initialize the Pokémon list (can come from a database or API in real app)
        initializePokemonList();

        // Get the Pokémon ID from the intent
        int pokemonId = getIntent().getIntExtra("pokemonId", -1);

        // Find the Pokémon by ID
        Pokemon pokemon = getPokemonById(pokemonId);

        // Set up UI elements
        ImageView imgDetail = findViewById(R.id.imgDetail);
        TextView txtDetail = findViewById(R.id.txtDetail);

        // If the Pokémon exists, display its image and details
        if (pokemon != null) {
            imgDetail.setImageResource(pokemon.getImageId()); // Set the Pokémon image
            txtDetail.setText(pokemon.getDetailId());         // Set the Pokémon details
        }
    }

    // Dummy Pokémon list - in real apps, this should come from a database or API
    private void initializePokemonList() {
        pokemonList = new ArrayList<>();
        pokemonList.add(new Pokemon(1, "Pikachu", R.drawable.pikachu, R.drawable.electric, "Pikachu are small, and cute mouse-like Pokémon. They are almost completely covered by yellow fur. They have long yellow ears that are tipped with black."));
        pokemonList.add(new Pokemon(2, "Charizard", R.drawable.squirtle, R.drawable.fire, "Charmander is a bipedal, reptilian Pokémon. Most of its body is colored orange, while its underbelly is light yellow and it has blue eyes. It has a flame at the end of its tail, which is said to signify its health."));
        pokemonList.add(new Pokemon(3, "Bulbasaur", R.drawable.bulbasaur, R.drawable.grass, "Bulbasaur are small, amphibian and plant Pokémon that move on all four legs. They have blue-green bodies with darker blue-green spots. The seed on a Bulbasaur's back is planted at birth and then sprouts and grows along with it. The bulb absorbs sunlight which allows it to grow."));
    }

    // Method to find Pokémon by its ID
    private Pokemon getPokemonById(int id) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getId() == id) {
                return pokemon;
            }
        }
        return null; // Return null if Pokémon is not found
    }
}
