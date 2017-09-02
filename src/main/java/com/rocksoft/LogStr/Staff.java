package com.rocksoft.LogStr; /**
 * Created by Esenin on 26.08.2017.
 */

import com.fasterxml.jackson.annotation.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "staff")
public class Staff {


    @JsonProperty("workers")
    private List<Worker> workerList;
    @JsonProperty("administration")
    private List<Administration> administationList;

    public List<Worker> getWorkerList() {
        return workerList;
    }

    @XmlElementWrapper(name = "workers")
    @XmlElement(name = "worker")
    public void setWorkerList(List<Worker> workerList) {
        this.workerList = workerList;
    }

    public List<Administration> getAdministationList() {
        return administationList;
    }

    @XmlElementWrapper(name = "administration")
    @XmlElement(name = "admin")
    public void setAdministationList(List<Administration> administationList) {
        this.administationList = administationList;
    }
}