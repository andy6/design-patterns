package cz.naentou.patterns.builder;

import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class BuilderTest {
    private Set<Size> originalSizeSet;
    private Product firstProduct;

    @BeforeEach
    void setUp() {
        this.originalSizeSet = Set.of(
                new Size("S"), new Size("M"),
                new Size("L"), new Size("XL"));

        Set<Size> firstSizeSet = Set.of(
                new Size("S"), new Size("M"),
                new Size("L"), new Size("XL"));
        this.firstProduct = new Product.Builder()
                .setId(1)
                .setName("First product name")
                .setSizes(firstSizeSet)
                .build();
    }

    @Test
    public void createEntityByBuilder() {
        assertEquals(firstProduct.getId(), 1);
        assertEquals(firstProduct.getName(), "First product name");
        assertEquals(firstProduct.getSizes(), originalSizeSet);
    }

    @Test
    public void createEntityFromExistingOne() {
        Product secondProduct = new Product.Builder().from(firstProduct).setId(2).build();

        assertEquals(secondProduct.getId(), 2);
        assertEquals(secondProduct.getName(), "First product name");
        assertEquals(secondProduct.getSizes(), originalSizeSet);
    }

    @Test
    public void itIsPossibleToChangeSetObject() {
        firstProduct.getSizes().forEach(size ->
                size.setValue(size.getValue() + " changed"));

        originalSizeSet.forEach(size ->
                assertFalse(firstProduct.getSizes().contains(size))
        );
    }

    @Test
    public void itIsPossibleToChangeUnmodifiableSetObject() {
        firstProduct.getUnmodifiableSizes().forEach(size ->
                size.setValue(size.getValue() + " changed"));

        originalSizeSet.forEach(size ->
                assertFalse(firstProduct.getUnmodifiableSizes().contains(size))
        );
    }

    @Test
    public void itIsNOTPossibleToChangeClonedSetObject() {
        firstProduct.getClonedSizes().forEach(size ->
                size.setValue(size.getValue() + " changed"));

        originalSizeSet.forEach(size ->
            assertTrue(firstProduct.getClonedSizes().contains(size))
        );
    }
}
