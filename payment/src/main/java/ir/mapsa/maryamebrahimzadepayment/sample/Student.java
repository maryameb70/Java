package ir.mapsa.maryamebrahimzadepayment.sample;

import lombok.Data;

import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Student {
    private String name;
    private String family;
    private List<String> address = new ArrayList();

    public void addAddress(String address){
        this.getAddress().add(address);
    }
}
