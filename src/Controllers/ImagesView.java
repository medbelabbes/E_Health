package Controllers;

/**
 * Created by amjad on 11/06/2018.
 */
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class ImagesView {

    private List<String> images;

    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            images.add("doctor" + i + ".jpg");
        }
    }

    public List<String> getImages() {
        return images;
    }
}