package pojos;


public class Bookingdates {

    /*
    "bookingdates": {
              "checkin": "2013-02-23",
              "checkout": "2014-10-23"
          },
     */

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


    public Bookingdates() {
    }

    public Bookingdates(String checkin, String checkout) {
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
