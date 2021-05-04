package cz.naentou.patterns.proxy;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ImageProxy implements Image {

    private final String imageName;
    private ImageLoader imageLoader;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void preview() {
        // load and create image only when it is required
        if (imageLoader == null) {
            imageLoader = new ImageLoader(imageName);
        }
        imageLoader.preview();
    }

    @Override
    public void thumbnail() {
        // load and create image only when it is required
        if (imageLoader == null) {
            imageLoader = new ImageLoader(imageName);
        }
        imageLoader.thumbnail();
    }
}
