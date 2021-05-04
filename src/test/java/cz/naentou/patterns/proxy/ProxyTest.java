package cz.naentou.patterns.proxy;

import org.junit.jupiter.api.Test;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ProxyTest {

    @Test
    public void givenImages_whenShowOneOfThem_thenRenderOnlyOne() {
        Image imageProxy1 = new ImageProxy("image1.jpg");
        Image imageProxy2 = new ImageProxy("image2.jpg");
        Image imageProxy3 = new ImageProxy("image3.jpg");

        // render the image only when it is required
        imageProxy2.preview();
        imageProxy2.thumbnail();
    }

    @Test
    public void givenImages_whenShowOneOfThem_thenLoadAllOfThem() {
        Image imageLoader1 = new ImageLoader("image1.jpg");
        Image imageLoader2 = new ImageLoader("image2.jpg");
        Image imageLoader3 = new ImageLoader("image3.jpg");

        // all of images were rendered
        // this solution is a waste of time and memory resources
        imageLoader3.preview();
        imageLoader3.thumbnail();
    }
}
