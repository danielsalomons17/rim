//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "arType",
    propOrder = {"k", "tr"}
)
public class ArType {
    @XmlElement(
        required = true
    )
    protected String k;
    protected String tr;

    public ArType() {
    }

    public String getK() {
        return this.k;
    }

    public void setK(String value) {
        this.k = value;
    }

    public String getTr() {
        return this.tr;
    }

    public void setTr(String value) {
        this.tr = value;
    }
}
