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
        System.out.println("[WAITING] Please wait, image '"+imageName+"' is loading...");
    }

    @Override
    public void preview() {
        System.out.println("Creating preview of image '"+imageName+"'...");
    }

    @Override
    public void thumbnail() {
        System.out.println("Creating thumbnail of image '"+imageName+"'...");
    }
}
