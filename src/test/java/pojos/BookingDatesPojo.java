package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingDatesPojo {

    //INNER POJO

    /*
    "bookingdates": {
              "checkin": "2013-02-23",
              "checkout": "2014-10-23"
          },
     */

    //1)Tum keyler icin private variable lar olusturuyoruz
    //2)Tum paramatrelere ve paremetresiz constractor lar olusturuyoruz
    //3)Public getter setter methodlarini olusturuyoruz
    //4)To stringle yazdiriyoruz

    private String checkin ;
    private String checkout ;



    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }


    public BookingDatesPojo() {
    }

    public BookingDatesPojo(String checkin, String checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    @Override
    public String toString() {
        return "Bookingdates{" +
                "checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                '}';
    }
}
