package lzy.demo;

/**
 *
 * Created by bukeyan on 2017/5/13.
 */

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Student {
    private int id;
    private String name;

    public Student() {
    }

    public String getName() {
        return name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }

}