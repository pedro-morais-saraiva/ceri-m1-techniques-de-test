package fr.univavignon.pokedex.api;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokedexFactoryTest {
    @Mock

    IPokedexFactory iPokedexFactory;
    @Test
    public void createPokedex(){
        iPokedexFactory = Mockito.mock(IPokedexFactory.class);
        IPokemonMetadataProvider metadataProvider=Mockito.mock(IPokemonMetadataProvider.class);
        IPokemonFactory factory=Mockito.mock(IPokemonFactory.class);
        IPokedex pokedex=Mockito.mock(IPokedex.class);
        when(iPokedexFactory.createPokedex(Mockito.any(metadataProvider.getClass()),Mockito.any(factory.getClass()))).thenReturn(pokedex);
        Assert.assertEquals(pokedex,iPokedexFactory.createPokedex(metadataProvider,factory));
    }

}
