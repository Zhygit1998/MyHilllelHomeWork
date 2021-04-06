package lesson6;



public class AbonentData implements SortedFilter{
    private int id;
    private String lastName;
    private String name;
    private String surName;
    private String address;
    private int phoneNumber;
    private int numberOfCard;
    private int debet;
    private int credit;
    private int timeCityCalls;
    private int timeIntercityCalls;
    private int traficOfInternet;

    public AbonentData(int id, String lastName, String name, String surName, String address, int phoneNumber, int numberOfCard, int debet,
                       int credit, int timeCityCalls, int timeIntercityCalls, int traficOfInternet) {
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.numberOfCard = numberOfCard;
        this.debet = debet;
        this.credit = credit;
        this.timeCityCalls = timeCityCalls;
        this.timeIntercityCalls = timeIntercityCalls;
        this.traficOfInternet = traficOfInternet;


    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getAddress() {
        return address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfCard() {
        return numberOfCard;
    }

    public int getDebet() {
        return debet;
    }

    public int getCredit() {
        return credit;
    }

    public int getTimeCityCalls() {
        return timeCityCalls;
    }

    public int getTimeIntercityCalls() {
        return timeIntercityCalls;
    }

    public int getTraficOfInternet() {
        return traficOfInternet;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setNumberOfCard(int numberOfCard) {
        this.numberOfCard = numberOfCard;
    }

    public void setDebet(int debet) {
        this.debet = debet;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public void setTimeCityCalls(int timeCityCalls) {
        this.timeCityCalls = timeCityCalls;
    }

    public void setTimeIntercityCalls(int timeIntercityCalls) {
        this.timeIntercityCalls = timeIntercityCalls;
    }

    public void setTraficOfInternet(int traficOfInternet) {
        this.traficOfInternet = traficOfInternet;
    }

    @Override
    public String toString() {
        return "AbonentData{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", numberOfCard=" + numberOfCard +
                ", debet=" + debet +
                ", credit=" + credit +
                ", timeCityCalls=" + timeCityCalls +
                ", timeIntercityCalls=" + timeIntercityCalls +
                ", traficOfInternet=" + traficOfInternet +
                '}';
    }


    @Override
    public void sortedLimitCityCalls(int limit) {
        if (this.getTimeCityCalls() > limit) {
            System.out.println("ИД - "+ getId() + ", Фамилия " + getLastName() + ", Имя " + getName() + ", Отчество " + getSurName() + ", Адресс " + getAddress() + ", Номер телефона" + getPhoneNumber()
                    + ", Номер карты " + getNumberOfCard() + ", Дебет " + getDebet() + ", Кредит " + getCredit() + ", Городские звонки " + getTimeCityCalls() + ", Звонки Межгород " + getTimeIntercityCalls() + ",  Интернет трафик " + getTraficOfInternet());
        }
    }

    @Override
    public void sortedUseInterCityCalls() {
        if (this.getTimeIntercityCalls() > 0) {
            System.out.println("ИД - "+ getId() + ", Фамилия " + getLastName() + ", Имя " + getName() + ", Отчество " + getSurName() + ", Адресс " + getAddress() + ", Номер телефона" + getPhoneNumber()
                    + ", Номер карты " + getNumberOfCard() + ", Дебет " + getDebet() + ", Кредит " + getCredit() + ", Городские звонки " + getTimeCityCalls() + ", Звонки Межгород " + getTimeIntercityCalls() + ",  Интернет трафик " + getTraficOfInternet());
        }
    }

    @Override
    public void sortedInformation() {
        System.out.println("ИД - "+ getId() + ", Фамилия " + getLastName() + ", Имя " + getName() + ", Отчество " + getSurName() + ", Адресс " + getAddress() + ", Номер телефона" + getPhoneNumber()
                + ", Номер карты " + getNumberOfCard() + ", Дебет " + getDebet() + ", Кредит " + getCredit() + ", Городские звонки " + getTimeCityCalls() + ", Звонки Межгород " + getTimeIntercityCalls() + ",  Интернет трафик " + getTraficOfInternet());
    }
}
