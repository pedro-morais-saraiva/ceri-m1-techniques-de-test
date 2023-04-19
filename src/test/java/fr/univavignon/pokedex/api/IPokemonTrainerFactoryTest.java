import fr.univavignon.pokedex.api.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonTrainerFactoryTest {
    @Mock
    IPokedex pokedex;
    @Mock
    IPokemonTrainerFactory pokemonTrainerFactory;
    @Mock
    IPokedexFactory pokedexFactory ;
    @Before
    public void init(){
        pokedex=Mockito.mock(IPokedex.class);
        pokemonTrainerFactory=Mockito.mock(IPokemonTrainerFactory.class);
        pokedexFactory=Mockito.mock(IPokedexFactory.class);
    }

    @Test
    public void createTrainer(){
        PokemonTrainer pokemonTrainer=new PokemonTrainer("valorant" , Team.VALOR,pokedex);
        when(pokemonTrainerFactory.createTrainer("valorant",Team.VALOR,pokedexFactory)).thenReturn(pokemonTrainer);
        Assert.assertEquals("valorant",pokemonTrainerFactory.createTrainer("valorant",Team.VALOR,pokedexFactory).getName());
    }
}
