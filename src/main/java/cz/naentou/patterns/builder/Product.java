package cz.naentou.patterns.builder;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Product entity.
 */
public class Product {
    private int id;
    private String name;
    private Set<Size> sizes;

    public Product(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.sizes = builder.sizes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Size> getSizes() {
        // immutable set does not prevent to change size attribute
        return Collections.unmodifiableSet(sizes);

        // makes shallow copy of Set
        // return Set.copyOf(sizes);
    }

    public Set<Size> getUnmodifiableSizes() {
        // immutable set does not prevent to change size attribute
        return Collections.unmodifiableSet(sizes);

        // makes shallow copy of Set
        // return Set.copyOf(sizes);
    }

    public Set<Size> getClonedSizes() {
        // Java does not support deep copying by default
        return sizes.stream()
                .map(size -> (Size) size.clone())
                .collect(Collectors.toSet());
    }

    /**
     * Product Builder.
     */
    public static class Builder {
        private int id;
        private String name;
        private Set<Size> sizes = new HashSet<>();

        public Builder from(Product product) {
            this.id = product.id;
            this.name = product.name;
            this.sizes = product.sizes;

            return this;
        }

        public Builder setId(int id) {
            this.id = id;

            return this;
        }

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setSizes(Set<Size> sizes) {
            this.sizes = sizes;

            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
