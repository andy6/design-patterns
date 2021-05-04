package cz.naentou.patterns.proxy;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ImageProxy implements Image {

    private final String imageName;

    public ImageProxy(String imageName) {
        this.imageName = imageName;
        System.out.println("Image '"+imageName+"' has not been loaded yet...");
    }

    @Override
    public void showImage() {
        // load and create image only when it is required
        ImageLoader imageLoader = new ImageLoader(imageName);
        imageLoader.showImage();
    }
}
