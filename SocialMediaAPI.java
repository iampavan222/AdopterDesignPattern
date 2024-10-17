package design.structural.adopter;

public interface SocialMediaAPI {
    void postImage(String imagePath);


    public static void main(String[] args) {
        SocialMediaAPI instagram = SocialMediaFactor.uploadImagesMediaFactory("instagram");
        instagram.postImage("./images/photo.jpeg");

        SocialMediaAPI tiktok = SocialMediaFactor.uploadImagesMediaFactory("tiktok");
        tiktok.postImage("./images/photo2.jpeg");

    }
}

class Instagram {
    public void uploadPostImage(String image) {
        System.out.println("Photo uploaded to Instagram: " + image);
    }
}

class InstagramAdopter implements SocialMediaAPI {
    private Instagram instagram;

    InstagramAdopter(Instagram instagram) {
        this.instagram = instagram;
    }

    @Override
    public void postImage(String imagePath) {
        instagram.uploadPostImage(imagePath);
    }
}


class TikTok {
    public void uploadNewImages(String images) {
        System.out.println("Photo uploaded to TikTok: " + images);
    }
}

class TikTokAdopter implements SocialMediaAPI {
    private TikTok tikTok;

    TikTokAdopter(TikTok tikTok) {
        this.tikTok = tikTok;
    }

    @Override
    public void postImage(String imagePath) {
        tikTok.uploadNewImages(imagePath);
    }
}


class SocialMediaFactor {
    public static SocialMediaAPI uploadImagesMediaFactory(String mediaType) {
        return switch (mediaType) {
            case "instagram" -> new InstagramAdopter(new Instagram());
            case "tiktok" -> new TikTokAdopter(new TikTok());
            default -> throw new IllegalArgumentException("UnSupported Social Media Api");
        };
    }
}
