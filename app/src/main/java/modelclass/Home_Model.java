package modelclass;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class Home_Model {

    int imageshose,imagequiz,imagetopic,prodid;
    String textquiz,texttopic,name;
    public int getImageshose() {
        return imageshose;
    }

    public void setImagequiz(int imagequiz) {
        this.imagequiz = imagequiz;
    }
    public int getImagequiz() {
        return imagequiz;
    }

    public void setImagetopic(int imagetopic) {
        this.imagetopic = imagetopic;
    }
    public int getImagetopic() {
        return imagetopic;
    }

    public void setImageshose(int imageshose) {
        this.imageshose = imageshose;
    }

    public void setTextquiz(String s){this.textquiz=s;}
    public String getTextquiz() {
        return textquiz;
    }

    public void setTexttopic(String discount) {
        this.texttopic = discount;
    }

    public String getTexttopic() {
        return texttopic;
    }

    public void setName(String discount) {
        this.name = discount;
    }
public int getProductId(){return prodid;}
    public String getName() {
        return name;
    }

    public Home_Model(int imageshose,int imagequiz,int imagetopic, String name,  String textquiz, String texttopic,int prdid) {
this.prodid=prdid;
        this.imageshose = imageshose;
       this.imagequiz = imagequiz;
       this.imagetopic = imagetopic;
       this.name = name;
       this.textquiz = textquiz;
       this.texttopic = texttopic;
    }


}
