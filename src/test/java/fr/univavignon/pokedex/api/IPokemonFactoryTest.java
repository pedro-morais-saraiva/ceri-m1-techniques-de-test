package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {
    Pokemon pikachu;
    @Mock
    IPokemonFactory factory;
    @Before
    public  void init(){
        pikachu=new Pokemon(1,"pikachu" ,10,20,5,15,150,12,4,5);
        factory= Mockito.mock(IPokemonFactory.class);
        when(factory.createPokemon(1,15,150,12,4)).thenReturn(pikachu);
    }

    @Test
    public void createPokemonTest(){
        Assert.assertEquals(pikachu,factory.createPokemon(1,15,150,12,4));

    }
}
