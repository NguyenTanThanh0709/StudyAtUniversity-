class ImageLoader{
    private static ImageLoader ImageLoaderInstance = null;

    private ImageLoader(){}

    public static ImageLoader getImageLoaderInstance(){
        if(ImageLoaderInstance == null){
            ImageLoaderInstance = new ImageLoader();
        }
        return ImageLoaderInstance;
    }

    public String loadImage(){
        return "Image Loaded successfully";
    }
}