package server.models;

public class Event {

    private int idEvent;
    private int pris;
    private int event_idUser;
    private String kunde;
    private String saelger;
    private int gaester;
    private int bartendere;
    private int timer;
    private String status;
    private int dag;
    private int maaned;
    private int aar;



    public Event(int idEvent, int event_idUser, int pris, String kunde, String saelger,
                 int gaester, int bartendere, int timer, String status, int dag, int maaned, int aar) {
        this.idEvent = idEvent;
        this.event_idUser = event_idUser;
        this.pris = pris;
        this.kunde = kunde;
        this.saelger = saelger;
        this.gaester = gaester;
        this.bartendere = bartendere;
        this.timer = timer;
        this.status = status;
        this.dag = dag;
        this.maaned = maaned;
        this.aar = aar;

    }

    public Event() {

    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getPris() {
        return pris;
    }

    public void setPris(int pris) {
        this.pris = pris;
    }

    public int getEvent_idUser() {
        return event_idUser;
    }

    public void setEvent_idUser(int event_idUser) {
        this.event_idUser = event_idUser;
    }

    public String getKunde() {
        return kunde;
    }

    public void setKunde(String kunde) {
        this.kunde = kunde;
    }

    public String getSaelger() {
        return saelger;
    }

    public void setSaelger(String saelger) {
        this.saelger = saelger;
    }

    public int getGaester() {
        return gaester;
    }

    public void setGaester(int gaester) {
        this.gaester = gaester;
    }

    public int getBartendere() {
        return bartendere;
    }

    public void setBartendere(int bartendere) {
        this.bartendere = bartendere;
    }

    public int getTimer() {
        return timer;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getDag() {
        return dag;
    }

    public void setDag(int dag) {
        this.dag = dag;
    }

    public int getMaaned() {
        return maaned;
    }

    public void setMaaned(int maaned) {
        this.maaned = maaned;
    }

    public int getAar() {
        return aar;
    }

    public void setAar(int aar) {
        this.aar = aar;
    }


    }

