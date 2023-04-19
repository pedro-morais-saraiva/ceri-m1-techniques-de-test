package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;



public class IPokedexTest {
    ArrayList<Pokemon> listPokemon=new  ArrayList<Pokemon> ();
    @Mock
    IPokedex iPokedex;
    @Before
    public  void init(){
        iPokedex= Mockito.mock(IPokedex.class);
        listPokemon.add(new Pokemon(1,"pikachu" ,10,20,5,15,150,12,4,5));
        listPokemon.add(new Pokemon(2,"wadih" ,10,20,5,15,150,12,4,5));
        listPokemon.add(new Pokemon(3,"salameche" ,10,20,5,15,150,12,4,5));
    }

    @Test
    public void size(){
        when(iPokedex.size()).thenReturn(listPokemon.size());
        Assert.assertEquals(3,iPokedex.size());
    }

    @Test
    public void addPokemon(){
        Pokemon pokemon= new Pokemon(1,"london" ,10,20,5,15,150,12,4,5);

        when(iPokedex.addPokemon(pokemon)).thenReturn(listPokemon.size()+1);
        Assert.assertEquals(listPokemon.size()+1,iPokedex.addPokemon(pokemon));
    }
    @Test
    public void getPokemon() throws PokedexException {
        Pokemon pika=new Pokemon(1,"pikachu" ,10,20,5,15,150,12,4,5);
        when(iPokedex.getPokemon(1)).thenReturn(listPokemon.get(0));
        when(iPokedex.getPokemon(2)).thenReturn(listPokemon.get(1));
        when(iPokedex.getPokemon(3)).thenReturn(listPokemon.get(2));


        Assert.assertEquals(pika.getName(),iPokedex.getPokemon(1).getName());
    }

    @Test
    public void getPokemons (){
        when(iPokedex.getPokemons()).thenReturn(listPokemon);
        Assert.assertEquals(listPokemon,iPokedex.getPokemons());
    }
    @Test
    public void getPokemonsSort(){
        PokemonComparators name = PokemonComparators.NAME;
        PokemonComparators index = PokemonComparators.INDEX;
        PokemonComparators cp = PokemonComparators.CP;
        List<Pokemon> listeTrieParCP = new ArrayList<>(this.listPokemon);
        listeTrieParCP.sort(cp);
        List<Pokemon> listeTrieParNom = new ArrayList<>(this.listPokemon);
        listeTrieParNom.sort(name);
        List<Pokemon> listeTrieParIndex = new ArrayList<>(this.listPokemon);
        listeTrieParIndex.sort(index);
        when(iPokedex.getPokemons(cp)).thenReturn(listeTrieParCP);
        when(iPokedex.getPokemons(name)).thenReturn(listeTrieParNom);
        when(iPokedex.getPokemons(index)).thenReturn(listeTrieParIndex);
        Assert.assertEquals(iPokedex.getPokemons(name),listeTrieParNom);

    }

}
