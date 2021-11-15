//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="lexicon")
@XmlType(
    name = "lexiconType",
    propOrder = {"ar"}
)
public class LexiconType {
    protected List<ArType> ar;

    public LexiconType() {
    }

    public List<ArType> getAr() {
        if (this.ar == null) {
            this.ar = new ArrayList();
        }

        return this.ar;
    }
}
