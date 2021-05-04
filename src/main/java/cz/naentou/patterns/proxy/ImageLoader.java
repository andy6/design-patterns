package cz.naentou.patterns.proxy;

/**
 * @author Andy <borec(at)naentou.cz>
 */
public class ImageLoader implements Image {

    private final String imageName;

    public ImageLoader(String imageName) {
        this.imageName = imageName;

        loadImage();
    }

    private void loadImage() {
        System.out.println("Please wait, image '"+imageName+"' is loading...");
    }

    @Override
    public void showImage() {
        System.out.println("Rendering image '"+imageName+"'...");
    }
}
