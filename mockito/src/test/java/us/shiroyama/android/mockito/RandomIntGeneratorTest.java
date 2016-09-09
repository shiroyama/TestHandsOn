package us.shiroyama.android.mockito;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * {@link RandomIntGenerator}のテスト
 */
public class RandomIntGeneratorTest {
    private RandomIntGenerator randomIntGenerator;

    @Mock
    RandomIntGenerator randomIntGeneratorWithAnnotation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(randomIntGeneratorWithAnnotation.generate()).thenReturn(456);

        randomIntGenerator = Mockito.mock(RandomIntGenerator.class);
        Mockito.when(randomIntGenerator.generate()).thenReturn(123);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void generateの結果をmockしてテスト可能にする() {
        int expected = randomIntGenerator.generate();
        assertThat(expected, is(123));

        expected = randomIntGeneratorWithAnnotation.generate();
        assertThat(expected, is(456));
    }
}
