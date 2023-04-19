package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class PokemonMetadataProviderTest{
    PokemonMetadata pokemonMetadata;
    PokemonMetadata result;
    IPokemonMetadataProvider metadataProvider;
    @Before
    public void init(){
        metadataProvider= Mockito.mock(IPokemonMetadataProvider.class);
        result=new PokemonMetadata(1,"flame",20,5,2);

    }
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        when(metadataProvider.getPokemonMetadata(anyInt())).thenReturn(new PokemonMetadata(1,"flame",20,5,2));

        pokemonMetadata = metadataProvider.getPokemonMetadata(1);
        assertEquals(result.getName(),pokemonMetadata.getName());
        assertEquals(result.getAttack(),pokemonMetadata.getAttack());
        assertEquals(result.getDefense(),pokemonMetadata.getDefense());
        assertEquals(result.getStamina(),pokemonMetadata.getStamina());

    }


}
