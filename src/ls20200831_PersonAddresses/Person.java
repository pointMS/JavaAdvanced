package ls20200831_PersonAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String firstName;
    private String secondName;
    private List<PersonAddress> addresses; //переменная, которая будет указывать на список

    public Person(String firstName, String secondName, List<PersonAddress> addresses) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.addresses = addresses;
    }

    public Person(String firstName, String secondName) { //персона БЕЗ списка адресов, надо выделить для него память
//        this.firstName = Objects.requireNonNull(firstName); //тот же вариант
//        this.secondName = secondName;

        if (firstName != null) {
            this.firstName = firstName;
            this.secondName = secondName;
        } else {
            throw new IllegalArgumentException(); //если пришел null, объект не создается. Объект сам контролирует свою целостность
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public List<PersonAddress> getAddresses() {
        return new ArrayList<>(addresses); //для защиты - создаем копию листа
    }

    public List<PersonAddress> getAddresses(String type) { //для получения списка адресов с заданным типом
        List<PersonAddress> res = new ArrayList<>();
        for (PersonAddress address : addresses) {
            if (address.getType().equals(type)) {
                res.add(address);
            }
        }
        return res;
    }

    public void addAddress(PersonAddress address) {
        if (address != null) { //проверка исходного параметра
            if (addresses == null) { //проверка, существует ли уже лист, куда мы хотим записать адрес
                addresses = new ArrayList<>();
            }
            addresses.add(address);
        }
    }

    @Override
    public String toString() {
        return firstName + " " + secondName + addresses;
    }
}